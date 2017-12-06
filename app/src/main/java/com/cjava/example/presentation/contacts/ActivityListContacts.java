package com.cjava.example.presentation.contacts;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.cjava.example.R;
import com.cjava.example.data.local.SessionManager;
import com.cjava.example.model.ContacsModel;
import com.cjava.example.presentation.contacts.adapter.ContactsAdapter;
import com.cjava.example.presentation.login.LoginActivity;
import com.cjava.example.utils.ImagePicker;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by junior on 30/11/17.
 */

public class ActivityListContacts extends AppCompatActivity {


    @BindView(R.id.rv_contacts)
    RecyclerView rvContacts;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.btn_select_image)
    Button btnSelectImage;

    private static final int PICK_IMAGE_ID = 1234;


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


        sessionManager = new SessionManager(this);

        mContactsAdapter = new ContactsAdapter(ContacsModel.contacsEntities(), this);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mGridLayoutManager = new GridLayoutManager(this, 2);


        rvContacts.setAdapter(mContactsAdapter);
        rvContacts.setLayoutManager(mLinearLayoutManager);

    }

    @Override
    public boolean onSupportNavigateUp() {


        sessionManager.closeSession();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();


        return true;
    }


    @OnClick(R.id.btn_select_image)
    public void onViewClicked() {

        Intent chooseImageIntent = ImagePicker.getPickImageIntent(this);
        startActivityForResult(chooseImageIntent, PICK_IMAGE_ID);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case PICK_IMAGE_ID:

                            Bitmap bitmap1 = ImagePicker.getImageFromResult(this, resultCode, data);
                            image.setImageBitmap(bitmap1);

                    break;
                default:

                    break;
            }
        }


    }
}
