package com.example.mike.asyourwish;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private boolean isBtnPressed = false;
    private String uriTest = "";
    private String result;

    private TextView mTvMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btn_login);
        button.setOnClickListener(this);
//    Example of a call to a native method
//    TextView tv = (TextView) findViewById(R.id.sample_text);
//    tv.setText(stringFromJNI());
    }

    @Override
    public void onClick(View v) {
        if(!isBtnPressed) {
            isBtnPressed = true;
            Thread pingThread = new Thread(){
                @Override
                public void run() {
                    HttpURLConnection httpURLConnection = null;

                    try {
                        URL url = new URL(uriTest);
                        httpURLConnection = (HttpURLConnection) url.openConnection();

                        httpURLConnection.setRequestMethod("GET");
                        // 设置字符集
                        httpURLConnection.setRequestProperty("Charset", "UTF-8");
                        // 设置文件类型
                        httpURLConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
                        // 设置请求参数，可通过Servlet的getHeader()获取
                        httpURLConnection.setRequestProperty("Cookie", "AppName=" + URLEncoder.encode("你好", "UTF-8"));
                        // 设置自定义参数
                        httpURLConnection.setRequestProperty("MyProperty", "this is me!");

                        if(httpURLConnection.getResponseCode() == 200){
                            InputStream is = httpURLConnection.getInputStream();
                            //To-do 发送给主线成，更新ui
                        }
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {

                    }
                }
            };
        }


    }



    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
//    public native String stringFromJNI();
//
//    // Used to load the 'native-lib' library on application startup.
//    static {
//        System.loadLibrary("native-lib");
//    }
}
