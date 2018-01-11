package xyz.kaungsithu.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.kaungsithu.burpple.R;
import xyz.kaungsithu.burpple.viewholders.newsViewHolder;
import xyz.kaungsithu.burpple.viewholders.promotionViewHolder;

/**
 * Created by User on 1/6/2018.
 */

public class newsAdapter extends RecyclerView.Adapter{
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View promotionItemview = layoutInflater.inflate(R.layout.activity_news,parent,false);
        newsViewHolder itemTrailersViewHolder = new newsViewHolder(promotionItemview);
        return itemTrailersViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}