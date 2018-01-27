package xyz.kaungsithu.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.kaungsithu.burpple.R;
import xyz.kaungsithu.burpple.viewholders.ItemsTrendingVenues;

/**
 * Created by User on 1/7/2018.
 */

public class TrendingVenuesAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View trendingVenues = inflater.inflate(R.layout.item_trending_venues, parent, false);
        ItemsTrendingVenues itemsTrendingVenues = new ItemsTrendingVenues(trendingVenues);
        return itemsTrendingVenues;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
