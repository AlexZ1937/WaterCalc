package com.example.watercalc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class WaterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);


        ImageView img = (ImageView)findViewById(R.id.imageView);
        img.setBackgroundResource(R.drawable.glassanimation1);
        final AnimationDrawable myAnim = (AnimationDrawable) img.getBackground();


        ((Button)findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                if( ((ProgressBar)findViewById(R.id.progressBar)).getProgress()<100) {
                    if(myAnim.isRunning())
                    {
                        myAnim.stop();
                    }

//                    if(myAnim.getCurrent()==getDrawable(R.drawable.emptyglass3))
//                    {
//
//                    }
                    ((ProgressBar) findViewById(R.id.progressBar)).setProgress(((ProgressBar)findViewById(R.id.progressBar)).getProgress()+20,false);
                    myAnim.start();
                    Toast.makeText(getApplicationContext(),"Освежился!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Уфф больше не могу!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    protected void Drink(View v)
    {
        if( ((ProgressBar)findViewById(R.id.progressBar)).getProgress()<100) {
            ((ProgressBar) findViewById(R.id.progressBar)).setProgress(((ProgressBar)findViewById(R.id.progressBar)).getProgress()+20,false);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Уфф больше не могу!",Toast.LENGTH_LONG);
        }
    }
}