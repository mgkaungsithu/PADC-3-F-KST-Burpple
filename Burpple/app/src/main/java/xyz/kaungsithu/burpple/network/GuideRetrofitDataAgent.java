package xyz.kaungsithu.burpple.network;

import com.google.gson.Gson;
import xyz.kaungsithu.burpple.event.LoadPromotionEvent;
import xyz.kaungsithu.burpple.network.responses.GetPromotionResponse;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 1/12/2018.
 */

public class GuideRetrofitDataAgent implements PromotionDataAgent {

    private static GuideRetrofitDataAgent sObjInstance;

    private PromotionApi promotionApi;

    private GuideRetrofitDataAgent(){

        OkHttpClient httpClient = new OkHttpClient.Builder() //1
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit=new Retrofit.Builder() //2
                .baseUrl("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();

        promotionApi=retrofit.create(PromotionApi.class);
    }

    public static GuideRetrofitDataAgent getsObjInstance(){
        if(sObjInstance==null)
        {
            sObjInstance=new GuideRetrofitDataAgent();
        }
        return sObjInstance;
    }
    @Override
    public void loadPromotion() {

        Call<GetPromotionResponse> getPromotionResponseCall=promotionApi.getPromotions(1,"b002c7e1a528b7cb460933fc2875e916");

        getPromotionResponseCall.enqueue(new Callback<GetPromotionResponse>() {
            @Override
            public void onResponse(Call<GetPromotionResponse> call, Response<GetPromotionResponse> response) {
                GetPromotionResponse getPromotionResponse=response.body();
                if(getPromotionResponse!=null) {
                    LoadPromotionEvent event = new LoadPromotionEvent(getPromotionResponse.getPromotions());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetPromotionResponse> call, Throwable t) {

            }

        });
    }
}
