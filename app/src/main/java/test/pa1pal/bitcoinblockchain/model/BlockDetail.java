package test.pa1pal.bitcoinblockchain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BlockDetail {
    @SerializedName("txIndexes")
    @Expose
    private List<Integer> txIndexes = null;
    @SerializedName("nTx")
    @Expose
    private Long nTx;
    @SerializedName("totalBTCSent")
    @Expose
    private Long totalBTCSent;
    @SerializedName("estimatedBTCSent")
    @Expose
    private Long estimatedBTCSent;
    @SerializedName("reward")
    @Expose
    private Long reward;
    @SerializedName("size")
    @Expose
    private Long size;
    @SerializedName("blockIndex")
    @Expose
    private Long blockIndex;
    @SerializedName("prevBlockIndex")
    @Expose
    private Long prevBlockIndex;
    @SerializedName("height")
    @Expose
    private Long height;
    @SerializedName("hash")
    @Expose
    private String hash;
    @SerializedName("mrklRoot")
    @Expose
    private String mrklRoot;
    @SerializedName("version")
    @Expose
    private Long version;
    @SerializedName("time")
    @Expose
    private Long time;
    @SerializedName("bits")
    @Expose
    private Long bits;
    @SerializedName("nonce")
    @Expose
    private Long nonce;

    public List<Integer> getTxIndexes() {
        return txIndexes;
    }

    public void setTxIndexes(List<Integer> txIndexes) {
        this.txIndexes = txIndexes;
    }

    public Long getnTx() {
        return nTx;
    }

    public void setnTx(Long nTx) {
        this.nTx = nTx;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public void setBits(Long bits) {
        this.bits = bits;
    }

    public void setNonce(Long nonce) {
        this.nonce = nonce;
    }


    public Long getTotalBTCSent() {
        return totalBTCSent;
    }

    public void setTotalBTCSent(Long totalBTCSent) {
        this.totalBTCSent = totalBTCSent;
    }

    public Long getEstimatedBTCSent() {
        return estimatedBTCSent;
    }

    public void setEstimatedBTCSent(Long estimatedBTCSent) {
        this.estimatedBTCSent = estimatedBTCSent;
    }

    public Long getReward() {
        return reward;
    }

    public void setReward(Long reward) {
        this.reward = reward;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getBlockIndex() {
        return blockIndex;
    }

    public void setBlockIndex(Long blockIndex) {
        this.blockIndex = blockIndex;
    }

    public Long getPrevBlockIndex() {
        return prevBlockIndex;
    }

    public void setPrevBlockIndex(Long prevBlockIndex) {
        this.prevBlockIndex = prevBlockIndex;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getMrklRoot() {
        return mrklRoot;
    }

    public void setMrklRoot(String mrklRoot) {
        this.mrklRoot = mrklRoot;
    }

    public Long getVersion() {
        return version;
    }

    public Long getTime() {
        return time;
    }

    public Long getBits() {
        return bits;
    }

    public Long getNonce() {
        return nonce;
    }
}
