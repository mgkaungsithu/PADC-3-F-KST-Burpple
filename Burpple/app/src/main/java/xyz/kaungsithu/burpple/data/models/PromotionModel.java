package xyz.kaungsithu.burpple.data.models;

import xyz.kaungsithu.burpple.network.PromotionDataAgent;
import xyz.kaungsithu.burpple.network.PromotionRetrofitDataAgent;

/**
 * Created by User on 1/12/2018.
 */

public class PromotionModel {

    private PromotionDataAgent sPromotionDataAgent;

    private static PromotionModel sObjInstance;

    private PromotionModel(){

        sPromotionDataAgent= PromotionRetrofitDataAgent.getsObjInstance();
    }

    public static PromotionModel getsObjInstance(){
        if(sObjInstance==null)
        {
            sObjInstance=new PromotionModel();
        }
        return sObjInstance;
    }

    public void LoadPromotion(){
        sPromotionDataAgent.loadPromotion();
    }
}
