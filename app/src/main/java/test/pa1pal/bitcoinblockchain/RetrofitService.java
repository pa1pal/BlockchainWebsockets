package test.pa1pal.bitcoinblockchain;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("tobtc")
    Call<String> getBTCPrice(@Query("currency") String currency, @Query("value") Integer value);
}
