package combjzb.viewmodel.control;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by bjhl-penghaoyou on 16/11/7.
 */

public abstract class BaseViewControl{
    protected View mRootView;

    public BaseViewControl(View view){
        mRootView = view;
        initView();
    }

    protected abstract void initView();

    @Nullable
    public final View findViewById(@IdRes int id) {
        return mRootView.findViewById(id);
    }

}
