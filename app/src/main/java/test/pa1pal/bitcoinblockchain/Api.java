package test.pa1pal.bitcoinblockchain;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Api {
    private static Api instance = null;
    public static final String BASE_URL = "https://blockchain.info/";
    private RetrofitService service;

    public static Api getInstance() {
        if (instance == null) {
            instance = new Api();
        }

        return instance;
    }

    private Api() {
        // Implement a method to build your retrofit
        buildRetrofit(BASE_URL);
    }

    private void buildRetrofit(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        this.service = retrofit.create(RetrofitService.class);
    }

    public RetrofitService getService(){
        return this.service;
    }
}
