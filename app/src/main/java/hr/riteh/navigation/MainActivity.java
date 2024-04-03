package hr.riteh.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import hr.riteh.navigation.navigationTemplateCode.BottomNavigationViewsActivity;
import hr.riteh.navigation.parcelable.ParcelableActivity;
import hr.riteh.navigation.parcelable.ParcelableClass;
import hr.riteh.navigation.simpleFragment.SimpleFragmentActivityProgrammatically;
import hr.riteh.navigation.simpleFragment.SimpleFragmentActivityXml;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lifecycle = findViewById(R.id.lifecycle_example);
        lifecycle.setOnClickListener(v -> {
            Intent intent = new Intent(this, LifecycleActivity.class);
            startActivity(intent);
        });

        EditText editText = findViewById(R.id.parcelable_edit_text);

        Button parcelable = findViewById(R.id.parcelable_example);
        parcelable.setOnClickListener(v -> {
            Intent intent = new Intent(this, ParcelableActivity.class);
            intent.putExtra(ParcelableActivity.INTENT_KEY_TEXT, editText.getText().toString());
            ParcelableClass student = new ParcelableClass("1024", "Neko ime", "5");
            intent.putExtra(ParcelableActivity.INTENT_KEY_COMPLEX, student);
            startActivity(intent);
        });


        openActivityWhenButtonIsPressed(R.id.fragments_example_xml, SimpleFragmentActivityXml.class);
        openActivityWhenButtonIsPressed(R.id.fragments_example_programmatically, SimpleFragmentActivityProgrammatically.class);
        openActivityWhenButtonIsPressed(R.id.bottom_navigation, BottomNavigationViewsActivity.class);

    }

    private void openActivityWhenButtonIsPressed(int buttonId, Class<?> activityClass) {
        Button bottomNavigation = findViewById(buttonId);
        bottomNavigation.setOnClickListener(v -> {
            Intent intent = new Intent(this, activityClass);
            startActivity(intent);
        });
    }

}