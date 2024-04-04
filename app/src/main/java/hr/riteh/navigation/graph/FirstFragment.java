package hr.riteh.navigation.graph;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import hr.riteh.navigation.R;
import hr.riteh.navigation.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(v -> {
            NavController controller = NavHostFragment.findNavController(FirstFragment.this);
            controller.navigate(R.id.action_FirstFragment_to_SecondFragment);
        });
        binding.buttonSecond.setOnClickListener(v -> {
            NavController controller = NavHostFragment.findNavController(FirstFragment.this);
            controller.navigate(R.id.action_FirstFragment_to_sampleActivityDestination);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}