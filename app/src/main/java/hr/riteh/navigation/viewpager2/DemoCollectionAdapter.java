package hr.riteh.navigation.viewpager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.security.InvalidParameterException;

import hr.riteh.navigation.navigationTemplateCode.ui.dashboard.DashboardFragment;
import hr.riteh.navigation.navigationTemplateCode.ui.home.HomeFragment;
import hr.riteh.navigation.navigationTemplateCode.ui.notifications.NotificationsFragment;

public class DemoCollectionAdapter extends FragmentStateAdapter {
    public DemoCollectionAdapter(FragmentActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Koristim fragmente iz drugog primjera kako ne bih morao raditi nove.
        // Ovdje može biti bilo koji fragment.
        switch (position) {
            case 0:
                return new DashboardFragment();
            case 1:
                return new HomeFragment();
            case 2:
                return new NotificationsFragment();
            default:
                throw new InvalidParameterException();
        }

        // Fragmentima ovdje možemo i slati dodatne podatke. Vidi default generirani primjer ispod:
//        Fragment fragment = new DemoObjectFragment();
//        Bundle args = new Bundle();
//        args.putInt(DemoObjectFragment.ARG_OBJECT, position + 1);
//        fragment.setArguments(args);
//        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

