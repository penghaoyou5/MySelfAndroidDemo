package combjzb.drawabledemo.view;

import android.view.View;
import android.widget.LinearLayout;

import combjzb.drawabledemo.BaseView;
import combjzb.drawabledemo.R;

/**
 * Created by bjhl-penghaoyou on 16/11/3.
 */

public class MyCustomView {

    private final View mRootView;
    private LinearLayout llCustomViewWai;

    public MyCustomView(View rootView){
        mRootView = rootView;
        intView();
    }

    private void intView() {
        llCustomViewWai = (LinearLayout) mRootView.findViewById(R.id.ll_custom_view_wai);
    }



}
