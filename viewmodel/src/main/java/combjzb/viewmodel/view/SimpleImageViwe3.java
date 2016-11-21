package combjzb.viewmodel.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import combjzb.viewmodel.R;

/**
 * Created by bjhl-penghaoyou on 16/11/4.
 * 自己完全重写
 * 1.自定义View
 * 2.自定义属性
 * 3.测量
 * 4.绘制
 */

public class SimpleImageViwe3 extends SimpleImageViwe2 {

    public SimpleImageViwe3(Context context) {
        super(context);
    }

    public SimpleImageViwe3(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleImageViwe3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SimpleImageViwe3(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //保存画布状态
        canvas.save();
        //旋转90
        canvas.rotate(90);

        //增加竖向文字
        mBitmapPaint.setColor(Color.YELLOW);
        mBitmapPaint.setTextSize(30);
        canvas.drawText("fengjing",getLeft()+50,getTop()-50,mBitmapPaint);

        //恢复原状态
        canvas.restore();
    }
}
