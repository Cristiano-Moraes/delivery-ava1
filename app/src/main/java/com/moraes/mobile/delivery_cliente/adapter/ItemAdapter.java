package com.moraes.mobile.delivery_cliente.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moraes.mobile.delivery_cliente.ItemHolder;
import com.moraes.mobile.delivery_cliente.R;
import com.moraes.mobile.delivery_cliente.model.Foto;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {
    private  List<Foto> list;

    public ItemAdapter ( List<Foto> listWeb ){
        this.list =  listWeb;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teste,parent,false);
        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Foto f = list.get(position);
        String url = f.getUrl();
        Picasso.get().load(url).resize(100, 100).centerCrop().into(holder.imageItem);
        holder.itemTitulo.setText(f.getTitle());
        holder.itemPreco.setText(f.getId());

        //.btnAdd.setText();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
