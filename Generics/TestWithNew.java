import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;

class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    public static <T> List<T> list() {
        return new ArrayList<T>();
    }

    public static <T> LinkedList<T> linkedList() {
        return new LinkedList<T>();
    }

    public static <T> Set<T> set() {
        return new HashSet<T>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<T>();
    }
}

class Test {
    String name;
    int anInt;
}

public class TestWithNew {
    private static void f(Set<String> set) {
    }

    private static void f(Map<String, List<?>> map) {
    }

    public static void main(String[] args) {
        Map<Integer, Test> map = New.map();
        List<Test> testList = New.list();
        LinkedList<Test> testLinkedList = New.linkedList();
        Set<Test> testSet = New.set();
        Queue<Test> testQueue = New.queue();

        f(New.set());
        f(New.map());

        f(New.<String>set());
        f(New.<String, List<?>>map());
    }
}
