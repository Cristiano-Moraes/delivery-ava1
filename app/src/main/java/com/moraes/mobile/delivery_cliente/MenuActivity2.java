package com.moraes.mobile.delivery_cliente;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.moraes.mobile.delivery_cliente.adapter.ItemAdapter;
import com.moraes.mobile.delivery_cliente.api.DataService;
import com.moraes.mobile.delivery_cliente.model.Foto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.util.Log.*;
import static android.widget.Toast.*;

public class MenuActivity2 extends AppCompatActivity {
    Retrofit retrofitList;
    private List<Foto> listaFotos = new ArrayList<>();
    private ItemAdapter itemAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
        Toolbar toolbarCliente = findViewById(R.id.toolbar_cliente);
        toolbarCliente.setTitle("");
        setSupportActionBar(toolbarCliente);
        retrofitList = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create()).build();
        recuperarListaRetrofit();
        recyclerView = findViewById(R.id.recycle_view_rest_test);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menuCliente) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toolbar, menuCliente);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_item_menu_cadastro :{
                Intent intentCadastro = new Intent(getApplicationContext(),CadastroActivity.class);
                startActivity(intentCadastro);
                break;
            }
            case R.id.id_item_menu_endereco :{
                Intent intentEndereco = new Intent(getApplicationContext(),EnderecoActivity.class);
                startActivity(intentEndereco);
                break;
            }
            case R.id.id_item_menu_sobre :{
                makeText(this,"SOBRE O SOFTWARE", LENGTH_SHORT).show();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void recuperarListaRetrofit(){
        DataService service = retrofitList.create(DataService.class);
        Call<List<Foto>> call = service.recuperaFotos();
        call.enqueue(new Callback<List<Foto>>() {
            @Override
            public void onResponse(Call<List<Foto>> call, Response<List<Foto>> response) {
                listaFotos.addAll(response.body());
                itemAdapter = new ItemAdapter(listaFotos);
                recyclerView.setAdapter(itemAdapter);
            }

            @Override
            public void onFailure(Call<List<Foto>> call, Throwable t) {

            }
        });

    }

}