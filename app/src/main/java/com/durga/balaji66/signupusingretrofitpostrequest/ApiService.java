package com.durga.balaji66.signupusingretrofitpostrequest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    //The Register call
    @FormUrlEncoded
    @POST("customerregister")
    Call<ResponseBody> newCustomerRegistration(
            @Field("customer_name") String name,
            @Field("customer_email") String email,
            @Field("customer_phone") String phone,
            @Field("customer_password") String password,
            @Field("customer_fine") int fine

            );
}
