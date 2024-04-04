package hr.riteh.navigation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import hr.riteh.navigation.graph.GraphActivity;
import hr.riteh.navigation.navigationTemplateCode.BottomNavigationViewsActivity;
import hr.riteh.navigation.parcelable.ParcelableActivity;
import hr.riteh.navigation.parcelable.ParcelableClass;
import hr.riteh.navigation.simpleFragment.SimpleFragmentActivityProgrammatically;
import hr.riteh.navigation.simpleFragment.SimpleFragmentActivityXml;
import hr.riteh.navigation.viewpager2.ViewPager2Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ovo su samo buttoni za otvaranje razlicitih primjera

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

        Button viewPager2 = findViewById(R.id.view_pager_2);
        viewPager2.setOnClickListener(v -> {
            Intent intent = new Intent(this, ViewPager2Activity.class);
            intent.putExtra(ViewPager2Activity.INTENT_KEY_SHOW_TABS, false);
            startActivity(intent);
        });

        Button viewPager2Tabs = findViewById(R.id.view_pager_2_tabs);
        viewPager2Tabs.setOnClickListener(v -> {
            Intent intent = new Intent(this, ViewPager2Activity.class);
            intent.putExtra(ViewPager2Activity.INTENT_KEY_SHOW_TABS, true);
            startActivity(intent);
        });

        openActivityWhenButtonIsPressed(R.id.graph, GraphActivity.class);

        Button googleMaps = findViewById(R.id.google_maps);
        googleMaps.setOnClickListener(v -> {
            float latitude = 45.337621f;
            float longitude = 14.425524f;
            String label = "RiTeh";
            String coords = latitude + "," + longitude;
            Uri gmmIntentUri = Uri.parse("geo:" + coords + "?q=" + coords + "(" + label + ")");
            Intent intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            // Odkomentirajte ovu liniju ispod da se lokacija automatski otvori u google maps aplikaciji.
            // Bez linije ispod ce vas android sustav pitati u kojoj aplikaciji zelite otvoriti activity.
//            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        });
    }

    private void openActivityWhenButtonIsPressed(int buttonId, Class<?> activityClass) {
        Button bottomNavigation = findViewById(buttonId);
        bottomNavigation.setOnClickListener(v -> {
            Intent intent = new Intent(this, activityClass);
            startActivity(intent);
        });
    }

}