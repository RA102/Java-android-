package it.step.sixlesson.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {
    private static volatile Controller INSTANCE;
    private static final String BASE_URL = "https://api.post.kz/api/";
    //private Callback callback;
    private KazPostAPI api;

    private Controller() {
        //this.callback = callback;
        init();
    }

    private void init(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        api = retrofit.create(KazPostAPI.class);
    }

    public static Controller getInstance(){
        synchronized (Controller.class){
            if (INSTANCE == null){
                INSTANCE = new Controller();
            }
            return INSTANCE;
        }
    }

    public KazPostAPI getApi() {
        return api;
    }
}
