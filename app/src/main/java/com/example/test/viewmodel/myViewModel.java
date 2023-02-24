package com.example.test.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.test.DataSource.UserDatasource;
import com.example.test.Repository.UserRepository;
import com.example.test.models.Users;

import java.util.ArrayList;

import javax.sql.DataSource;

public class myViewModel extends ViewModel {
    private UserRepository repository;
    public MutableLiveData<ArrayList<Users>> listadeusuarios;

    private UserDatasource mylocaldatasource;


    public myViewModel(UserRepository repository) {
        this.repository = repository;
        mylocaldatasource=repository.getDatasource();
        this.listadeusuarios= mylocaldatasource.listadeusuarios;
        //en  el constructor  del  viewmodel  se inicializan las  variables para que el observador no sean nulas
        //al  igual que los  datasource
    }

    public void  consulta_servicio(){
       mylocaldatasource.consulta_servicio();
    }


}



