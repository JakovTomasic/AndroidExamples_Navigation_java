package hr.riteh.navigation.parcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import hr.riteh.navigation.R;

public class ParcelableActivity extends AppCompatActivity {

    public static final String INTENT_KEY_TEXT = "bilo_koji_text";
    public static final String INTENT_KEY_COMPLEX = "bilo_koji_text_ali_da_nije_isti";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);

        Intent intent = getIntent();
        Log.e("AAAA", "intenttt " + intent);
        if (intent != null) {
            String text = intent.getStringExtra(INTENT_KEY_TEXT);
            Log.e("AAAA", "text " + text);
            ParcelableClass student = intent.getParcelableExtra(INTENT_KEY_COMPLEX);
            Log.e("AAAA", "student " + student);
            if (text != null && student != null) {
                String textToShow = text + "\nId: " + student.id + "\nime: " + student.name + "\nocjena: " + student.grade;

                TextView textView = findViewById(R.id.parcelable_result);
                textView.setText(textToShow);
            } else {
                finish();
            }
        } else {
            finish();
        }
    }
}