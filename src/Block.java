import java.util.Arrays;
import java.util.Date;

public class Block {

    private String[] transactions;
    private String blockHash;
    private String previousBlockHash;
    private long timeStamp;

    //printing the block in String
    @Override
    public String toString() {
        return "Block{" +
                "transactions = " + Arrays.toString(transactions) +
                ", blockHash = " + blockHash +
                ", previousBlockHash = " + previousBlockHash +
                '}' + '\n';
    }

    /* CONSTRUCTOR OF THE BLOCK

    gets: data, previousHash
    object: data, previousHash, time, calculatedHash */
    public Block(String[] transactions, String previousBlockHash) {
        this.transactions = transactions;
        this.previousBlockHash = previousBlockHash;
        this.timeStamp = new Date().getTime();
        this.blockHash = calculateHash();
    }

    //func calculating hash from our data
    public String calculateHash() {
        String calculatedHash = Crypt.sha256(previousBlockHash + Long.toString(timeStamp) + transactions);
        return calculatedHash;
    }

    //getters and setters
    public String[] getTransactions() {
        return transactions;
    }

    public void setTransactions(String[] transactions) {
        this.transactions = transactions;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public String getPreviousBlockHash() {
        return previousBlockHash;
    }

    public void setPreviousBlockHash(String previousBlockHash) {
        this.previousBlockHash = previousBlockHash;
    }

}
