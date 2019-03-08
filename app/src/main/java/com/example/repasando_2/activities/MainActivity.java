package com.example.repasando_2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.repasando_2.R;
import com.example.repasando_2.adapter.CategoriaAdapter;
import com.example.repasando_2.entity.Categoria;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_categoria)
    RecyclerView recycler_categoria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.fab_categoria)
    public void agregarCategoria(){

    }

    public void configurarAdaptador(ArrayList<Categoria> list_categoria_input){

        recycler_categoria.setAdapter(new CategoriaAdapter(MainActivity.this,R.layout.item_categoria,list_categoria_input));

    }
}
