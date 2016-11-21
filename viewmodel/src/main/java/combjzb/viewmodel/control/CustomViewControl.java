package combjzb.viewmodel.control;

import android.view.View;
import android.widget.LinearLayout;

import combjzb.viewmodel.R;


/**
 * Created by bjhl-penghaoyou on 16/11/3.
 */

public class CustomViewControl {

    private final View mRootView;
    private LinearLayout llCustomViewWai;

    public CustomViewControl(View rootView){
        mRootView = rootView;
        intView();
        addCustomView();
    }


    private void intView() {
        llCustomViewWai = (LinearLayout) mRootView.findViewById(R.id.ll_custom_view_wai);
    }

    private void addCustomView() {
//        CustomView customView = new CustomView(mRootView.getContext());
//        llCustomViewWai.addView(customView);
    }


}
