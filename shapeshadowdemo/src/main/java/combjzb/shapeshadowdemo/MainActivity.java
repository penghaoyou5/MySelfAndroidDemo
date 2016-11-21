package combjzb.shapeshadowdemo;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wangjie.shadowviewhelper.ShadowProperty;
import com.wangjie.shadowviewhelper.ShadowViewHelper;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initAdapter();
    }

    private void initView() {
        recycleView = (RecyclerView) findViewById(R.id.recycle_view);
    }


    private void initAdapter() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

       recycleView.addItemDecoration(new SpaceItemDecoration(30));

        recycleView.setLayoutManager(layoutManager);

        recycleView.setAdapter(new MyRecycleAdapter());
    }


    public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.MyViewHolder> {

        private final ViewGroup.MarginLayoutParams marginLayoutParams;

        public MyRecycleAdapter(){
            int i = getWindowManager().getDefaultDisplay().getWidth() / 3;
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i, i);
        }



        int[] bgDrawableId = new int[]{R.drawable.layers_btn_shadow,
                R.drawable.layers_edittext_shadow, R.drawable.layers_three_drawable, R.drawable.layers_view_shadow,-1,-2};

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;

            switch (viewType){
                case -2:
                    view = View.inflate(parent.getContext(), R.layout.bg_cardview, null);
                    break;
                default:
                    TextView textView = new TextView(parent.getContext());
                    textView.setGravity(Gravity.CENTER);
                    view = textView;
                    break;
            }
            view.setLayoutParams(marginLayoutParams);
            return new MyViewHolder(view);
        }

        @Override
        public int getItemViewType(int position) {
            switch (bgDrawableId[position]){
                case -2:
                    return -2;

            }
            return super.getItemViewType(position);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            switch (bgDrawableId[position]){
                case -1:
                    ShadowViewHelper.bindShadowHelper(
                            new ShadowProperty()
                                    .setShadowColor(0x77000000)
                                    .setShadowDy(5)
                                    .setShadowRadius(6)
                            ,holder.itemView);
                    return;
                case -2:

                    return;
            }

            ((TextView) holder.itemView).setText("这是第" + position + "个");
            holder.itemView.setBackgroundResource(bgDrawableId[position]);




        }

        @Override
        public int getItemCount() {
            return bgDrawableId.length;
        }


        public class MyViewHolder extends RecyclerView.ViewHolder {

            public MyViewHolder(View itemView) {
                super(itemView);
            }


        }
    }


    public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

        private int space;

        public SpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            //不是第一个的格子都设一个左边和底部的间距
            outRect.left = space;
            outRect.bottom = space;
            //由于每行都只有3个，所以第一个都是3的倍数，把左边距设为0
            if (parent.getChildLayoutPosition(view) %3==0) {
                outRect.left = 0;
            }
        }
    }


}
