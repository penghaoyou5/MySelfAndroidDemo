package bjzb.simplenetdemo.postmain;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;

import bjzb.simplenetdemo.request.Request;
import bjzb.simplenetdemo.response.Response;

/**
 * Created by bjhl-penghaoyou on 16/11/14.
 *
 * 请求结果投递类 将请求结果投递给UI线程
 */

public class ResponseDelivery implements Executor {

    Handler handler = new Handler(Looper.getMainLooper());

    /**
     * 处理请求结果 将其执行在UI线程
     * @param request
     * @param response
     */
    public void deliveryResponse(final Request<?> request, final Response response){

        request.diviveryResponseInZiThread(response);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                request.diviveryResponseInMainThread(response);
            }
        };

        execute(runnable);
    }



    @Override
    public void execute(Runnable command) {
        handler.post(command);
    }
}
