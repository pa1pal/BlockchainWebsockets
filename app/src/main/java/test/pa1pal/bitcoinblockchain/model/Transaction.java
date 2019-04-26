package test.pa1pal.bitcoinblockchain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transaction {
    @SerializedName("op")
    @Expose
    private String op;
    @SerializedName("x")
    @Expose
    private TransactionDetail x;

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public TransactionDetail getX() {
        return x;
    }

    public void setX(TransactionDetail x) {
        this.x = x;
    }
}
