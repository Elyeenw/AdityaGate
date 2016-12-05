package aditya.services.adityagate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Settings Viewable", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent i=new Intent(getApplicationContext(),Settings.class);
                startActivity(i);
                overridePendingTransition(R.anim.abc_slide_out_bottom,R.anim.abc_slide_in_top);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(),CSEFragment.class);
                startActivity(i1);
                overridePendingTransition(R.anim.design_bottom_sheet_slide_in,R.anim.design_bottom_sheet_slide_out);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(getApplicationContext(),ITFragment.class);
                startActivity(i2);
                overridePendingTransition(R.anim.design_bottom_sheet_slide_in,R.anim.design_bottom_sheet_slide_out);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(getApplicationContext(),EEEFragment.class);
                startActivity(i3);
                overridePendingTransition(R.anim.design_bottom_sheet_slide_in,R.anim.design_bottom_sheet_slide_out);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(getApplicationContext(),ECEFragment.class);
                startActivity(i4);
                overridePendingTransition(R.anim.design_bottom_sheet_slide_in,R.anim.design_bottom_sheet_slide_out);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5 = new Intent(getApplicationContext(),CIVILFragment.class);
                startActivity(i5);
                overridePendingTransition(R.anim.design_bottom_sheet_slide_in,R.anim.design_bottom_sheet_slide_out);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6 = new Intent(getApplicationContext(),MECHFragment.class);
                startActivity(i6);
                overridePendingTransition(R.anim.design_bottom_sheet_slide_in,R.anim.design_bottom_sheet_slide_out);
            }
        });

    }
}