import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;

class Fish {
    private static int count = 0;
    private int id = count++;

    public String toString() {
        return this.getClass() + ": " + id;
    }
}

class SmallFish extends Fish {
    private SmallFish() { // set the default constructor to be private
        super();
    }

    public static Generator<SmallFish> generator() {
        return new Generator<SmallFish>() {
            public SmallFish next() {
                return new SmallFish();
            }
        };
    }
}

class BigFish extends Fish {
    private BigFish() {
        super();
    }

    public static Generator<BigFish> generator = new Generator<BigFish>() {
        public BigFish next() {
            return new BigFish();
        }
    };
}

public class Ocean {
    private static void bigFishEatSmallFish(BigFish bigFish, SmallFish smallFish) {
        System.out.println(bigFish + " eats " + smallFish);
    }

    public static void main(String[] args) {
        int numberOfSmallFishes = 10;
        LinkedList<SmallFish> smallFishLinkedList = new LinkedList<SmallFish>();
        Generators.fill(smallFishLinkedList, SmallFish.generator(), numberOfSmallFishes);

        int numberOfBigFishes = 5;
        ArrayList<BigFish> bigFishArrayList = new ArrayList<BigFish>();
        Generators.fill(bigFishArrayList, BigFish.generator, numberOfBigFishes);

        Random random = new Random(31);
        for (SmallFish smallFish : smallFishLinkedList) {
            BigFish bigFish = bigFishArrayList.get(random.nextInt(numberOfBigFishes));
            bigFishEatSmallFish(bigFish, smallFish);
        }
    }
}