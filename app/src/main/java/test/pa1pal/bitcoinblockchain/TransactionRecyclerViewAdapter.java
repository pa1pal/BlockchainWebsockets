package test.pa1pal.bitcoinblockchain;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.pa1pal.bitcoinblockchain.model.Transaction;

public class TransactionRecyclerViewAdapter
        extends RecyclerView.Adapter<TransactionRecyclerViewAdapter.TransactionViewHolder> {

    List<Transaction> list = new ArrayList<>();

    public TransactionRecyclerViewAdapter(List<Transaction> transactionsList) {
        this.list = transactionsList;
    }

    public void setList(List<Transaction> transactionsList){
        list = transactionsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TransactionViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transaction_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TransactionViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.transaction_hash)
        TextView transactionHash;
        @BindView(R.id.transaction_amount)
        TextView transactionAmount;
        @BindView(R.id.transaction_time)
        TextView transactionTime;

        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Transaction transaction) {
            transactionHash.setText(transaction.getX().getHash());
//            transactionAmount.setText(transaction.getX().);
            Date date = new Date(transaction.getX().getTime() * 1000);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone("GMT+05:30"));
            transactionTime.setText(simpleDateFormat.format(date));
        }
    }
}
