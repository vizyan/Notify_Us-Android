package com.example.deadroit.spectrum;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.firebase.iid.FirebaseInstanceId;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Administrator extends AppCompatActivity {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private EditText editTextPesan;
    private TextInputEditText editTextJudul;
    private DrawerLayout drawerLayout;
    String time, judul, pesan, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        editTextJudul = (TextInputEditText) findViewById(R.id.editTextJudul);
        editTextPesan = (EditText) findViewById(R.id.editTextPesan);
        setupToolbar();
        setSupportActionBar(toolbar);

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
                        Intent home = new Intent(Administrator.this, MainActivity.class);
                        startActivity(home);
                        return false;
                    case R.id.navigation3:
                        Toast.makeText(getApplicationContext(), "Anda berada di Menu Admin", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.navigation4:
                        Toast.makeText(getApplicationContext(), "Created for Spectrum Only", Toast.LENGTH_SHORT).show();
                        return false;
                    case R.id.navigation5:
                        AlertDialog.Builder builder = new AlertDialog.Builder(Administrator.this);
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
                if(editTextPesan.length()==0){
                    Toast.makeText(this,"Isikan Jarkom", Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Administrator.this);
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

    private void addEmployee(){
        name = "Admin";
        final String desg = editTextJudul.getText().toString().trim();
        final String sal = editTextPesan.getText().toString().trim();
        final String stime = time.toString().trim();
        class AddEmployee extends AsyncTask<Void,Void,String > {
            ProgressDialog loading;

            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(Administrator.this,"Pengumuman","Mengirim pengumuman",false,false);
            }

            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Administrator.this,s,Toast.LENGTH_SHORT).show();
                if (s.matches("Pengumuman diterbitkan")){
                    Intent home = new Intent(Administrator.this, MainActivity.class);
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
        final String title = "Admin";
        final String message = editTextPesan.getText().toString();

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
}
