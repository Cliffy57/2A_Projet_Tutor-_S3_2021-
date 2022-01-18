package com.example.grainedecopeauxmobile.ui.profil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.grainedecopeauxmobile.R;
import com.example.grainedecopeauxmobile.databinding.FragmentProfilBinding;

public class ProfilFragment extends Fragment {

    public static int score =0;
    private NotificationsViewModel profilViewModel;
    private FragmentProfilBinding binding;
    private TextView textNomRang;
    private ImageView imageRang;
    private TextView textNomBadge;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profilViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentProfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view,Bundle savedInstanceState)
    {
        textNomRang= (TextView) getView().findViewById(R.id.textDescritpionRang);
        imageRang = (ImageView) getView().findViewById(R.id.img_rang);
        textNomBadge = (TextView) getView().findViewById(R.id.textDescritpionBadge);
        textNomBadge.setText("Aucun");

            if (score < 100) {
                textNomRang.setText("Bleuisaille");
                imageRang.setImageResource(R.drawable.rank_bleuisaille);
            }
                // imgView.set
            else if (score <200){
                textNomRang.setText("Noob");
                 imageRang.setImageResource(R.drawable.rank_noob);}
            else if (score <300){
                textNomRang.setText("Narvalo");
                imageRang.setImageResource(R.drawable.rank_narvalo);}
            else if (score <400) {
        textNomRang.setText("Bûcheron");
        imageRang.setImageResource(R.drawable.rank_bucheron);
    }
            else if (score <500){
                textNomRang.setText("Boiseux");
                imageRang.setImageResource(R.drawable.rank_boiseux);}
            else if (score <600){
                textNomRang.setText("Bec");
                imageRang.setImageResource(R.drawable.rank_bec);}
            else if (score <700){
                textNomRang.setText("Bois");
                imageRang.setImageResource(R.drawable.rank_bois);}
            else if (score <800){
                textNomRang.setText("Bob le bricoleur");
                imageRang.setImageResource(R.drawable.rank_bob_le_bricoleur);}
            else if (score <900){
                textNomRang.setText("MacGyver");
                imageRang.setImageResource(R.drawable.rank_mac_gyver);}
            else{
                textNomRang.setText("Boss du game");
                 imageRang.setImageResource(R.drawable.rank_boss_du_game);
                textNomBadge.setText("Assiduité");}
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}