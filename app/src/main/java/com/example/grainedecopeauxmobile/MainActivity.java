package com.example.grainedecopeauxmobile;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.grainedecopeauxmobile.databinding.ActivityMainBinding;
import com.example.grainedecopeauxmobile.ui.profil.ProfilFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


public class MainActivity extends AppCompatActivity {


    private static final String url = "jdbc:mysql://clgu6252.odns.fr:3306/clgu6252_wp571";
    private static final String user = "clgu6252_groupe_2";
    private static final String pass = ")$OYuZSjUo8R";
    Button btnFetch,btnClear;
    ImageView imgView ;
    TextView txtData;
    private ActivityMainBinding binding;
    //private int score = 0 ;
    Dialog dialog;
    private RadioButton radioButtonSelect;
    boolean questionRepondu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        txtData = (TextView) this.findViewById(R.id.txtData);
//        btnFetch = (Button) findViewById(R.id.btnFetch);
//        btnClear = (Button) findViewById(R.id.btnClear);
//        btnFetch.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                ConnectMySql connectMySql = new ConnectMySql();
//                connectMySql.execute("");
//            }
//        });
//        btnClear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                txtData.setText("");
//            }
//        });








        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_profil)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


    }
    ImageView imageView;
    public void OnclickLogin(View view){
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.fragment_login);

        imageView=(ImageView)dialog.findViewById(R.id.btn_close);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


    }

    public void onClickG2C(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.grainedecopeaux.com/"));
        startActivity(intent);
    }

    public void onClickInstagramG2C(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.instagram.com/grainedecopeaux/?hl=fr"));
        startActivity(intent);

    }

    public void onClickYoutubeG2C(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/channel/UC_TVzMGljJUHlhLG0dpXqdg"));
        startActivity(intent);


    }

    public void onClickCours(View view) {
        ConstraintLayout current_fragment = findViewById(R.id.fragment_dashboard);
//        current_fragment.setVisibility(View.GONE);
        current_fragment.removeAllViews();
        Fragment fragment = new Fragment(R.layout.fragment_cours);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_dashboard, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }





        //        NavController navController = Navigation.findNavController(this,R.id.fragment_cours);
        //        navController.navigate(R.id.fragment_dashboard);

//        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
//       transaction.replace(R.id.fragment_dashboard,new fragmentCours()).commit();

    public void onClickShop(View view) {
        Uri uri = Uri.parse("https://www.grainedecopeaux.com/boutique/"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void onClickYtb(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW,   Uri.parse("https://www.youtube.com/channel/UC_TVzMGljJUHlhLG0dpXqdg")));
    }
    public void onClickInstagram(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW,   Uri.parse("https://www.instagram.com/grainedecopeaux/?hl=fr")));
    }

    public void onClickQCM(View view) {
        ConstraintLayout current_fragment = findViewById(R.id.fragment_dashboard);
//      current_fragment.setVisibility(View.GONE);
        current_fragment.removeAllViews();
        Fragment fragment = new Fragment(R.layout.fragment_qcm);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_dashboard, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void onClickPDF(View view) {
        ConstraintLayout current_fragment = findViewById(R.id.fragment_qcm);
//      current_fragment.setVisibility(View.GONE);
        current_fragment.removeAllViews();
        Fragment fragment = new Fragment(R.layout.fragment_pdf);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_qcm, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @SuppressLint("ResourceAsColor")
    public void onClickValiderQcm(View view){

        RadioGroup radioGroup = findViewById(R.id.radioGroupQcm);
        RadioButton reponseVrai = findViewById(R.id.Reponse1);
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        View radioButton = radioGroup.findViewById(radioButtonID);
        int idx = radioGroup.indexOfChild(radioButton);
        radioButtonSelect = (RadioButton) radioGroup.getChildAt(idx);
        if (!questionRepondu){
            if(radioGroup.getCheckedRadioButtonId() == reponseVrai.getId())
            {
                reponseVrai.setBackgroundResource(R.color.greenPastel);
                ProfilFragment.score = ProfilFragment.score + 50;

            }
            else{
                reponseVrai.setBackgroundResource(R.color.greenPastel);
                radioButtonSelect.setBackgroundResource(R.color.red);
                if (ProfilFragment.score !=0)
                ProfilFragment.score = ProfilFragment.score -50;
            }
        }

        questionRepondu = true;
    }

    public void onClickQCMReturn(View view) {
        ConstraintLayout current_fragment = findViewById(R.id.fragment_qcm_ex);
//      current_fragment.setVisibility(View.GONE);
        current_fragment.removeAllViews();
        Fragment fragment = new Fragment(R.layout.fragment_qcm);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_qcm_ex, fragment);
        fragmentTransaction.addToBackStack(null);
        questionRepondu = false;
        fragmentTransaction.commit();
    }


    /*public void onClickScorePlus(View view) {

        ProfilFragment.score= ProfilFragment.score +100;
        DashboardFragment.textScore.setText("Score:\n "+ ProfilFragment.score);
    }*/

   /* public void onClickScoreMoins(View view)
    {
        if (ProfilFragment.score != 0)
        {
            ProfilFragment.score = ProfilFragment.score -100;
            DashboardFragment.textScore.setText("Score:\n "+ ProfilFragment.score);

        }
    }*/
    public void onClickAssemblage(View view){
        ConstraintLayout current_fragment=findViewById(R.id.fragment_cours);
        current_fragment.removeAllViews();
        Fragment fragment=new Fragment(R.layout.fragment_c_assemblage);
        FragmentManager fragmentManager= this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_cours,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public void onClickCalepinage(View view){
        ConstraintLayout current_fragment=findViewById(R.id.fragment_cours);
        current_fragment.removeAllViews();
        Fragment fragment=new Fragment(R.layout.fragment_c_calepinage);
        FragmentManager fragmentManager= this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_cours,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public void onClickDechets(View view){
        ConstraintLayout current_fragment=findViewById(R.id.fragment_cours);
        current_fragment.removeAllViews();
        Fragment fragment=new Fragment(R.layout.fragment_c_dechets);
        FragmentManager fragmentManager= this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_cours,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public void onClickRecyclage(View view){
        ConstraintLayout current_fragment=findViewById(R.id.fragment_cours);
        current_fragment.removeAllViews();
        Fragment fragment=new Fragment(R.layout.fragment_c_recyclage);
        FragmentManager fragmentManager= this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_cours,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void onClickQCMAssemblage(View view) {
        ConstraintLayout current_fragment = findViewById(R.id.fragment_qcm);
        current_fragment.removeAllViews();
        Fragment fragment = new Fragment(R.layout.fragment_qcm_assemblage);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_qcm, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void onClickQCMCalepinage(View view) {
        ConstraintLayout current_fragment = findViewById(R.id.fragment_qcm);
        current_fragment.removeAllViews();
        Fragment fragment = new Fragment(R.layout.fragment_qcm_calepinage);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_qcm, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void onClickQCMDechet(View view) {
        ConstraintLayout current_fragment = findViewById(R.id.fragment_qcm);
        current_fragment.removeAllViews();
        Fragment fragment = new Fragment(R.layout.fragment_qcm_dechet);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_qcm, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void onCLickQCMRecyclage(View view) {
        ConstraintLayout current_fragment = findViewById(R.id.fragment_qcm);
        current_fragment.removeAllViews();
        Fragment fragment = new Fragment(R.layout.fragment_qcm_recyclage);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_qcm, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


    private TextView txt_username;
    private TextView txt_password;
    private Button btn_login;
    public void onClickConnexion(View view) {

//        String inputUsername = txt_username.getText().toString();
//        String inputPassword = txt_password.getText().toString();
//        if(inputUsername.isEmpty() || inputPassword.isEmpty()){
//            Toast.makeText(this,"Specifier les informations de connexions.",Toast.LENGTH_SHORT).show();
        //}else{
        //FAIRE CONNEXION
        //}


    }





    private class ConnectMySql extends AsyncTask<String, Void, String> {
        String res = "";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "Please wait...", Toast.LENGTH_SHORT)
                    .show();

        }

        @Override
        protected String doInBackground(String... params) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);
                System.out.println("Databaseection success");

                String result = "Database Connection Successful\n";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT display_name FROM wpww_users WHERE ID=171");
                ResultSetMetaData rsmd = rs.getMetaData();

                while (rs.next()) {
                    result += rs.getString(1).toString() + "\n";
                }
                res = result;
            } catch (Exception e) {
                e.printStackTrace();
                res = e.toString();
            }
            return res;
        }

        @Override
        protected void onPostExecute(String result) {
            txtData.setText(result);
        }
    }
}