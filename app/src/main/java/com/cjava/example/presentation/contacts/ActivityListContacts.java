package com.cjava.example.presentation.contacts;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.cjava.example.R;
import com.cjava.example.data.local.SessionManager;
import com.cjava.example.model.ContacsModel;
import com.cjava.example.presentation.contacts.adapter.ContactsAdapter;
import com.cjava.example.presentation.login.LoginActivity;
import com.cjava.example.utils.ImagePicker;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by junior on 30/11/17.
 */

public class ActivityListContacts extends AppCompatActivity implements ContactsContract.View {


    @BindView(R.id.rv_contacts)
    RecyclerView rvContacts;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.btn_select_image)
    Button btnSelectImage;
    @BindView(R.id.fab_add_contact)
    FloatingActionButton fabButton;

    private static final int PICK_IMAGE_ID = 1234;


    private ContactsAdapter mContactsAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager mGridLayoutManager;
    private SessionManager sessionManager;


    //Controlador
    private ContactsContract.Presenter mPresenter;


    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }

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


        mPresenter = new ContactsController(this,this);
        sessionManager = new SessionManager(this);


        //Inicializa la data
        mContactsAdapter = new ContactsAdapter(new ArrayList<ContacsModel>(), this);
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


    //Espera llamadas de resultados de otras actividades y las filtra por código

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case PICK_IMAGE_ID:

                    Bitmap bitmap1 = ImagePicker.getImageFromResult(this, resultCode, data);
                    image.setImageBitmap(bitmap1);

                    break;
                case 666:

                    ContacsModel contacsModel = (ContacsModel) data.getSerializableExtra("contact");


                    mPresenter.addContact(contacsModel);

                    Toast.makeText(this, contacsModel.getFirst_name(), Toast.LENGTH_SHORT).show();

                    break;
                default:

                    break;
            }
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) this.getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(this.getComponentName()));
            final SearchView finalSearchView = searchView;
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    // Toast like print
                    if( ! finalSearchView.isIconified()) {
                        finalSearchView.setIconified(true);
                    }
                    searchItem.collapseActionView();
                    return false;
                }
                @Override
                public boolean onQueryTextChange(String s) {

                    //ünicas lineas a remplazar
                    if (s.length() > 0) {
                        mPresenter.search(s.toUpperCase());
                    } else {
                        mPresenter.search("");
                    }
                    return false;
                }
            });
        }
        return super.onCreateOptionsMenu(menu);
    }

    @OnClick(R.id.fab_add_contact)
    public void onViewClickedFab() {

        Intent intent = new Intent(this, AddContactListActivity.class);
        //Esperar resultado de la otra actividad
        startActivityForResult(intent,666);
    }

    @Override
    public void setPresenter(ContactsContract.Presenter presenter) {

        mPresenter =  presenter;
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void showContacts(ArrayList<ContacsModel> contacsModels) {

        mContactsAdapter.setItems(contacsModels);
    }

    @Override
    public void deleteItemSuccess(String id) {

    }

    @Override
    public void addContactSuccess(ContacsModel contacsModel) {

    }

    @Override
    public void updateContact(ContacsModel contacsModel) {

    }
}
