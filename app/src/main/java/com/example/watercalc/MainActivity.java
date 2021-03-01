package com.example.watercalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.NumberPicker;
    import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

public class MainActivity extends AppCompatActivity {

     HumanInfo tmphuman=new HumanInfo();
     String FILE_NAME="infoWeight.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ((Button)findViewById(R.id.button)).setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (((TextView) findViewById(R.id.WeightPoint)).getText().toString().length() > 0 &&
                        ((TextView) findViewById(R.id.GrowthPoint)).getText().toString().length()>0)
                {
                    Double weight = Double.valueOf(((TextView) findViewById(R.id.WeightPoint)).getText().toString());
                    Double growth = Double.valueOf(((TextView) findViewById(R.id.GrowthPoint)).getText().toString());

                    if (weight > 250.0 || growth > 250.0) {
                        Toast.makeText(getApplicationContext(), "Impossible!", Toast.LENGTH_LONG).show();

                    } else {

                        tmphuman = new HumanInfo(((Switch) findViewById(R.id.switch1)).isChecked(),
                                weight,
                                growth);
                                SaveInfo(tmphuman);

                    }
                }

            }
        });
    }

    protected void SaveInfo(HumanInfo info)
    {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write((((info.female)?"женщина":"мущина")+" рост: "+info.growth.toString()+" вес: "+info.weight.toString()).getBytes());
            Toast.makeText(getApplicationContext(), "SAVED!", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }  finally {
            try {
                if(fos != null)
                    fos.close();

            } catch (IOException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void GetWaterForm(View v)
    {
        Intent intentwater=new Intent(this, WaterActivity.class);
        startActivity(intentwater);
    }




//
//    public void ReadInfo(View v){
//        FileInputStream fin = null;
//        try {
//            fin = openFileInput(FILE_NAME);
//            byte[] bytes = new byte[fin.available()];
//            fin.read(bytes);
//            String tmpstr = new String(bytes);
//            ((TextView)findViewById(R.id.textView)).setText(tmpstr);
//        } catch (FileNotFoundException e) {
//            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
//        } catch (IOException e) {
//            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
//        } finally {
//            try {
//                if(fin != null)
//                    fin.close();
//
//            } catch (IOException e) {
//                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
}