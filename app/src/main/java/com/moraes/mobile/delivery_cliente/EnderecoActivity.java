package com.moraes.mobile.delivery_cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.moraes.mobile.delivery_cliente.api.DataService;
import com.moraes.mobile.delivery_cliente.model.CEP;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EnderecoActivity extends AppCompatActivity {
    private Button buscaCep;
    private TextView txtLogradouro;
    private TextView txtBairro;
    private Retrofit retrofitCep;
    private TextView txtCep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);
        retrofitCep = new Retrofit.Builder().baseUrl("https://viacep.com.br/ws/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        buscaCep = findViewById(R.id.btn_busca_cep);
        txtLogradouro = findViewById(R.id.edit_text_logradouro);
        txtBairro = findViewById(R.id.edit_text_bairro);
        txtCep = findViewById(R.id.edit_text_cep);
        buscaCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recuperarCEPRetrofit();

            }
        });
    }
    private void recuperarCEPRetrofit(){
        DataService cepService = retrofitCep.create(DataService.class);
        Call<CEP> call = cepService.recuperarCEP(txtCep.getText().toString());
        call.enqueue(new Callback<CEP>() {
            @Override
            public void onResponse(Call<CEP> call, Response<CEP> response) {
                if ( response.isSuccessful() ){
                    CEP cep = response.body();
                    txtLogradouro.setText(cep.getLogradouro());
                    txtBairro.setText(cep.getBairro());
                }

            }

            @Override
            public void onFailure(Call<CEP> call, Throwable t) {

            }
        });
    }
}