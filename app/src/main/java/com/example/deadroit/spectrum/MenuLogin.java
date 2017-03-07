package com.example.deadroit.spectrum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MenuLogin extends AppCompatActivity {

    Button buttOut, buttIn;
    private Spinner spinner1;
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);

        editText1 = (EditText) findViewById(R.id.editText1);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        buttIn = (Button) findViewById(R.id.buttIn);
        buttOut = (Button) findViewById(R.id.buttOut);
        buttOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), MainActivity.class);

                Bundle b = new Bundle();

                b.putString("nama", editText1.getText().toString());
                i.putExtras(b);

                startActivity(i);
            }
        });

        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
        String firstItem = String.valueOf(spinner1.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            ((TextView)parent.getChildAt(0)).setGravity(Gravity.CENTER);

            if (firstItem.equals(String.valueOf(spinner1.getSelectedItem()))){
                Toast.makeText(parent.getContext(), "Silahkan Pilih Semester", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(parent.getContext(), "Kamu memilih : " + parent.getItemAtPosition(pos).toString(), Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?>arg){
        }
    }
}
