package com.example.deadroit.spectrum;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.CheckableImageButton;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.util.AtomicFile;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class kormat extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private EditText editTextSal;
    private Spinner spinner1, spinner2;
    String time, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kormat);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setupToolbar();
        setSupportActionBar(toolbar);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

        editTextSal = (EditText) findViewById(R.id.editTextSalary);

        Calendar c = Calendar.getInstance();
        int minutes = c.get(Calendar.MINUTE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        if(hour < 10 && minutes < 10){
            time = "0"+hour+":0"+minutes;
        } else if (hour < 10){
            time = "0"+hour+":"+minutes;
        } else if (minutes < 10){
            time = hour+":0"+minutes;
        } else {
        time = hour+":"+minutes; }

        // Menginisiasi  NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        //Mengatur Navigasi View Item yang akan dipanggil untuk menangani item klik menu navigasi
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Memeriksa apakah item tersebut dalam keadaan dicek  atau tidak,
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);
                //Menutup  drawer item klik
                drawerLayout.closeDrawers();
                //Memeriksa untuk melihat item yang akan dilklik dan melalukan aksi
                switch (menuItem.getItemId()) {
                    // pilihan menu item navigasi akan menampilkan pesan toast klik kalian bisa menggantinya
                    //dengan intent activity
                    case R.id.navigation1:
                        Intent home = new Intent(kormat.this, MainActivity.class);
                        startActivity(home);
                        return false;
                    case R.id.navigation3:
                        Toast.makeText(getApplicationContext(), "Anda berada di Menu Kormat", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.navigation4:
                        Intent AboutUs = new Intent(kormat.this, AboutUs.class);
                        startActivity(AboutUs);
                        return false;
                    case R.id.navigation5:
                        AlertDialog.Builder builder = new AlertDialog.Builder(kormat.this);
                        builder.setMessage("Apakah kalian yakin ingin keluar ?");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                finishAffinity();
                            }
                        });
                        builder.setNegativeButton("Tidak", null);
                        builder.show();
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(), "Kesalahan Terjadi ", Toast.LENGTH_SHORT).show();
                        return true;
                }
            }
        });
        // Menginisasi Drawer Layout dan ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                // Kode di sini akan merespons setelah drawer menutup disini kita biarkan kosong
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                //  Kode di sini akan merespons setelah drawer terbuka disini kita biarkan kosong
                super.onDrawerOpened(drawerView);
            }
        };
        //Mensetting actionbarToggle untuk drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        //memanggil synstate
        actionBarDrawerToggle.syncState();

        spinner1.setOnItemSelectedListener(new kormat.CustomOnItemSelectedListener());
    }

    public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
        String firstItem = String.valueOf(spinner1.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            ((TextView)parent.getChildAt(0)).setGravity(Gravity.CENTER);
                Toast.makeText(parent.getContext(), "Kamu memilih : " + parent.getItemAtPosition(pos).toString(), Toast.LENGTH_SHORT).show();
            }

        @Override
        public void onNothingSelected(AdapterView<?>arg){
        }
    }

    private void addEmployee(){
        name = spinner1.getSelectedItem().toString().trim();
        final String hore = spinner2.getSelectedItem().toString().trim();
        final String kelas = "Kelas " +hore;
        final String desg = kelas;
        final String sal = editTextSal.getText().toString().trim();
        final String stime = time.toString().trim();
        name = spinner1.getSelectedItem().toString().trim();
        final String token = FirebaseInstanceId.getInstance().getToken();

        class AddEmployee extends AsyncTask<Void,Void,String >{
            ProgressDialog loading;

            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(kormat.this,"Pengumuman","Mengirim pengumuman",false,false);
            }

            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(kormat.this,s,Toast.LENGTH_SHORT).show();
                if (s.matches("Pengumuman diterbitkan")){
                    Intent home = new Intent(kormat.this, MainActivity.class);
                    startActivity(home);
                }
            }

            @Override
            protected String doInBackground(Void... v){
                HashMap<String, String > params = new HashMap<>();
                params.put(Config.KEY_EMP_NAME, name);
                params.put(Config.KEY_EMP_DESG, desg);
                params.put(Config.KEY_EMP_SAL, sal);
                params.put(Config.KEY_EMP_TIME, stime);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD, params);
                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    private void sendMultiplePush() {
        final String title = spinner1.getSelectedItem().toString();
        final String message = editTextSal.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.URL_SEND_MULTIPLE_PUSH,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("title", title);
                params.put("message", message);

                return params;
            }
        };
        MyVolley.getInstance(this).addToRequestQueue(stringRequest);
    }

    @Override
    public void onClick(View v){
    }

    protected void setupToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_send, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_send:
                if(editTextSal.length()==0){
                    Toast.makeText(this,"Isikan Jarkom", Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(kormat.this);
                    builder.setMessage("Kirim pengumuman ?");
                    builder.setPositiveButton("YA", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            addEmployee();
                            sendMultiplePush();

                        }
                    });
                    builder.setNegativeButton("Tidak", null);
                    builder.show();
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}