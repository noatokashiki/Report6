package enums;
import java.util.Random;

public enum Hands{
    One("1", 0),
    Two("2", 1),
    Three("3", 2),
    Four("4", 3),
    Five("5", 4),
    Six("6", 5),
    Seven("7", 6),
    Eight("8", 7),
    Nine("9", 8),
    Ten("10", 9);

    private final String display;
    
    private final int number;

    Hands(String display, int number){
        this.display = display;
        this.number = number;

    }

    public static Hands getRandomHand() {
        Random rand = new Random();
        return Hands.values()[rand.nextInt(9)];
    }

    public String getDisplay(){
        return this.display;
    }

    public int getNumber(){
        return this.number;
    }

}
