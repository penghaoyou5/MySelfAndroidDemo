package combjzb.drawabledemo.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/**
 * Created by bjhl-penghaoyou on 16/11/3.
 * 简单自定义 Drawable演示
 */

public interface CustomeDrawable{


    /**
     * 只是一个空实现 看要实现的方法
     */
    class NullImp extends Drawable{

        /**
         * 最主要的方法 用于绘制
         * @param canvas
         */
        @Override
        public void draw(Canvas canvas) {
//            super.draw(canvas);
        }

        @Override
        public void setAlpha(int alpha) {
//            super.setAlpha(alpha);
        }

        @Override
        public void setColorFilter(ColorFilter colorFilter) {
//            super.setColorFilter(colorFilter);
        }

        @Override
        public int getOpacity() {
//            super.getOpacity()
            return PixelFormat.OPAQUE;
        }
    }


    /**
     * 圆形图片
     */
    class CircleImp extends Drawable{


        private final Paint mPaint;

        public CircleImp(int color){
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaint.setColor(color);
        }


        @Override
        public void draw(Canvas canvas) {
            Rect rect = getBounds();
            float centerX = rect.exactCenterX();
            float centerY = rect.exactCenterY();
            canvas.drawCircle(centerX,centerY,Math.min(centerX,centerY),mPaint);
        }

        @Override
        public void setAlpha(int alpha) {
            mPaint.setAlpha(alpha);
            invalidateSelf();
        }

        @Override
        public void setColorFilter(ColorFilter colorFilter) {
            mPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }

        @Override
        public int getOpacity() {
            return PixelFormat.TRANSLUCENT;
        }
    }
}
