package com.example.repasando_2.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.repasando_2.R;
import com.example.repasando_2.adapter.CategoriaAdapter;
import com.example.repasando_2.entity.Categoria;
import com.example.repasando_2.rest.HelperWs;
import com.example.repasando_2.rest.MethodWs;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_categoria)
    RecyclerView recycler_categoria;
    SweetAlertDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pd = new SweetAlertDialog(this,SweetAlertDialog.PROGRESS_TYPE);
        pd.getProgressHelper().setBarColor(Color.parseColor("#FFEB3B"));
        pd.setContentText("Espere ya empieza!");
        pd.setCancelable(false);
        pd.show();

        ButterKnife.bind(this);

        llamarWsObtenerTodos();

    }

    private void llamarWsObtenerTodos() {

        MethodWs methodWs = HelperWs.getConfiguration().create(MethodWs.class);
        Call<ArrayList<Categoria>> response = methodWs.obtenerTodoCategoria();
        response.enqueue(new Callback<ArrayList<Categoria>>() {
            @Override
            public void onResponse(Call<ArrayList<Categoria>> call, Response<ArrayList<Categoria>> response) {

                if (response.isSuccessful()){

                    ArrayList<Categoria> list_categoria = response.body();

                    configurarAdaptador(list_categoria);

                }

                pd.dismiss();

            }

            @Override
            public void onFailure(Call<ArrayList<Categoria>> call, Throwable t) {

                Log.e("dflores", t.getMessage().toString());
                pd.dismiss();
            }
        });

    }

    @OnClick(R.id.fab_categoria)
    public void agregarCategoria(){

    }

    public void configurarAdaptador(ArrayList<Categoria> list_categoria_input){

        recycler_categoria.setAdapter(new CategoriaAdapter(MainActivity.this,R.layout.item_categoria,list_categoria_input));
        recycler_categoria.setLayoutManager(new LinearLayoutManager(this));
    }
}
