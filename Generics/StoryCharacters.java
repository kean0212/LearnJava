import java.util.Random;

interface Generator<T> {
    T next();
}

class Characters {
    private static int count = 0;
    private int id = count++;

    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class GoodGuy extends Characters {
}

class BadGuy extends Characters {
}

public class StoryCharacters implements Generator<Characters> {
    private static Random random = new Random(31);
    private Class[] types = {GoodGuy.class, BadGuy.class};

    public Characters next() {
        try {
            return (Characters) types[random.nextInt(types.length)].newInstance();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void main(String[] args) {
        StoryCharacters storyCharactersGenerator = new StoryCharacters();
        Characters[] characters = new Characters[10];
        for (int i = 0; i < 10; ++i) {
            characters[i] = storyCharactersGenerator.next();
        }
        for (Characters character : characters) {
            System.out.println(character);
        }

        Characters goodGuy = new GoodGuy();
        System.out.println("Polymorphism: " + goodGuy);
    }
}