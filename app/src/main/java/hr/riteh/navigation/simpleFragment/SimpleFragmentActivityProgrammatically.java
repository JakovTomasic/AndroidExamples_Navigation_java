package hr.riteh.navigation.simpleFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import hr.riteh.navigation.R;

public class SimpleFragmentActivityProgrammatically extends AppCompatActivity {

    public SimpleFragmentActivityProgrammatically() {
        super(R.layout.activity_simple_fragment_programatically);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, SimpleFragment.class, null)
                    .commit();
        }
    }
}