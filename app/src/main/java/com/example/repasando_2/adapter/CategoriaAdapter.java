package com.example.repasando_2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.repasando_2.R;
import com.example.repasando_2.entity.Categoria;

import java.util.ArrayList;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaAdapterViewHolder> {

    Context context;
    int item_ctegoria;
    ArrayList<Categoria> list_categoria;

    public CategoriaAdapter(Context context, int item_categoria, ArrayList<Categoria> list_categoria_input) {

        this.context = context;
        this.item_ctegoria = item_categoria;
        this.list_categoria = list_categoria_input;

    }

    @NonNull
    @Override
    public CategoriaAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View layoutInflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categoria,parent, false);
        return new CategoriaAdapterViewHolder(layoutInflater);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaAdapterViewHolder holder, int position) {

        Categoria categoria = list_categoria.get(position);

        holder.tv_nombre_categoria.setText(categoria.getNombre().toString());
        holder.tv_descripcion_categoria.setText(categoria.getDescripcion().toString());
    }

    @Override
    public int getItemCount() {
        return list_categoria.size();
    }

    public class CategoriaAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView tv_nombre_categoria, tv_descripcion_categoria;
        ImageView img_categoria;

        public CategoriaAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_nombre_categoria = itemView.findViewById(R.id.tv_nombre_categoria);
            tv_descripcion_categoria = itemView.findViewById(R.id.tv_descripcion_categoria);
            img_categoria = itemView.findViewById(R.id.img_categoria);
        }

    }
}
