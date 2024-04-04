package hr.riteh.navigation.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import hr.riteh.navigation.R;

public class ViewPager2Activity extends AppCompatActivity {

    public static final String INTENT_KEY_SHOW_TABS = "show_tabs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);

        Intent intent = getIntent();
        if (intent != null) {
            boolean showTabs = intent.getBooleanExtra(INTENT_KEY_SHOW_TABS, false);

            DemoCollectionAdapter demoCollectionAdapter = new DemoCollectionAdapter(this);
            ViewPager2 viewPager = findViewById(R.id.pager);
            viewPager.setAdapter(demoCollectionAdapter);

            TabLayout tabLayout = findViewById(R.id.tab_layout);
            if (showTabs) {
                tabLayout.setVisibility(View.VISIBLE);
                new TabLayoutMediator(tabLayout, viewPager,
                        (tab, position) -> tab.setText("TAB " + (position + 1))
                ).attach();
            } else {
                tabLayout.setVisibility(View.GONE);
            }

        } else {
            finish();
        }
    }
}