package combjzb.drawabledemo.bitmap;

import android.support.annotation.NonNull;
/**
 * Created by bjhl-penghaoyou on 16/11/1.
 */

public class BitMapPresenter implements BitMapContract.Presenter {


    @NonNull
    private BitMapContract.view mBitMapView;

    public BitMapPresenter(@NonNull BitMapContract.view bitMapView) {
        mBitMapView = bitMapView;
        mBitMapView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
