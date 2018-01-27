package xyz.kaungsithu.burpple.data.models;

import xyz.kaungsithu.burpple.network.GuideRetrofitDataAgent;
import xyz.kaungsithu.burpple.network.PromotionDataAgent;

/**
 * Created by User on 1/12/2018.
 */

public class GuideModel {

    private PromotionDataAgent sPromotionDataAgent;

    private static GuideModel sObjInstance;

    private GuideModel(){

        sPromotionDataAgent= GuideRetrofitDataAgent.getsObjInstance();
    }

    public static GuideModel getsObjInstance(){
        if(sObjInstance==null)
        {
            sObjInstance=new GuideModel();
        }
        return sObjInstance;
    }

    public void LoadPromotion(){
        sPromotionDataAgent.loadPromotion();
    }
}
