package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.test.databinding.ActivityShowUserDataBinding;
import com.example.test.models.Users;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ShowUserData extends AppCompatActivity {
    public  ActivityShowUserDataBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowUserDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Users datausertoshow = (Users) getIntent().getSerializableExtra("data");


         binding.editTextnombre.setText(datausertoshow.getName());
         binding.editTextnombredeusuario.setText(datausertoshow.getUsername());
         binding.editextemail.setText(datausertoshow.getEmail());
         binding.editextAddres.setText(datausertoshow.getAddress().street);
         binding.editextSuite.setText(datausertoshow.getAddress().suite);
         binding.editextCity.setText(datausertoshow.getAddress().city);
         binding.editextZipcode.setText(datausertoshow.getAddress().zipcode);
         binding.editextLatitud.setText(datausertoshow.getAddress().geo.lat);
         binding.editextLongitud.setText(datausertoshow.getAddress().geo.lng);
         binding.editextPhone.setText(datausertoshow.getPhone());
         binding.editextWebsite.setText(datausertoshow.getWebsite());
         binding.editextCompanyName.setText(datausertoshow.getCompany().name);
         binding.editextCatchPhrase.setText(datausertoshow.getCompany().catchPhrase);
         binding.editextCompanybs.setText(datausertoshow.getCompany().bs);

    }
}