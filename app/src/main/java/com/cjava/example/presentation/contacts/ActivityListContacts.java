package com.cjava.example.presentation.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.cjava.example.R;
import com.cjava.example.data.local.SessionManager;
import com.cjava.example.model.ContacsModel;
import com.cjava.example.presentation.contacts.adapter.ContactsAdapter;
import com.cjava.example.presentation.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by junior on 30/11/17.
 */

public class ActivityListContacts extends AppCompatActivity {


    @BindView(R.id.rv_contacts)
    RecyclerView rvContacts;
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    private ContactsAdapter mContactsAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager mGridLayoutManager;
    private SessionManager sessionManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contacts);
        ButterKnife.bind(this);


        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        ab.setDefaultDisplayHomeAsUpEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);

        ab.setTitle("Lista de contactos");


        sessionManager =  new SessionManager(this);

        mContactsAdapter = new ContactsAdapter(ContacsModel.contacsEntities(), this);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mGridLayoutManager = new GridLayoutManager(this, 2);


        rvContacts.setAdapter(mContactsAdapter);
        rvContacts.setLayoutManager(mLinearLayoutManager);

    }
    @Override
    public boolean onSupportNavigateUp() {


        sessionManager.closeSession();
        Intent intent =  new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();


        return true;
    }


}
