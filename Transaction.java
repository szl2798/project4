public class Transaction{
    private int bAmount;
    private int playerId;
    private String bType;
    private int chips1d , chips5d, chips25d, chips100d;
    private int transactionId;
    
    public Transaction(int id, int bitAmount, int player, int chips1, int chips5, int chips25, int chips100, String bitType){
        transactionId = id;
        bAmount = bitAmount;
        playerId = player;
        bType = bitType;
        chips1d = chips1;
        chips5d = chips5;
        chips25d = chips25;
        chips100d = chips100;
    }
    
    public String toString(){
        String transaction ="";
        transaction += transactionId + "\t" + playerId + "\t" + bAmount + "\t(\t" + chips100d + "\t" + chips25d +"\t"
            + chips5d +"\t" + chips1d;
    }
    
    public abstract void print();
}
