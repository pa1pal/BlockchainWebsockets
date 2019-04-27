package test.pa1pal.bitcoinblockchain;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

public class BtcAmountJobCreator implements JobCreator {
    App app;
    public BtcAmountJobCreator(App a) {
        app = a;
    }

    @Nullable
    @Override
    public Job create(@NonNull String s) {
        switch (BtcAmountJob.TAG) {
            case BtcAmountJob.TAG:
                return new BtcAmountJob(app);
            default:
                return null;
        }
    }
}
