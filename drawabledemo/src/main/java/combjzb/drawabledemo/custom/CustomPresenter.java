package combjzb.drawabledemo.custom;

import android.support.annotation.NonNull;

import combjzb.drawabledemo.bitmap.BitMapContract;

/**
 * Created by bjhl-penghaoyou on 16/11/1.
 */

public class CustomPresenter implements BitMapContract.Presenter {


    @NonNull
    private BitMapContract.view mBitMapView;

    public CustomPresenter(@NonNull BitMapContract.view bitMapView) {
        mBitMapView = bitMapView;
        mBitMapView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
