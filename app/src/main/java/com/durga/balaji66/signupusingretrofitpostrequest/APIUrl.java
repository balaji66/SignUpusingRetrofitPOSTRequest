package com.durga.balaji66.signupusingretrofitpostrequest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIUrl {
    //https://pusuluribalaji66.000webhostapp.comCabManagement/public/
    public static final String BASE_URL = "https://pusuluribalaji66.000webhostapp.com/CabManagement/public/";
    private static APIUrl mInstance;
    private Retrofit retrofit;

    private APIUrl()
    {
        retrofit =new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized APIUrl getmInstance()
    {
        if(mInstance == null)
        {
            mInstance =new APIUrl();
        }
        return mInstance;
    }
    public ApiService getApi()
    {
        return retrofit.create(ApiService.class);
    }


}
