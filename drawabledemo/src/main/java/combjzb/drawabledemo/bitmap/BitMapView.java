package combjzb.drawabledemo.bitmap;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

import combjzb.drawabledemo.R;

/**
 * Created by bjhl-penghaoyou on 16/11/1.
 */

public class BitMapView implements BitMapContract.view {

    private TextView mTv_bitmap;
    private android.support.v7.widget.AppCompatRadioButton mBtn_gravity;
    private android.support.v7.widget.AppCompatRadioButton mBtn_mipmap;
    private android.support.v7.widget.AppCompatRadioButton mBtn_tileMode;


    private View mRootView;
    private BitMapContract.Presenter mPresenter;
    private BitmapDrawable bitmapDrawable;

    public BitMapView(View rootView){
        mRootView = rootView;
        bindViews();
        initOnclick();
    }

    @Override
    public void setPresenter(BitMapContract.Presenter presenter) {
        mPresenter = presenter;
    }

    private void bindViews() {
        mTv_bitmap = (TextView) mRootView.findViewById(R.id.tv_bitmap);
        bitmapDrawable = (BitmapDrawable) mTv_bitmap.getBackground();
        mBtn_gravity = (android.support.v7.widget.AppCompatRadioButton) mRootView.findViewById(R.id.btn_gravity);
        mBtn_mipmap = (android.support.v7.widget.AppCompatRadioButton) mRootView.findViewById(R.id.btn_mipmap);
        mBtn_tileMode = (android.support.v7.widget.AppCompatRadioButton) mRootView.findViewById(R.id.btn_tileMode);
    }

    private void initOnclick() {
        mBtn_gravity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                bitmapDrawable.setGravity();
            }
        });

    }


}
