package xyz.kaungsithu.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.kaungsithu.burpple.R;
import xyz.kaungsithu.burpple.data.vo.PromotionVO;
import xyz.kaungsithu.burpple.viewholders.ItemsFoodGuides;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 1/4/2018.
 */

public class GuidesAdapter extends RecyclerView.Adapter<ItemsFoodGuides>{

    private List<PromotionVO> mGuideList;

    public GuidesAdapter() {
        mGuideList= new ArrayList<>();
    }

    @Override
    public ItemsFoodGuides onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View foodGuideItemsView = inflater.inflate(R.layout.activity_guide, parent, false);
        ItemsFoodGuides itemsFoodGuides = new ItemsFoodGuides(foodGuideItemsView);
        return itemsFoodGuides;
    }

    @Override
    public void onBindViewHolder(ItemsFoodGuides holder, int position) {
        holder.setGuide(mGuideList.get(position));
    }


    @Override
    public int getItemCount() {
        return mGuideList.size();
    }

    public void setGuide(List<PromotionVO> guideList) {
        mGuideList = guideList;
        notifyDataSetChanged();
    }
}
