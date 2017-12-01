package com.cjava.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by junior on 30/11/17.
 */

public class ActivityListContacts extends AppCompatActivity {


    @BindView(R.id.rv_contacts)
    RecyclerView rvContacts;


    private ContactsAdapter mContactsAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager mGridLayoutManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contacts);
        ButterKnife.bind(this);

        mContactsAdapter = new ContactsAdapter(ContacsEntity.contacsEntities(), this);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mGridLayoutManager = new GridLayoutManager(this, 2);


        rvContacts.setAdapter(mContactsAdapter);
        rvContacts.setLayoutManager(mLinearLayoutManager);

    }
}
