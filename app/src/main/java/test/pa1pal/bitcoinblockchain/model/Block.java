package test.pa1pal.bitcoinblockchain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Block {
    @SerializedName("op")
    @Expose
    private String op;
    @SerializedName("x")
    @Expose
    private BlockDetail x;

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public BlockDetail getX() {
        return x;
    }

    public void setX(BlockDetail x) {
        this.x = x;
    }
}
