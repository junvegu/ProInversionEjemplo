package com.cjava.example.base;

/**
 * Created by luizkawai on 31/10/17.
 */

public interface BaseView<T> {

    void setPresenter(T presenter);

    void setLoadingIndicator(boolean active);

    void showMessage(String message);

    void showErrorMessage(String message);

}
