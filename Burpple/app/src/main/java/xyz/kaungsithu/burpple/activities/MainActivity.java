package xyz.kaungsithu.burpple.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.*;
import butterknife.ButterKnife;

import xyz.kaungsithu.burpple.BurppleApp;
import xyz.kaungsithu.burpple.R;
import xyz.kaungsithu.burpple.adapters.GuidesAdapter;
import xyz.kaungsithu.burpple.adapters.ImagesAdapter;
import xyz.kaungsithu.burpple.adapters.NewlyOpenedAdapter;
import xyz.kaungsithu.burpple.adapters.TrendingVenuesAdapter;
import xyz.kaungsithu.burpple.adapters.PromotionAdapter;
import xyz.kaungsithu.burpple.data.models.FeaturedModel;
import xyz.kaungsithu.burpple.data.models.PromotionModel;
import xyz.kaungsithu.burpple.event.LoadFeaturedEvent;
import xyz.kaungsithu.burpple.event.LoadPromotionEvent;

public class MainActivity extends AppCompatActivity {

    private PromotionAdapter mPromotionAdapter;
    private ImagesAdapter mImagesAdapter;
    private NewlyOpenedAdapter mNewlyOpenedAdapter;
    private TrendingVenuesAdapter mTrendingVenuesAdapter;
    private GuidesAdapter mFoodGuidesAdapters;

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


    @BindView(R.id.rv_newly_opened)
    RecyclerView rvNewlyOpened;

    @BindView(R.id.rv_trending_venues)
    RecyclerView rvTrendingVenues;


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

        mPromotionAdapter = new PromotionAdapter();
        LinearLayoutManager linearLayoutManagerpromotion = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rvPromotion.setLayoutManager(linearLayoutManagerpromotion);
        rvPromotion.setAdapter(mPromotionAdapter);

        mFoodGuidesAdapters = new GuidesAdapter();
        LinearLayoutManager linearLayoutManagerGuide = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rvGuide.setLayoutManager(linearLayoutManagerGuide);
        rvGuide.setAdapter(mFoodGuidesAdapters);


        mNewlyOpenedAdapter = new NewlyOpenedAdapter();
        LinearLayoutManager newlyOpenedLinearLayoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false);
        rvNewlyOpened.setLayoutManager(newlyOpenedLinearLayoutManager);
        rvNewlyOpened.setAdapter(mNewlyOpenedAdapter);

        mTrendingVenuesAdapter = new TrendingVenuesAdapter();
        LinearLayoutManager trendingVenuesLinearLayoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false);
        rvTrendingVenues.setLayoutManager(trendingVenuesLinearLayoutManager);
        rvTrendingVenues.setAdapter(mTrendingVenuesAdapter);

        FeaturedModel.getsObjInstance().loadFeatured();
        PromotionModel.getsObjInstance().LoadPromotion();

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window w = getWindow();
//            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id. fab)
    public void onTapFab(View view) {
        Snackbar.make(view, "Replace with your own action - ButterKnife", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFeaturedLoaded(LoadFeaturedEvent event){
        Log.d(BurppleApp.LOG_TAG,"FeaturedLoaded"+event.getFeaturedList().size());
        mImagesAdapter.setFeatured(event.getFeaturedList());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPromotionLoaded(LoadPromotionEvent event){
        Log.d(BurppleApp.LOG_TAG,"mmPromotionLoaded"+event.getPromotionList().size());
        mPromotionAdapter.setPromotion(event.getPromotionList());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGuideLoaded(LoadPromotionEvent event){
        Log.d(BurppleApp.LOG_TAG,"mmGuideLoaded"+event.getPromotionList().size());
        mFoodGuidesAdapters.setGuide(event.getPromotionList());
    }


}



