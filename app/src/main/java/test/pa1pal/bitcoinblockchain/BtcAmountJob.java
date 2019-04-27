package test.pa1pal.bitcoinblockchain;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;

import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;

public class BtcAmountJob extends Job {

    Context context;
    public BtcAmountJob(Context c) {
        context = c;
    }

    public static final String TAG = "job";
    SharedPreferences prefs;
    String amountKey = "amount";
    @NonNull
    @Override
    protected Result onRunJob(@NonNull Params params) {
        prefs = context.getSharedPreferences(
                "test.pa1pal.bitcoinblockchain", Context.MODE_PRIVATE);

        Api.getInstance().getService().getBTCPrice("USD", 1).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                prefs.edit().putString(amountKey, (response.body())).apply();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
        return Result.SUCCESS;
    }

    public static void scheduleJob() {
        new JobRequest.Builder(BtcAmountJob.TAG)
                .setPeriodic(TimeUnit.MINUTES.toMillis(15), TimeUnit.MINUTES.toMillis(5))
                .setRequiredNetworkType(JobRequest.NetworkType.CONNECTED)
                .build()
                .schedule();
    }

    public static void startJob() {
        new JobRequest.Builder(BtcAmountJob.TAG)
                .startNow()
                .build()
                .schedule();
    }

}
