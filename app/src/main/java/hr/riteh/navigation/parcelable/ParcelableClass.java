package hr.riteh.navigation.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

// Student
public class ParcelableClass implements Parcelable {
    public String id;
    public String name;
    public String grade;

    // Constructor
    public ParcelableClass(String id, String name, String grade){
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // Parcelling part
    public ParcelableClass(Parcel in){
        // the order needs to be the same as in writeToParcel() method
        this.id = in.readString();
        this.name = in.readString();
        this.grade = in.readString();
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.grade);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ParcelableClass createFromParcel(Parcel in) {
            return new ParcelableClass(in);
        }

        public ParcelableClass[] newArray(int size) {
            return new ParcelableClass[size];
        }
    };
}
