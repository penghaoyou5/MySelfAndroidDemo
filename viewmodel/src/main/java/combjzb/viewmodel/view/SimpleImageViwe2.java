package combjzb.viewmodel.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
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

public class SimpleImageViwe2 extends View {

    private Drawable mDrawable;
    private int mWidth;
    private int mHeight;

    protected Paint mBitmapPaint;

    public SimpleImageViwe2(Context context) {
        super(context);
        init(null,0);
    }

    public SimpleImageViwe2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs,0);
    }

    public SimpleImageViwe2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs,defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SimpleImageViwe2(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs,defStyleAttr);
    }

    //2.自定义属性
    private void init(AttributeSet attrs, int defStyleAttr) {
        //根据属性初始化
        if(attrs!=null){
            TypedArray typedArray = null;
            try {
//                typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.SimpleImageView2, defStyleAttr, 0);
                typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.SimpleImageView2);
                //根据id获取图片资源
                mDrawable = typedArray.getDrawable(R.styleable.SimpleImageView2_src);
                meaSureDrawable();
            }finally {
                if(typedArray!=null)
                    typedArray.recycle();
            }
        }

        //初始化画笔
        mBitmapPaint = new Paint();
        mBitmapPaint.setAntiAlias(true);
    }

    //测量Drawable对象的宽高
    private void meaSureDrawable() {
        if(mDrawable!=null){
            mWidth = mDrawable.getIntrinsicWidth();
            mHeight = mDrawable.getIntrinsicHeight();
        }
    }


    /**
     * 3.进行测量
     *
     * 这个方法不重写  宽高看代码基本上就是最小宽高
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(mWidth, mHeight);  //这里出现了错误 哎
//        setMeasuredDimension(mWidth, mHeight);

       //自己写测量方法

        // 获取宽度的模式与大小
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        //高度的模式与大小
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);


        meaSureDrawable();//每次测量之前进行一次宽高重置

        //设置View的宽高
        setMeasuredDimension(measureWidth(widthMode,widthSize),measureHeight(heightMode,heightSize));
    }


    //看ViewGroup getChildMeasureSpec 方法 measureChildren 方法可理解
    private int measureWidth(int mode,int width){
        switch (mode){
            case MeasureSpec.UNSPECIFIED:
            case MeasureSpec.AT_MOST:  //一般对应 wrap_content 表示子视图最多是specSize的大小
                break;
            case MeasureSpec.EXACTLY:
                mWidth = width; //一般对应match_parent  表示父视图希望子视图大小
                break;
        }
        return mWidth;
    }


    private int measureHeight(int mode,int height){
        switch (mode){
            case MeasureSpec.UNSPECIFIED:
            case MeasureSpec.AT_MOST:
                break;
            case MeasureSpec.EXACTLY:
                mHeight = height;
                break;
        }
        return mHeight;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(mDrawable!=null){
            //两种设置图片的方法
//            mDrawable.setBounds(getLeft(),getTop(),getRight(),getBottom());
//            mDrawable.draw(canvas);



            Bitmap bitmap = ((BitmapDrawable) mDrawable).getBitmap();

            Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, mWidth, mHeight, true);
//            canvas.drawBitmap(scaledBitmap,getLeft(),getTop(),mBitmapPaint);   //为什么getLeft getRight获取du为16？
//            canvas.drawBitmap(scaledBitmap,getLeft(),getTop(),mBitmapPaint);   //为什么getLeft getRight获取du为16？
            canvas.drawBitmap(scaledBitmap,getLeft(),getTop(),mBitmapPaint);
        }
    }
}
