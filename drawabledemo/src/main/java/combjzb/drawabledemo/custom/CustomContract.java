package combjzb.drawabledemo.custom;

import combjzb.drawabledemo.BasePresenter;
import combjzb.drawabledemo.BaseView;
import combjzb.drawabledemo.bitmap.BitMapContract;

/**
 * Created by bjhl-penghaoyou on 16/11/3.
 */

public interface CustomContract {

    interface view extends BaseView<BitMapContract.Presenter> {

    }



    interface Presenter extends BasePresenter {

    }
}
