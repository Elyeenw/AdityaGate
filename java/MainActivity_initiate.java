package aditya.services.adityagate;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity_initiate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new LoadViewTask().execute();
    }
    public class LoadViewTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            try
            {
                //Get the current thread's token
                synchronized (this)
                {
                    //Initialize an integer (that will act as a counter) to zero
                    int counter = 0;
                    //While the counter is smaller than four
                    while(counter <= 4)
                    {
                        //Wait 850 milliseconds
                        this.wait(850);
                        //Increment the counter
                        counter++;
                        counter=counter*25;
                        publishProgress();
                    }
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String result) {
            finish();
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.design_fab_in,R.anim.design_fab_out);
        }

        @Override
        protected void onPreExecute() {
            setContentView(R.layout.activity_main_activity_initiate);
            setContentView(R.layout.activity_main_activity_initiate);
            final ImageView iv= (ImageView)findViewById(R.id.imageView3);
            final Animation an= AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
            iv.startAnimation(an);
        }
    }
}
