import java.util.*;
import java.util.stream.Collectors;

class Individual {
    static int counter = 0;
    int id = counter++;
    String name;

    Individual() {

    }

    Individual(String name) {
        this.name = name;
    }
}

class Person extends Individual {
    Person(String name) {
        super(name);
    }
}

class Pet extends Individual {
    Pet() {
        super();
    }

    Pet(String name) {
        super(name);
    }
}

class Dog extends Pet {
    Dog() {
        super();
    }

    Dog(String name) {
        super(name);
    }
}

class Mutt extends Dog {
    Mutt() {
        super();
    }

    Mutt(String name) {
        super(name);
    }
}

class Pug extends Dog {
    Pug() {
        super();
    }

    Pug(String name) {
        super(name);
    }
}

class Cat extends Pet {
    Cat() {
        super();
    }

    Cat(String name) {
        super(name);
    }
}

class EgyptianMau extends Cat {
    EgyptianMau() {
        super();
    }

    EgyptianMau(String name) {
        super(name);
    }
}

class Manx extends Cat {
    Manx() {
        super();
    }

    Manx(String name) {
        super(name);
    }
}

class Cymric extends Manx {
    Cymric() {
        super();
    }

    Cymric(String name) {
        super(name);
    }
}

class Rodent extends Pet {
    Rodent() {
        super();
    }

    Rodent(String name) {
        super(name);
    }
}

class Rat extends Rodent {
    Rat() {
        super();
    }

    Rat(String name) {
        super(name);
    }
}

class Mouse extends Rodent {
    Mouse() {
        super();
    }

    Mouse(String name) {
        super(name);
    }
}

class Hamster extends Rodent {
    Hamster() {
        super();
    }

    Hamster(String name) {
        super(name);
    }
}

abstract class PetCreator {
    private Random random = new Random(212);

    public abstract List<Class<? extends Pet>> types();

    public Pet randomPet() {
        int i = random.nextInt(types().size());
        try {
            return types().get(i).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; ++i) {
            result[i] = randomPet();
        }
        return result;
    }

    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList<Pet>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}

class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
    private static String[] typeNames = {
            "Mutt", "Pug", "EgyptianMau", "Manx", "Cymric", "Rat", "Mouse", "Hamster"
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames) {
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    public List<Class<? extends Pet>> types() {
        return types;
    }
}

class PetCount {
    static class PetCounter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type); // this get is the one from the base class, i.e. HashMap
            if (quantity == null) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }
        }
    }

    public static void countPets(PetCreator creator) {
        PetCounter counter = new PetCounter();
        for (Pet pet : creator.createArray(20)) {
            if (pet instanceof Pet) {
                counter.count("Pet");
            }
            if (pet instanceof Dog) {
                counter.count("Dog");
            }
            if (pet instanceof Cat) {
                counter.count("Cat");
            }
            if (pet instanceof Rodent) {
                counter.count("Rodent");
            }
            if (pet instanceof Mutt) {
                counter.count("Mutt");
            }
            if (pet instanceof Pug) {
                counter.count("Pug");
            }
            if (pet instanceof EgyptianMau) {
                counter.count("EgyptianMau");
            }
            if (pet instanceof Manx) {
                counter.count("Manx");
            }
            if (pet instanceof Cymric) {
                counter.count("Cymric");
            }
            if (pet instanceof Rat) {
                counter.count("Rat");
            }
            if (pet instanceof Mouse) {
                counter.count("Mouse");
            }
            if (pet instanceof Hamster) {
                counter.count("Hamster");
            }
        }
        System.out.println(counter);
    }
}

class LiteralPetCreator extends PetCreator {
    @SuppressWarnings("unchecked")
    public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(Arrays.asList(
            Pet.class, Dog.class, Cat.class, Rodent.class, Mutt.class, Pug.class, EgyptianMau.class,
            Manx.class, Cymric.class, Rat.class, Mouse.class, Hamster.class
    ));
    private static final List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());

    public List<Class<? extends Pet>> types() {
        return types;
    }
}

class PetCount3 {
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        public PetCounter() {
            super(LiteralPetCreator.allTypes.stream().collect(Collectors.toMap(type -> type, type -> 0)));
        }

        public void count(Pet pet) {
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                if (pair.getKey().isInstance(pet)) {
                    // the values have been initialized to 0 during the construction
                    put(pair.getKey(), pair.getValue() + 1);
                }
            }
        }

    }
}

// this is the facade
class Pets {
    public static final PetCreator creator = new LiteralPetCreator();

    public static Pet randomPet() {
        return creator.randomPet();
    }

    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
}

class TypeCounter extends HashMap<Class<?>, Integer> {
    private Class<?> baseType;

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count(Object object) {
        Class<?> type = object.getClass();
        if (!baseType.isAssignableFrom(type)) {
            throw new RuntimeException(object + " incorrect type: " + type + ", should be type of subtype of " + baseType);
        }
        countClass(type);
    }

    private void countClass(Class<?> type) {
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        if (superClass != null && baseType.isAssignableFrom(superClass)) {
            countClass(superClass);
        }
    }
}

public class Exercise11 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }
        System.out.println(counter);
    }
}
