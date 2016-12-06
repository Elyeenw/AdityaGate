package aditya.services.adityagate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class key_cseFragment extends Fragment {
    Button y_15,y_14,y_13,y_12,y_11,y_10,y_09,y_08;
    View returning;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        returning=inflater.inflate(R.layout.activity_key_cse_fragment, container, false);
        y_15=(Button)returning.findViewById(R.id.button1);
        y_14=(Button)returning.findViewById(R.id.button2);
        y_13=(Button)returning.findViewById(R.id.button3);
        y_12=(Button)returning.findViewById(R.id.button4);
        y_11=(Button)returning.findViewById(R.id.button5);
        y_10=(Button)returning.findViewById(R.id.button6);
        y_09=(Button)returning.findViewById(R.id.button7);
        y_08=(Button)returning.findViewById(R.id.button8);
        final Intent i=new Intent(getContext(),PDF_Show.class);
        y_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("File_Name","CSE_K_2015");
                startActivity(i);
            }
        });
        y_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("File_Name","CSE_K_2014");
                startActivity(i);
            }
        });
        y_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("File_Name","CSE_K_2013");
                startActivity(i);
            }
        });
        y_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("File_Name","CSE_K_2012");
                startActivity(i);
            }
        });
        y_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("File_Name","CSE_K_2011");
                startActivity(i);
            }
        });
        y_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("File_Name","CSE_K_2010");
                startActivity(i);
            }
        });
        y_09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("File_Name","CSE_K_2009");
                startActivity(i);
            }
        });
        y_08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("File_Name","CSE_K_2008");
                startActivity(i);
            }
        });
        return returning;
    }
}
