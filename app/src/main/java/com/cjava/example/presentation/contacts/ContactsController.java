package com.cjava.example.presentation.contacts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.cjava.example.model.ContacsModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.Sort;

/**
 * Created by junior on 11/12/17.
 */

public class ContactsController implements  ContactsContract.Presenter {


    private Context context;
    private ContactsContract.View mView;


    public ContactsController(Context context, ContactsContract.View mView) {
        this.context = context;
        this.mView = mView;
        this.mView.setPresenter(this);
    }


    private static void executeTransaction(@NonNull Realm.Transaction transaction) {
        Realm realm = null;
        try {
            realm = Realm.getDefaultInstance();
            realm.executeTransaction(transaction);
        } catch (Throwable e) {
            close(realm);
            Log.e("executeTransaction", "REALM");
        } finally {
            close(realm);
        }
    }

    private static void close(@Nullable Realm realm) {
        if (realm != null) {
            realm.close();
        }


    }

    @Override
    public void start() {

        mView.showContacts(getContacs(""));

    }

    @Override
    public void addContact(final ContacsModel contacsModel) {


        executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(contacsModel);
            }
        });


    }

    public static ArrayList<ContacsModel> getContacs(String search) {
        Realm realm = null;

        //Preparas la lista vacia para almancenar los resultados
        ArrayList<ContacsModel> listNew = new ArrayList<>();
        try {
            //Abrir la instancia de Realm
            realm = Realm.getDefaultInstance();
            if (!search.isEmpty()) {
                List<ContacsModel> list = realm.where(ContacsModel.class)
                        .contains("first_name", search, Case.INSENSITIVE)
                        .findAllSorted("first_name", Sort.ASCENDING);
                for (int i = 0; i < list.size(); i++) {
                    ContacsModel c = list.get(i).cloneRealmObject();
                    listNew.add(c);
                }

            } else {
                List<ContacsModel> list = realm.where(ContacsModel.class)
                        .findAllSorted("first_name", Sort.ASCENDING);
                for (int i = 0; i < list.size(); i++) {
                    ContacsModel c = list.get(i).cloneRealmObject();
                    listNew.add(c);
                }
            }


        } catch (Throwable e) {
            close(realm);
        } finally {
            close(realm);
        }
        return listNew;
    }


    /**
     * Filtrar elementos por caracter
     * @param filter
     */

    @Override
    public void search(String filter) {
        mView.showContacts(getContacs(filter));
    }





    //Implementar
    @Override
    public void update(final ContacsModel contacsModel) {
        executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(contacsModel);
            }
        });
    }

    @Override
    public void delete(final ContacsModel contacsModel) {
        executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                contacsModel.deleteFromRealm();
            }
        });
    }
}







/*    public static void save(@NonNull final ClientEntity data) {
        executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(data);
            }
        });
    }

    public static void remove(@NonNull final ClientEntity data) {
        executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                data.deleteFromRealm();
            }
        });
    }

    public static void save(@NonNull final List<ClientEntity> dataList) {
        executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(dataList);
            }
        });
    }

    public static void deleteAllList(@NonNull final List<ClientEntity> dataList) {
        Realm realm = Realm.getDefaultInstance();
        for (int i = 0; i < dataList.size(); i++) {
            ClientEntity entity = realm.where(ClientEntity.class)
                    .equalTo("id", dataList.get(i).getId())
                    .findFirst();
            if (entity != null) {
                remove(entity);
            }
        }
        close(realm);
    }

    public static void updateClient(final ClientEntity clientPast, final ClientEntity clientNew) {

        executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ClientEntity clientEntity = realm.where(ClientEntity.class)
                        .equalTo("id", clientPast.getId())
                        .findFirst();
                if (clientEntity != null) {
                    clientEntity.deleteFromRealm();
                }
                realm.copyToRealmOrUpdate(clientNew.cloneRealmObject());

            }
        });
    }

    private static void executeTransaction(@NonNull Realm.Transaction transaction) {
        Realm realm = null;
        try {
            realm = Realm.getDefaultInstance();
            realm.executeTransaction(transaction);
        } catch (Throwable e) {
            close(realm);
            Log.e("executeTransaction", "REALM");
        } finally {
            close(realm);
        }
    }

    private static void close(@Nullable Realm realm) {
        if (realm != null) {
            realm.close();
        }


    }
}*/


/*


    public static void save(@NonNull final ClientEntity data) {
        executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(data);
            }
        });
    }

    public static void remove(@NonNull final ClientEntity data) {
        executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                data.deleteFromRealm();
            }
        });
    }

    public static void save(@NonNull final List<ClientEntity> dataList) {
        executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(dataList);
            }
        });
    }

    public static void deleteAllList(@NonNull final List<ClientEntity> dataList) {
        Realm realm = Realm.getDefaultInstance();
        for(int i=0;i<dataList.size();i++){
            ClientEntity entity = realm.where(ClientEntity.class)
                    .equalTo("id", dataList.get(i).getId())
                    .findFirst();
            if(entity!=null){
                remove(entity);
            }
        }
        close(realm);
    }
    public static void updateClient(final ClientEntity clientPast,final ClientEntity clientNew) {

        executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ClientEntity clientEntity = realm.where(ClientEntity.class)
                        .equalTo("id", clientPast.getId())
                        .findFirst();
                if(clientEntity!=null){
                    clientEntity.deleteFromRealm();
                }
                realm.copyToRealmOrUpdate(clientNew.cloneRealmObject());

            }
        });
    }

    private static void executeTransaction(@NonNull Realm.Transaction transaction) {
        Realm realm = null;
        try {
            realm = Realm.getDefaultInstance();
            realm.executeTransaction(transaction);
        } catch (Throwable e) {
            close(realm);
            Log.e("executeTransaction", "REALM");
        } finally {
            close(realm);
        }
    }

    private static void close(@Nullable Realm realm) {
        if (realm != null) {
            realm.close();
        }
    }*/
