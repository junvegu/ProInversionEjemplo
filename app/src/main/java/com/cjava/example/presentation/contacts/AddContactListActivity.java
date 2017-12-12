package com.cjava.example.presentation.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;

import com.cjava.example.R;
import com.cjava.example.model.ContacsModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by junior on 11/12/17.
 */

public class AddContactListActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_fullname)
    EditText etFullname;
    @BindView(R.id.et_company)
    EditText etCompany;
    @BindView(R.id.et_phone)
    EditText etPhone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        ButterKnife.bind(this);


        //Generar flecha para cerrar la pantalla

        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        ab.setDefaultDisplayHomeAsUpEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);

        ab.setTitle("Añadir contacto");

    }


    //Método que interccepta el boton de back de la toolbar
    @Override
    public boolean onSupportNavigateUp() {

        //Método que llama al boton back de la barra nativa de Android
        onBackPressed();

        return true;
    }


    private boolean validateFrom(){

        if (etFullname.getText().toString().isEmpty()){
            Toast.makeText(this, "El nombre es obligatorio", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (etCompany.getText().toString().isEmpty()){

            Toast.makeText(this, "El compañia es obligatorio", Toast.LENGTH_SHORT).show();

            return false;
        }
        if (etPhone.getText().toString().equals("")){

            Toast.makeText(this, "El teléfono es obligatorio", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }


    //Añadimos un contacto nuevo
    @OnClick(R.id.btn_add_contact)
    public void onViewClicked() {


        if (validateFrom()){

            ContacsModel contacsModel=  new ContacsModel(etFullname.getText().toString(),
                    etCompany.getText().toString(),etPhone.getText().toString());


            Intent intent =  new Intent();
            intent.putExtra("contact",contacsModel);

            setResult(RESULT_OK,intent);
            finish();
        }else{

        }


    }
}
