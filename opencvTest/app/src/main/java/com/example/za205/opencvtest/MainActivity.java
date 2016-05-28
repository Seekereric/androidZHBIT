package com.example.za205.opencvtest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class MainActivity extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initUI();

        btnOriProcess.setOnClickListener(new oriProcessClickListener());
        btnGrayProcess.setOnClickListener(new grayProcessClickListener());
        btnBlurProcess.setOnClickListener(new blurProcessClickListener());
        btnCannyProcess.setOnClickListener(new cannyProcessClickListener());
        btnLaplacianProcess.setOnClickListener(new laplacianProcessClickListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void initUI(){
        btnOriProcess = (Button)findViewById(R.id.btn_ori_process);
        btnGrayProcess = (Button)findViewById(R.id.btn_gray_process);
        btnBlurProcess = (Button)findViewById(R.id.btn_blur_process);
        btnCannyProcess = (Button)findViewById(R.id.btn_canny_process);
        btnLaplacianProcess = (Button)findViewById(R.id.btn_laplacian_process);

        imgView = (ImageView)findViewById(R.id.img_huaishi);
        Log.i(TAG, "initUI sucess...");

    }

    public void procOri(){
        srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        Log.i(TAG, "procOri sucess...");
    }

    public void procSrc2Gray(){
        Mat rgbMat = new Mat();
        Mat grayMat = new Mat();
        srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        grayBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), Bitmap.Config.RGB_565);
        Utils.bitmapToMat(srcBitmap, rgbMat);//convert original bitmap to Mat, R G B.
        Imgproc.cvtColor(rgbMat, grayMat, Imgproc.COLOR_RGB2GRAY);//rgbMat to gray grayMat
        Utils.matToBitmap(grayMat, grayBitmap); //convert mat to bitmap
        Log.i(TAG, "procSrc2Gray sucess...");
    }

    public void procBlur(){
        Mat rgbMat = new Mat();
        Mat blurMat = new Mat();
        srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        blurBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), Bitmap.Config.RGB_565);
        Utils.bitmapToMat(srcBitmap, rgbMat);
        Imgproc.GaussianBlur(rgbMat, blurMat, new Size(3, 3), 10);
        Utils.matToBitmap(blurMat, blurBitmap);
        Log.i(TAG, "procBlur sucess...");
    }

    public  void procCanny(){
        Mat rgbMat = new Mat();
        Mat cannyMat = new Mat();
        srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        cannyBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), Bitmap.Config.RGB_565);
        Utils.bitmapToMat(srcBitmap, rgbMat);
        Imgproc.Canny(rgbMat, cannyMat, 1, 3);
        Utils.matToBitmap(cannyMat, cannyBitmap);
        Log.i(TAG, "procCanny sucess...");
    }

    public void procLaplacian(){
        Mat rgbMat = new Mat();
        Mat laplacianMat = new Mat();
        srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        laplacianBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), Bitmap.Config.RGB_565);
        Utils.bitmapToMat(srcBitmap, rgbMat);
        Imgproc.Laplacian(rgbMat, laplacianMat, laplacianMat.depth());
        Utils.matToBitmap(laplacianMat, laplacianBitmap);
        Log.i(TAG, "procLaplacian sucess...");
    }

    private class oriProcessClickListener implements View.OnClickListener{
        public void onClick(View v){
            procOri();
            imgView.setImageBitmap(srcBitmap);
        }
    }

    private class grayProcessClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            procSrc2Gray();
            imgView.setImageBitmap(grayBitmap);
        }
    }

    private class blurProcessClickListener implements View.OnClickListener{
        public void onClick(View v){
            procBlur();
            imgView.setImageBitmap(blurBitmap);
        }
    }

    private class cannyProcessClickListener implements View.OnClickListener{
        public void onClick(View v){
            procCanny();
            imgView.setImageBitmap(cannyBitmap);
        }
    }

    private class laplacianProcessClickListener implements View.OnClickListener{
        public void onClick(View v){
            procLaplacian();
            imgView.setImageBitmap(laplacianBitmap);
        }
    }
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        //load OpenCV engine and init OpenCV library
        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_4, getApplicationContext(), mLoaderCallback);
        Log.i(TAG, "onResume sucess load OpenCV...");
//      new Handler().postDelayed(new Runnable(){
//
//          @Override
//          public void run() {
//              // TODO Auto-generated method stub
//              procSrc2Gray();
//          }
//
//      }, 1000);

    }
}
