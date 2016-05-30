package com.example.za205.opencvtest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button btnSave;
    Button btnOriProcess;
    Button btnGrayProcess;
    Button btnBlurProcess;
    Button btnCannyProcess;
    Button btnLaplacianProcess;
    Bitmap srcBitmap;
    Bitmap grayBitmap;
    Bitmap blurBitmap;
    Bitmap cannyBitmap;
    Bitmap laplacianBitmap;
    ImageView imgView;

    int flag;

    private static final String TAG = "MainActivity";

    //OpenCV库加载并初始化成功后的回调函数
    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            // TODO Auto-generated method stub
            switch (status){
                case BaseLoaderCallback.SUCCESS:
                    Log.i(TAG, "成功加载");
                    break;
                default:
                    super.onManagerConnected(status);
                    Log.i(TAG, "加载失败");
                    break;
            }
        }
    };
    //防止出现Native method not found org.opencv.core.mat.n_mat-Android的错误
    static {
        if (!OpenCVLoader.initDebug()) {
            // Handle initialization error
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initUI();
        loadPicture();
        btnSave.setOnClickListener(new saveClickListener());
        btnOriProcess.setOnClickListener(new oriProcessClickListener());
        btnGrayProcess.setOnClickListener(new grayProcessClickListener());
        btnBlurProcess.setOnClickListener(new blurProcessClickListener());
        btnCannyProcess.setOnClickListener(new cannyProcessClickListener());
        btnLaplacianProcess.setOnClickListener(new laplacianProcessClickListener());

    }

    public void loadPicture() {

        Bundle extras = getIntent().getExtras();

        String srcImg = extras.getString("srcImage");
        srcBitmap = BitmapFactory.decodeFile(srcImg);
        imgView.setImageBitmap(srcBitmap);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void initUI(){
        btnSave = (Button)findViewById(R.id.save);
        btnOriProcess = (Button)findViewById(R.id.btn_ori_process);
        btnGrayProcess = (Button)findViewById(R.id.btn_gray_process);
        btnBlurProcess = (Button)findViewById(R.id.btn_blur_process);
        btnCannyProcess = (Button)findViewById(R.id.btn_canny_process);
        btnLaplacianProcess = (Button)findViewById(R.id.btn_laplacian_process);

        imgView = (ImageView)findViewById(R.id.img_huaishi);
        Log.i(TAG, "initUI sucess...");

    }

    public void procOri(){
        //srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        Bundle extras = getIntent().getExtras();

        String srcImg = extras.getString("srcImage");
        srcBitmap = BitmapFactory.decodeFile(srcImg);
        imgView.setImageBitmap(srcBitmap);
        Log.i(TAG, "procOri sucess...");
    }

    public void procSrc2Gray(){
        Mat rgbMat = new Mat();
        Mat grayMat = new Mat();
        //srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        grayBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), Bitmap.Config.RGB_565);
        Utils.bitmapToMat(srcBitmap, rgbMat);//convert original bitmap to Mat, R G B.
        Imgproc.cvtColor(rgbMat, grayMat, Imgproc.COLOR_RGB2GRAY);//rgbMat to gray grayMat
        Utils.matToBitmap(grayMat, grayBitmap); //convert mat to bitmap
        Log.i(TAG, "procSrc2Gray sucess...");
    }

    public void procBlur(){
        Mat rgbMat = new Mat();
        Mat blurMat = new Mat();
        //srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        blurBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), Bitmap.Config.RGB_565);
        Utils.bitmapToMat(srcBitmap, rgbMat);
        Imgproc.GaussianBlur(rgbMat, blurMat, new Size(7, 7), 6);
        Utils.matToBitmap(blurMat, blurBitmap);
        Log.i(TAG, "procBlur sucess...");
    }

    public  void procCanny(){
        Mat rgbMat = new Mat();
        Mat cannyMat = new Mat();
        //srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        cannyBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), Bitmap.Config.RGB_565);
        Utils.bitmapToMat(srcBitmap, rgbMat);
        Imgproc.Canny(rgbMat, cannyMat, 1, 1);
        Utils.matToBitmap(cannyMat, cannyBitmap);
        Log.i(TAG, "procCanny sucess...");
    }

    public void procLaplacian(){
        Mat rgbMat = new Mat();
        Mat laplacianMat = new Mat();
        //srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        laplacianBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), Bitmap.Config.RGB_565);
        Utils.bitmapToMat(srcBitmap, rgbMat);
        Imgproc.Laplacian(rgbMat, laplacianMat, laplacianMat.depth(), 3, 1, 1);
        Utils.matToBitmap(laplacianMat, laplacianBitmap);
        Log.i(TAG, "procLaplacian sucess...");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent myIntent = new Intent();
            myIntent = new Intent(MainActivity.this, OpenImage.class);
            startActivity(myIntent);
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    private class saveClickListener implements View.OnClickListener{
        public void onClick(View v){
            File appDir = new File(Environment.getExternalStorageDirectory(), "Boohee");
            if (!appDir.exists()) {
                appDir.mkdir();
            }
            String fileName = System.currentTimeMillis() + ".jpg";
            File file = new File(appDir, fileName);
            try {
                FileOutputStream fos = new FileOutputStream(file);
                switch(flag){
                    case 0:srcBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);break;
                    case 1:grayBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);break;
                    case 2:blurBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);break;
                    case 4:laplacianBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);break;
                    case 3:cannyBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);break;
                }
                Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();
                fos.flush();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://"+ Environment.getExternalStorageDirectory())));
            Log.i(TAG, "save sucess...");
        }
    }

    private class oriProcessClickListener implements View.OnClickListener{
        public void onClick(View v){
            procOri();
            flag = 0;
            imgView.setImageBitmap(srcBitmap);
        }
    }

    private class grayProcessClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            procSrc2Gray();
            flag = 1;
            imgView.setImageBitmap(grayBitmap);
        }
    }

    private class blurProcessClickListener implements View.OnClickListener{
        public void onClick(View v){
            procBlur();
            flag = 2;
            imgView.setImageBitmap(blurBitmap);
        }
    }

    private class cannyProcessClickListener implements View.OnClickListener{
        public void onClick(View v){
            procCanny();
            flag = 3;
            imgView.setImageBitmap(cannyBitmap);
        }
    }

    private class laplacianProcessClickListener implements View.OnClickListener{
        public void onClick(View v){
            procLaplacian();
            flag = 4;
            imgView.setImageBitmap(laplacianBitmap);
        }
    }
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        //load OpenCV engine and init OpenCV library
        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_4, getApplicationContext(), mLoaderCallback);
        Log.i(TAG, "onResume sucess load OpenCV...");
    }
}
