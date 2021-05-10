package com.moraes.mobile.delivery_cliente.api;

import com.moraes.mobile.delivery_cliente.model.CEP;
import com.moraes.mobile.delivery_cliente.model.Foto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DataService {
    @GET("{cep}/json/")
    Call<CEP> recuperarCEP(@Path("cep") String cep );
    @GET("/photos")
    Call<List<Foto>> recuperaFotos();
}
