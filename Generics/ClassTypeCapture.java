import java.util.Map;
import java.util.HashMap;

class Building {
}

class House extends Building {
}

public class ClassTypeCapture {
    Map<String, Class<?>> types = new HashMap<String, Class<?>>();

    public void addType(String typeName, Class<?> type) {
        types.put(typeName, type);
    }

    public Object createNew(String typeName) throws Exception {
        if (!types.containsKey(typeName)) {
            throw new Exception("Type \"" + typeName + "\" does NOT exist. Please create and add it.");
        }
        return types.get(typeName).newInstance();
    }

    public static void main(String[] args) {
        ClassTypeCapture classTypeCapture = new ClassTypeCapture();
        classTypeCapture.addType("string", String.class);
        classTypeCapture.addType("building", Building.class);
        classTypeCapture.addType("house", House.class);

        try {
            System.out.println(String.class.isInstance(classTypeCapture.createNew("string")));
            System.out.println(Boolean.class.isInstance(classTypeCapture.createNew("bool")));
            System.out.println(Building.class.isInstance(classTypeCapture.createNew("building")));
            System.out.println(House.class.isInstance(classTypeCapture.createNew("house")));
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}