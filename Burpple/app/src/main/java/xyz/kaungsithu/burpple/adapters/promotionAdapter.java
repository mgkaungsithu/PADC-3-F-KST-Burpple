package xyz.kaungsithu.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.kaungsithu.burpple.R;
import xyz.kaungsithu.burpple.data.vo.PromotionVO;
import xyz.kaungsithu.burpple.viewholders.ItemsFoodPromotion;

/**
 * Created by User on 1/6/2018.
 */

public class PromotionAdapter extends RecyclerView.Adapter<ItemsFoodPromotion> {


    private List<PromotionVO> mPromotionList;

    public PromotionAdapter() {
        mPromotionList = new ArrayList<>();
    }

    @Override
    public ItemsFoodPromotion onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View foodItemsView = inflater.inflate(R.layout.activity_promotion, parent, false);
        ItemsFoodPromotion itemsFoodPromotion = new ItemsFoodPromotion(foodItemsView);
        return itemsFoodPromotion;
    }

    @Override
    public void onBindViewHolder(ItemsFoodPromotion holder, int position) {
        holder.setPromotion(mPromotionList.get(position));
    }


    @Override
    public int getItemCount() {
        return mPromotionList.size();
    }

    public void setPromotion(List<PromotionVO> promotionList) {
        mPromotionList = promotionList;
        notifyDataSetChanged();
    }
}
