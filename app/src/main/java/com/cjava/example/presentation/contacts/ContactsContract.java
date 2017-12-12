package com.cjava.example.presentation.contacts;

import com.cjava.example.base.BasePresenter;
import com.cjava.example.base.BaseView;
import com.cjava.example.model.ContacsModel;
import com.cjava.example.model.UserModel;

import java.util.ArrayList;

/**
 * Created by junior on 01/12/17.
 */

public interface ContactsContract {


    interface View extends BaseView<Presenter> {


        void showContacts(ArrayList<ContacsModel> contacsModels);

        void deleteItemSuccess(String id);

        void addContactSuccess(ContacsModel contacsModel);

        void updateContact(ContacsModel contacsModel);

    }

    interface Presenter extends BasePresenter {

        void addContact(ContacsModel contacsModel);

        void update(ContacsModel contacsModel);

        void delete(ContacsModel contacsModel);

        void search(String filter);


    }
}
