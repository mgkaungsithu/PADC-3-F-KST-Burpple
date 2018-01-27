package xyz.kaungsithu.burpple.data.models;

import xyz.kaungsithu.burpple.network.FeaturedDataAgent;
import xyz.kaungsithu.burpple.network.FeaturedRetrofitDataAgent;

/**
 * Created by User on 1/12/2018.
 */

public class FeaturedModel {

    private FeaturedDataAgent mFeaturedDataAgent;

    private static FeaturedModel sObjInstance;

    private FeaturedModel(){

        mFeaturedDataAgent= FeaturedRetrofitDataAgent.getsObjInstance();
    }

    public static FeaturedModel getsObjInstance(){
        if(sObjInstance==null)
        {
            sObjInstance=new FeaturedModel();
        }
        return sObjInstance;
    }

    public void loadFeatured(){
        mFeaturedDataAgent.loadFeatured();
    }
}
