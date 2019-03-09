package com.example.repasando_2.rest;

import com.example.repasando_2.util.Constantes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HelperWs {

    public static Retrofit getConfiguration(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;

    }
}
