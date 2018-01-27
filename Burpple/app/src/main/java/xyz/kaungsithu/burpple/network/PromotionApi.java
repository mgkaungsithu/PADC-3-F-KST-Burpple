package xyz.kaungsithu.burpple.network;

import xyz.kaungsithu.burpple.network.responses.GetPromotionResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by User on 1/12/2018.
 */

public interface PromotionApi {

    @FormUrlEncoded
    @POST("getPromotions.php")
    Call<GetPromotionResponse> getPromotions(@Field("page") int page,
                                             @Field("access_token") String accessToken);
}
