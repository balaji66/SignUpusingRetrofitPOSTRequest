package com.durga.balaji66.signupusingretrofitpostrequest;

import com.durga.balaji66.signupusingretrofitpostrequest.Models.DefaultResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    //The Register call
    @FormUrlEncoded
    @POST("customerregister")
    Call<DefaultResponse> newCustomerRegistration(
            @Field("customer_name") String name,
            @Field("customer_email") String email,
            @Field("customer_phone") String phone,
            @Field("customer_password") String password,
            @Field("customer_fine") int fine

            );
    @FormUrlEncoded
    @POST("customerlogin")
    Call<DefaultResponse> customerLogin(
            @Field("customer_email") String email,
            @Field("customer_password") String password
    );


}
