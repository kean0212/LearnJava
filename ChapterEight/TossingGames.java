import java.util.*;

enum CoinFace {
    WORD, PEOPLE
}

enum DiceFace {
    ONE, TWO, THREE, FOUR, FIVE, SIX
}

interface Tool {
    Object getFace();
}

interface ToolFactory {
    Tool getTool();
}

class Coin implements Tool {
    public static Random random = new Random(47);
    public CoinFace getFace() {
        if (random.nextInt(2) == 0) {
            return CoinFace.WORD;
        } else {
            return CoinFace.PEOPLE;
        }
    }
}

class CoinFactory implements ToolFactory {
    public Coin getTool() {
        return new Coin();
    }
}

class Dice implements Tool {
    public static Random random = new Random(47);
    public DiceFace getFace() {
        switch (random.nextInt(6)) {
            case 0:
                return DiceFace.ONE;
            case 1:
                return DiceFace.TWO;
            case 2:
                return DiceFace.THREE;
            case 3:
                return DiceFace.FOUR;
            case 4:
                return DiceFace.FIVE;
            default:
                return DiceFace.SIX;
        }
    }
}

class DiceFactory implements ToolFactory {
    public Dice getTool() {
        return new Dice();
    }
}

public class TossingGames {
    public static void play(ToolFactory toolFactory) {
        Tool tool = toolFactory.getTool();
        for (int i = 0; i < 5; ++i) {
            System.out.println(tool.getFace());
        }
    }

    public static void main(String[] args) {
        System.out.println("Coin tossing game: ");
        play(new CoinFactory());
        System.out.println("Dice tossing game: ");
        play(new DiceFactory());
    }
}