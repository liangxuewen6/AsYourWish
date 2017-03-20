package com.mikex.asyourwish.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mike.asyourwish.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String mStringTest;

    private String mTestUri = "https://www.baidu.com";

    private TextView mTvMsg;
    private Button mBtnLogin;
    private Button mBtnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mTvMsg = (TextView) findViewById(R.id.tv_everything_goes_well);
        mBtnLogin.setOnClickListener(this);

        mBtnClear = (Button) findViewById(R.id.btn_clear);
        mBtnClear.setOnClickListener(this);
//    Example of a call to a native method
//    TextView tv = (TextView) findViewById(R.id.sample_text);
//    tv.setText(stringFromJNI());
    }


    /**
     * The follow is used for test the ping interface.Maybe got anr & crash..
     * We just need response form server.
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                try {
                    RequestQueue requestQueue = Volley.newRequestQueue(this);
                    StringRequest stringRequest = new StringRequest(mTestUri,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    mStringTest = response;
                                    mTvMsg.setText(mStringTest);
                                    Log.d("TAG", response);
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("TAG", error.getMessage(), error);
                        }
                    });
                    requestQueue.add(stringRequest);

                } catch (Exception exception) {
                    Thread.dumpStack();
                }
            case R.id.btn_clear:
                mTvMsg.setText("");
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
