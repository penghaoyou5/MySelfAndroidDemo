package combjzb.drawabledemo.custom;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import combjzb.drawabledemo.R;
import combjzb.drawabledemo.bitmap.BitMapContract;
import combjzb.drawabledemo.drawable.CustomeDrawable;

/**
 * Created by bjhl-penghaoyou on 16/11/1.
 */

public class CustomView implements BitMapContract.view {

    private View mRootView;
    private BitMapContract.Presenter mPresenter;
    private TextView tvTestCustomDrawable;
    private ImageView ivTestCustomDrawable;

    public CustomView(View rootView){
        mRootView = rootView;
        bindViews();
        initOnclick();
    }

    @Override
    public void setPresenter(BitMapContract.Presenter presenter) {
        mPresenter = presenter;
    }

    private void bindViews() {
        tvTestCustomDrawable = (TextView) mRootView.findViewById(R.id.tv_test_custom_drawable);
        CustomeDrawable.CircleImp circleImp = new CustomeDrawable.CircleImp(Color.parseColor("#0ac39e"));
        tvTestCustomDrawable.setBackgroundDrawable(circleImp);


        ivTestCustomDrawable = (ImageView) mRootView.findViewById(R.id.iv_test_custom_drawable);
        ivTestCustomDrawable.setImageDrawable(circleImp);
    }

    private void initOnclick() {

    }


}
