package test.pa1pal.bitcoinblockchain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransactionInput {
    @SerializedName("sequence")
    @Expose
    private Long sequence;
    @SerializedName("prev_out")
    @Expose
    private PrevOut prevOut;
    @SerializedName("script")
    @Expose
    private String script;

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public PrevOut getPrevOut() {
        return prevOut;
    }

    public void setPrevOut(PrevOut prevOut) {
        this.prevOut = prevOut;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
