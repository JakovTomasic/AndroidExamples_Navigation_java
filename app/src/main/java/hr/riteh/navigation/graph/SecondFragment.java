package hr.riteh.navigation.graph;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import hr.riteh.navigation.R;
import hr.riteh.navigation.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    // Promijeni ovo i vidi razliku u aplikaciji kada je pokazan second fragment i kada stisnes back button
    private static final boolean SET_CUSTOM_BACK_PRESSED_CALLBACK = false;
    private FragmentSecondBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (SET_CUSTOM_BACK_PRESSED_CALLBACK) {
            // This callback will only be called when MyFragment is at least Started.
            OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
                @Override
                public void handleOnBackPressed() {
                    NavController controller = NavHostFragment.findNavController(SecondFragment.this);
                    controller.navigate(R.id.action_SecondFragment_to_FirstFragment);
                }
            };
            requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(v -> {
            NavController controller = NavHostFragment.findNavController(SecondFragment.this);
            controller.navigate(R.id.action_SecondFragment_to_FirstFragment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}