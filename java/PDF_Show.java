package aditya.services.adityagate;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.File;

public class PDF_Show extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf__show);
        String File_name=getIntent().getExtras().getString("File_Name");
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Downloading Please Wait..");
        progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);
        progressDialog.setIndeterminate(true);
        progressDialog.setProgress(0);
        progressDialog.show();
        int start=0;
        int gap;
        if((File_name.substring(0,3)).equals("MEC")){
            start=4;
        }
        else if((File_name.substring(0,3)).equals("CIV")){
            start=5;
        }
        else if((File_name.substring(0,2)).equals("IT")){
            start=3;
            File_name=File_name.replace("IT","CSE");
        }
        else{
            start=3;
        }
        String Branch=File_name.substring(0,start);
        start+=3;
        gap=start+4;
        String Year=File_name.substring(start,gap);
        File cacheDir=getCacheFolder(this);
        final File cacheFile=new File(cacheDir,File_name+".pdf");
        if(!cacheFile.exists()){
            /*try {
                cacheFile.createNewFile();
                URL fileURL=new URL("http://adityagate.000webhostapp.com/"+Branch+"/"+Year+"/"+File_name+".pdf");
                /*URLConnection connection=fileURL.openConnection();
                connection.connect();
                int lengthOfFile=connection.getContentLength();
                InputStream inputStream=new BufferedInputStream(fileURL.openStream());
                FileOutputStream outputStream=new FileOutputStream(cacheFile);
                HttpURLConnection connection=(HttpURLConnection)fileURL.openConnection();
                connection.connect();
                if(connection.getResponseCode()!=HttpURLConnection.HTTP_OK){
                    Toast.makeText(this,"Connection Error.",Toast.LENGTH_LONG).show();
                }
                InputStream inputStream=connection.getInputStream();
                OutputStream outputStream=new FileOutputStream(cacheFile);
                int lengthOfFile=connection.getContentLength();
                byte buffer[]=new byte[1024];
                int dataSize;
                long loadedSize=0;
                while((dataSize=inputStream.read(buffer))!=-1){
                    loadedSize +=dataSize;
                    progressDialog.setProgress((int)((loadedSize*100)/lengthOfFile));
                    outputStream.write(buffer,0,dataSize);
                }
                outputStream.close();
                progressDialog.dismiss();
            }catch (FileNotFoundException e){
                e.printStackTrace();
                Toast.makeText(getApplicationContext(),"File Not Found",Toast.LENGTH_LONG);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(),"URL Error",Toast.LENGTH_LONG);
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(),"IO Exception",Toast.LENGTH_LONG);
            }*/
            String url="http://adityagate.000webhostapp.com/"+Branch+"/"+Year+"/"+File_name+".pdf";
            DownloadManager.Request request=new DownloadManager.Request(Uri.parse(url));
            request.setDescription("Downloading Please Wait...");
            request.setTitle(File_name);
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB){
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            }
            request.setDestinationInExternalPublicDir("Aditya_Gate",File_name+".pdf");
            final DownloadManager manager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
            final long downloadId=manager.enqueue(request);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean downloading=true;
                    while(downloading){
                        DownloadManager.Query q=new DownloadManager.Query();
                        q.setFilterById(downloadId);
                        Cursor c=manager.query(q);
                        c.moveToFirst();
                        int bytes_d=c.getInt(c.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
                        int bytes_t=c.getInt(c.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
                        if(c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS))==DownloadManager.STATUS_SUCCESSFUL){
                            downloading=false;
                            Uri uri= Uri.fromFile(cacheFile);
                            Intent intent=new Intent();
                            intent.setAction(Intent.ACTION_VIEW);
                            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                            intent.setDataAndType(uri,"application/pdf");
                            startActivity(intent);
                            finish();
                        }
                        if (c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS))==DownloadManager.STATUS_FAILED){
                            Toast.makeText(getApplicationContext(),"Check Your Internet Connection",Toast.LENGTH_LONG).show();
                            finish();
                        }
                        final int dl_progress=(int)((bytes_d*100L)/bytes_t);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.setIndeterminate(false);
                                progressDialog.setMax(100);
                                progressDialog.setProgress(dl_progress);
                            }
                        });
                        c.close();
                    }
                }
            }).start();
        }
        else{
            progressDialog.dismiss();
            Uri uri= Uri.fromFile(cacheFile);
            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(uri,"application/pdf");
            startActivity(intent);
            finish();
        }
        /*webViewer.loadUrl("file:///"+cacheFile);*/
        /*try {
            InputStream fileInputStream=new FileInputStream(cacheFile1);
            BitmapFactory.Options bitmapOptions=new BitmapFactory.Options();
            bitmapOptions.inJustDecodeBounds=false;
            Bitmap result=BitmapFactory.decodeStream(fileInputStream,null,bitmapOptions);
            webViewer.loadUrl(String.valueOf(result));
            setContentView(webViewer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
    }
    public File getCacheFolder(Context context){
        File cacheDir=null;
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            cacheDir=new File(Environment.getExternalStorageDirectory(),"Aditya_Gate");
            if(!cacheDir.isDirectory()){
                cacheDir.mkdirs();
            }
        }
        if(!cacheDir.isDirectory()){
            cacheDir=context.getCacheDir();
        }
        return cacheDir;
    }
    public File getDataFolder(Context context){
        File Datadir=null;
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            Datadir=new File(Environment.getExternalStorageDirectory(),"appData");
            if(!Datadir.isDirectory()){
                Datadir.mkdirs();
            }
        }
        if(!Datadir.isDirectory()){
            Datadir=context.getFilesDir();
        }
        return Datadir;
    }
}
