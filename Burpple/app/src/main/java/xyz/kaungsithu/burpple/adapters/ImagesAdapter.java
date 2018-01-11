package xyz.kaungsithu.burpple.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.kaungsithu.burpple.viewitems.ImagesViewItem;
import xyz.kaungsithu.burpple.R;

/**
 * Created by User on 1/11/2018.
 */

public class ImagesAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {//check itemview is correced with want
        return (view == (View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {//itemview instantiatiItem in ViewAdapter
        Context context = container.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ImagesViewItem view =(ImagesViewItem) layoutInflater.inflate(R.layout.items_images,container,false);
        container.addView(view); // must write in using ViewPager
        return  view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
