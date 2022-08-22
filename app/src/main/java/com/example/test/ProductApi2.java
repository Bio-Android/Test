package com.example.test;

import com.example.test.models.Users;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductApi2 {

        @GET("users")
        Call<ArrayList<Users>> getUsers();
}
