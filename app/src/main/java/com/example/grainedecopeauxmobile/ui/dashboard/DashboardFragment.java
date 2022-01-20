package com.example.grainedecopeauxmobile.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.grainedecopeauxmobile.R;
import com.example.grainedecopeauxmobile.databinding.FragmentDashboardBinding;
import com.example.grainedecopeauxmobile.ui.profil.ProfilFragment;

public class DashboardFragment extends Fragment {
    private Button boutonPlus;
    private Button boutonMoins;
    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;
    public static TextView textScore;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


       
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view,Bundle savedInstanceState)
    {
        textScore = (TextView)  getView().findViewById(R.id.text_score);
        DashboardFragment.textScore.setText("Score:\n "+ ProfilFragment.score);


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}