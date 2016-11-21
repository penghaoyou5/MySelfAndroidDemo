package bjzb.simplenetdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import bjzb.simplenetdemo.request.HttpMethod;
import bjzb.simplenetdemo.request.Request;
import bjzb.simplenetdemo.request.RequestListener;
import bjzb.simplenetdemo.response.StringRequest;

public class MainActivity extends AppCompatActivity {

    private TextView tvCaozuo;
    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();
        initClick();
    }


    private void initView() {
        tvCaozuo = (TextView) findViewById(R.id.tv_caozuo);
        tvMessage = (TextView) findViewById(R.id.tv_message);
    }

    private void initClick() {
        tvCaozuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doHttp();
            }
        });
    }

    private void doHttp(){
        //还有在 android 请求与 用java 请求不同的是 这里如果直接用网页地址会出现302 可能是手机请求头部带信息告诉后台是手机
        String url = "https://m.baidu.com/?from=879a&from=844b&vit=fps";
        tvMessage.setText("开始请求"+url);
        StringRequest stringRequest = new StringRequest(HttpMethod.GET, url, new RequestListener<String>() {
            @Override
            public void onComplete(int code, String result, String errMg) {
                tvMessage.setText("请求结果" + result);
            }
        });

        stringRequest.startRequest();
    }


}
