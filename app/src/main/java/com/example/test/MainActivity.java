package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test.adapters.Adapter;
import com.example.test.databinding.ActivityMainBinding;
import com.example.test.models.LoginModel;
import com.example.test.models.Users;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {


    public Adapter myadapter;
    public ArrayList<String> lista;
    public ActivityMainBinding binding;
    private myViewModel ViewModel;
    public ArrayList<LoginModel> datauser = new ArrayList<>();
    public Users userselected = new Users();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        RecyclerView recyclerView = findViewById(R.id.recyclervnames);
        lista = new ArrayList<>();


        ViewModel = new myViewModel();
        ViewModel.consulta_servicio();

        ViewModel.listadeusuarios.observe(this, new Observer<ArrayList<Users>>() {
            @Override
            public void onChanged(ArrayList<Users> users) {

                ///////////////////////Rellena  la  lista del recyclerview/////////////////////////////////
                //getnombres();
                for (Users aux : users) {
                    lista.add(aux.getName());
                    LoginModel logindata = new LoginModel(aux.getName(), aux.getId());
                    datauser.add(logindata);

                }

                recyclerView.setAdapter(myadapter);
                myadapter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        binding.textViewName.setText(lista.get(recyclerView.getChildAdapterPosition(v)));
                        userselected = users.get(recyclerView.getChildAdapterPosition(v));
                        binding.textView.setVisibility(View.GONE);
                        binding.recyclervnames.setVisibility(View.GONE);
                    }
                });



            }
        });

        binding.buttonAceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int aux=0;
                LoginModel datafromvie = new LoginModel(binding.textViewName.getText().toString(), Integer.parseInt(binding.textViewId.getText().toString()));

                for (LoginModel aux2 : datauser) {
                    aux= aux+1;

                    if (aux2.getStrName().equals(datafromvie.getStrName()) && aux2.getId() == datafromvie.getId()) {
                        Intent intent=new Intent(MainActivity.this,ShowUserData.class);
                        intent.putExtra("data",userselected);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "El usuario existe", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else{

                        if(aux>=datauser.size()){
                            Toast.makeText(MainActivity.this, "el id no corresponde o no existe ", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }
        });

        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        myadapter = new Adapter(MainActivity.this, lista);

    }

}