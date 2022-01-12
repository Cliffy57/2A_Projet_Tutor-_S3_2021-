package com.example.grainedecopeauxmobile;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.grainedecopeauxmobile.ui.dashboard.DashboardFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.grainedecopeauxmobile.databinding.ActivityMainBinding;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    private static final String url = "jdbc:mysql://clgu6252.odns.fr:3306/clgu6252_wp571";
    private static final String user = "clgu6252_groupe_2";
    private static final String pass = ")$OYuZSjUo8R";
    Button btnFetch,btnClear;
    TextView txtData;
    private ActivityMainBinding binding;

    Dialog dialog;

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


    public void onClickCours(View view) {
        ConstraintLayout current_fragment=findViewById(R.id.fragment_dashboard);
//        current_fragment.setVisibility(View.GONE);
        current_fragment.removeAllViews();
        Fragment fragment=new Fragment(R.layout.fragment_cours);
        FragmentManager fragmentManager= this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_dashboard,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();





        //        NavController navController = Navigation.findNavController(this,R.id.fragment_cours);
        //        navController.navigate(R.id.fragment_dashboard);

//        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
//       transaction.replace(R.id.fragment_dashboard,new fragmentCours()).commit();
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