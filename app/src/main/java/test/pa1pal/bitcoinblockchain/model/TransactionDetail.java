package test.pa1pal.bitcoinblockchain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransactionDetail {
    @SerializedName("lock_time")
    @Expose
    private Long lockTime;
    @SerializedName("ver")
    @Expose
    private Long ver;
    @SerializedName("size")
    @Expose
    private Long size;
    @SerializedName("inputs")
    @Expose
    private List<TransactionInput> inputs = null;
    @SerializedName("time")
    @Expose
    private Long time;
    @SerializedName("tx_index")
    @Expose
    private Long txIndex;
    @SerializedName("vin_sz")
    @Expose
    private Long vinSz;
    @SerializedName("hash")
    @Expose
    private String hash;
    @SerializedName("vout_sz")
    @Expose
    private Long voutSz;
    @SerializedName("relayed_by")
    @Expose
    private String relayedBy;
    @SerializedName("out")
    @Expose
    private List<TransactionOutput> out = null;

    public Long getLockTime() {
        return lockTime;
    }

    public void setLockTime(Long lockTime) {
        this.lockTime = lockTime;
    }

    public Long getVer() {
        return ver;
    }

    public void setVer(Long ver) {
        this.ver = ver;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public List<TransactionInput> getInputs() {
        return inputs;
    }

    public void setInputs(List<TransactionInput> inputs) {
        this.inputs = inputs;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getTxIndex() {
        return txIndex;
    }

    public void setTxIndex(Long txIndex) {
        this.txIndex = txIndex;
    }

    public Long getVinSz() {
        return vinSz;
    }

    public void setVinSz(Long vinSz) {
        this.vinSz = vinSz;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Long getVoutSz() {
        return voutSz;
    }

    public void setVoutSz(Long voutSz) {
        this.voutSz = voutSz;
    }

    public String getRelayedBy() {
        return relayedBy;
    }

    public void setRelayedBy(String relayedBy) {
        this.relayedBy = relayedBy;
    }

    public List<TransactionOutput> getOut() {
        return out;
    }

    public void setOut(List<TransactionOutput> out) {
        this.out = out;
    }
}
