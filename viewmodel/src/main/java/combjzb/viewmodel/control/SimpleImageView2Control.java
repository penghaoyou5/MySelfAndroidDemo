package combjzb.viewmodel.control;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;

import combjzb.viewmodel.R;

/**
 * Created by bjhl-penghaoyou on 16/11/7.
 */

public class SimpleImageView2Control extends BaseViewControl {

    private View customView;

    public SimpleImageView2Control(View view) {
        super(view);
    }


    @Override
    protected void initView() {

        customView = findViewById(R.id.custom_view);
        customView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initView();
            }
        });

        final ViewGroup.LayoutParams layoutParams = customView.getLayoutParams();
        findViewById(R.id.tv_wc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                    layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
                    customView.setLayoutParams(layoutParams);
            }
        });


        findViewById(R.id.tv_mp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
                layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                customView.setLayoutParams(layoutParams);
            }
        });

        findViewById(R.id.tv_jt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutParams.height = (int) (Resources.getSystem().getDisplayMetrics().density*120);
                layoutParams.width = (int) (Resources.getSystem().getDisplayMetrics().density*180);
                customView.setLayoutParams(layoutParams);
            }
        });

    }


}
