package xyz.kaungsithu.burpple.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import butterknife.*;
import butterknife.ButterKnife;

import xyz.kaungsithu.burpple.R;
import xyz.kaungsithu.burpple.adapters.ImagesAdapter;
import xyz.kaungsithu.burpple.adapters.guideAdapter;
import xyz.kaungsithu.burpple.adapters.newsAdapter;
import xyz.kaungsithu.burpple.adapters.promotionAdapter;

public class MainActivity extends AppCompatActivity {

    private promotionAdapter promotionAdapter;
    private guideAdapter guideAdapter;
    private newsAdapter newsAdapter;
    private ImagesAdapter mImagesAdapter;

    @BindView(R.id.vp_food_images)
    ViewPager viewPager;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rv_promotion)
    RecyclerView rvPromotion;

    @BindView(R.id.rv_guide)
    RecyclerView rvGuide;

    @BindView(R.id.rv_news)
    RecyclerView rvNews;


    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        actionBar.setDisplayShowTitleEnabled(false);

        mImagesAdapter= new ImagesAdapter();
        viewPager.setAdapter(mImagesAdapter);

        promotionAdapter = new promotionAdapter();
        LinearLayoutManager linearLayoutManagerpromotion = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rvPromotion.setLayoutManager(linearLayoutManagerpromotion);
        rvPromotion.setAdapter(promotionAdapter);

        guideAdapter = new guideAdapter();
        LinearLayoutManager linearLayoutManagerGuide = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rvGuide.setLayoutManager(linearLayoutManagerGuide);
        rvGuide.setAdapter(guideAdapter);

        newsAdapter = new newsAdapter();
        LinearLayoutManager linearLayoutManagerNews = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rvNews.setLayoutManager(linearLayoutManagerNews);
        rvNews.setAdapter(newsAdapter);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window w = getWindow();
//            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        }
    }

    @OnClick(R.id.fab)
    public void onTapFab(View view) {
        Snackbar.make(view, "Replace with your own action - ButterKnife", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


}



