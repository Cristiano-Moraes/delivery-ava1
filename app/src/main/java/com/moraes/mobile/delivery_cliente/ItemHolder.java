package com.moraes.mobile.delivery_cliente;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemHolder extends RecyclerView.ViewHolder{
    public ImageView imageItem;
    public TextView itemTitulo;
    public TextView itemPreco;
    public Button btnAdd;
    public ItemHolder(@NonNull View itemView) {
        super(itemView);
        this.imageItem = itemView.findViewById(R.id.item_image_view);
        this.itemTitulo = itemView.findViewById(R.id.titulo_item);
        this.itemPreco = itemView.findViewById(R.id.preco_item);
        this.btnAdd = itemView.findViewById(R.id.btn_add_item);
    }
}
