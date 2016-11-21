package combjzb.drawabledemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import combjzb.drawabledemo.bitmap.BitMapPresenter;
import combjzb.drawabledemo.bitmap.BitMapView;
import combjzb.drawabledemo.custom.CustomPresenter;
import combjzb.drawabledemo.custom.CustomView;

public class ScrollingActivity extends AppCompatActivity {

    private View llBitmap;
    private View viewById;
    private View llCustomView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        initView();
        bindPresenter();

//        fab.setOnClickListener((v) -> test());
    }

    private void initView() {
        llBitmap = findViewById(R.id.ll_bitmap);
        viewById = findViewById(R.id.ll_custom);
        llCustomView = findViewById(R.id.ll_custom_view);
    }

    private void bindPresenter(){
        BitMapView bitMapView = new BitMapView(llBitmap);
        new BitMapPresenter(bitMapView);

        //自定义Drawable
        CustomView customView = new CustomView(viewById);
        new CustomPresenter(customView);


        //自定义View


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void test(){};
}
