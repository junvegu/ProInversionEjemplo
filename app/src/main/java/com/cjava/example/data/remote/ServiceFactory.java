package com.cjava.example.data.remote;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Service Factory for Retrofit
 */
public class ServiceFactory {

    public static final String API_BASE_URL = "https://graph.facebook.com/";

// set your desired log level

    private static OkHttpClient httpClient = new OkHttpClient();
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {

       /* HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);*/
        OkHttpClient client = new OkHttpClient.Builder().build();

        Retrofit retrofit = builder.client(httpClient).client(client).build();
        return retrofit.create(serviceClass);
    }
}
