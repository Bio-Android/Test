 package com.example.test.webservice;

import com.example.test.webservice.Api.ProductApi2;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

 public class WebService {
     private Retrofit retrofit=null;
     public Retrofit getRetrofit() {
         if (retrofit==null){
             HttpLoggingInterceptor interceptor= new HttpLoggingInterceptor();
             interceptor.level(HttpLoggingInterceptor.Level.BODY);
             OkHttpClient cliente = new OkHttpClient.Builder().addInterceptor(interceptor).build();
             retrofit=new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").client(cliente).addConverterFactory(GsonConverterFactory.create()).build();
         }//
         return retrofit;
     }

     public ProductApi2 getUsers(){ //el metodo getUsers es de tipo Objeto ProductApi2
         return getRetrofit().create(ProductApi2.class);
     }


 }
