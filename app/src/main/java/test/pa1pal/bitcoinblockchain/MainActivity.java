package test.pa1pal.bitcoinblockchain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import test.pa1pal.bitcoinblockchain.model.Block;
import test.pa1pal.bitcoinblockchain.model.Transaction;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.socket_connection)
    TextView socketConnectionStatus;
    @BindView(R.id.block_hash)
    TextView blockHash;
    @BindView(R.id.block_height)
    TextView blockHeight;
    @BindView(R.id.total_btc_count)
    TextView totalBTCCount;
    @BindView(R.id.block_rewards)
    TextView blockRewards;
    @BindView(R.id.transaction_recycler_view)
    RecyclerView transactionRecyclerView;
    @BindView(R.id.clear_transactions)
    Button clearTransactions;
    List<Transaction> transactionsList;
    Block block;
    Transaction transaction;
    OkHttpClient okHttpClient;
    BtcAmountJob btcAmountJob;
    SharedPreferences preferences;
    TransactionRecyclerViewAdapter transactionRecyclerViewAdapter;
    WebSocket blockchainBlockWebSocket;
    WebSocket blockchainTransactionWebSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        okHttpClient = new OkHttpClient();
        transactionsList = new ArrayList<>();
        transactionRecyclerViewAdapter = new TransactionRecyclerViewAdapter(transactionsList);
        setUpRecyclerView();
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Request blockchainRequest = new Request.Builder().url("wss://ws.blockchain.info/inv").build();
//        btcAmountJob = new BtcAmountJob(getApplicationContext());
        BtcAmountJob.scheduleJob();
        BtcAmountJob.startJob();

        clearTransactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearAllTransactions();
            }
        });

        blockchainBlockWebSocket = okHttpClient.newWebSocket(blockchainRequest, new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                super.onOpen(webSocket, response);
                webSocket.send("{\"op\":\"ping_block\"}");
                socketConnectionStatus.setText("Status : Connecting");
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                super.onMessage(webSocket, text);
                block = new Gson().fromJson(text, Block.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateNewBlockDate(block);
                        socketConnectionStatus.setText("Status : Connected");
                    }
                });

                Log.d("output", text);
            }

            @Override
            public void onMessage(WebSocket webSocket, ByteString bytes) {
                super.onMessage(webSocket, bytes);
            }

            @Override
            public void onClosing(WebSocket webSocket, int code, String reason) {
                super.onClosing(webSocket, code, reason);
            }

            @Override
            public void onClosed(WebSocket webSocket, int code, String reason) {
                super.onClosed(webSocket, code, reason);
            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                super.onFailure(webSocket, t, response);
                socketConnectionStatus.setText("Status : Disconnected");
            }
        });

        blockchainTransactionWebSocket = okHttpClient.newWebSocket(blockchainRequest, new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                super.onOpen(webSocket, response);
                webSocket.send("{\"op\":\"ping_tx\"}");
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                super.onMessage(webSocket, text);
                transaction = new Gson().fromJson(text, Transaction.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateTransactionData(transaction);
                    }
                });
                Log.d("transaction output", text);
            }

            @Override
            public void onMessage(WebSocket webSocket, ByteString bytes) {
                super.onMessage(webSocket, bytes);
            }

            @Override
            public void onClosing(WebSocket webSocket, int code, String reason) {
                super.onClosing(webSocket, code, reason);
            }

            @Override
            public void onClosed(WebSocket webSocket, int code, String reason) {
                super.onClosed(webSocket, code, reason);
            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                super.onFailure(webSocket, t, response);
            }
        });

    }

    private void clearAllTransactions() {
        transactionsList.removeAll(transactionsList);
        transactionRecyclerViewAdapter.setList(transactionsList);
    }

    private void setUpRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        transactionRecyclerView.setLayoutManager(layoutManager);
        transactionRecyclerView.setAdapter(transactionRecyclerViewAdapter);
    }

    public void updateNewBlockDate(Block block) {
        blockHash.setText("Block Hash :" + block.getX().getHash());
        blockHeight.setText("Block Height :" + block.getX().getHeight().toString());
        totalBTCCount.setText("Total BTC Count :" + block.getX().getTotalBTCSent().toString());
        blockRewards.setText("Block Reward :" + block.getX().getReward().toString());
    }

    public void updateTransactionData(Transaction transaction) {
        Double amount = Double.parseDouble(preferences.getString("amount", "0.00018911"));
        /**
         * 100,000,000 Satoshi	= 1.00000000 ฿
         */
        if ((transaction.getX().getInputs().get(0).getPrevOut().getValue().doubleValue() / 100000000) / amount > 100) {
            if (transactionsList.size() == 5){
                transactionsList.remove(4);
                transactionsList.add(transaction);
            }
            transactionRecyclerViewAdapter.setList(transactionsList);
        }
    }
}
