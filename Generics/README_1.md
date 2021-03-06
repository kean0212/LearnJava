# Generics
This chapter illustrates the details about Generics in java.

## Why Generics?
There are two ways to break the constraint of writing code to be used across multiple types:
1. **Polymorphism**: code takes the base class (subclasses can be passed in). However, it's still
too restrictive. This only allows a single hierarchy.
2. Code takes an **interface** which means that all classes implementing this interface can be passed
to this code. However, it's still restrictive.

Therefore, generics comes up!

## Simple Generics
1. A holder which is specified to hold a base type can also hold a derived type. However, the 
declaration of the holder is still using the base type.
    ```java
    // the type in the second pair of angle brackets can only be Base
    Holder<Base> holder = new Holder<Base>(new Derived());
    ```
2. Casts will be taken care of and the type correctness will be ensured at compile time.
    ```java
    // It can be only Base. Otherwise, there would be compilation error.
    Base derived = holder.get();
    ```

## Tuple Library
1. Generics can be used to implement tuples which Java doesn't implement
    ```java
    class TwoTuple<A, B> {
        public final first;
        public final second;
        public Tuple(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }
    
    class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
        public final C third;
        public ThreeTuple(A first, B second, C third) {
            super(first, second);
            this.third = third;
        }
    }
    ```
    **Note**:
    1. ```public``` makes the properties easy to access.
    2. ```final``` ensures the safety: once it's been initialized, then it cannot be modified.

2. It's a little **tedious** to create a tuple:
    ```java
    SixTuple<String, Integer, Characters, Boolean, Float, Double> sixTuple = new SixTuple<String, Integer, Characters, Boolean, Float, Double> 
       ("hello", 3, 'a', false, 3.0f, 4.21);
    ```

## A Stack Class
1. Stack is LIFO (last in first out).
2. It can be implemented using **LinkedList** by putting the last element to the head of the list;
it can also be implemented using **Generics**.
   ```java 
   class Stack<T> {
       class Node { // inner class
           T item;
           Node next;
           ...
       }
       ...
   }
    ```
    **Notes:**
    1. Parameterized type **T** is non-static, therefore to access **T** in the inner class, the inner class **cannot** be `static`.
    2. **End Sentinel** is a only definition saying that in the current context, it means the ending. 

## RandomList
1. Use **generics** to implement a `RandomList<T>` where T can be any **object**.
2. From this and the previous exercise, **generics** can be quite useful to implement a tool (e.g. `Tuple`, `RandomList`).

## Generic Interfaces
1. **Generic** can be used to create a **generator** (a specification of **Factory Design Pattern**; the difference is 
that generator does **NOT** need any arguments while FDP needs to construct an object).
    ```java
    interface Generator<T> {
        T next();
    }
    class Coffee {
        ...
    }
    class CoffeeGenerator implements Generator<Coffee> {
        public Coffee next() {
            ...
        }
        ...
    }
    ```

   **Note:**
   **Autoboxing** and **unautoboxing** do **NOT** apply here. The return type of `next()` and type in the angle brackets
   have to be exactly same.
   
### Recall:
1. To use foreach syntax, the object has to be `Iterable<T>`. It needs to implement method:
    ```java
    public Iterator<T> iterator() {
       public boolean hasNext() {
           ...
       }
       public T next() {
           ... 
       }
       public void remove() {
           ... 
       }
    }
    ```
2. Two ways of implementing **adapters**: inheritance and composition.
3. **Polymorphism** also applies to the instance method in the base class.
    ```java
    class Base {
        public String toString() {
            return getClass();
        }
    }
    class Derived extends Base {}
    ...
        Base derived = new Derived();
        System.out.println(derived); // This will output Derived
    ...
    ```

## Generic Methods
1. Methods can be parameterized by putting `<T>` in front of the return type.
    ```java
    class GenericMethod {
        public <A, B> String toString(A a, B b) {
            ... 
        }
    }
    ```
   Note: one interesting founding is that the return type can also be parameterized with the 
   **risk** of casting.
2. `static` method **cannot** access the parameter type of the generic class. The only way
is to make the `static` method generic.
    ```java
    class GenericMethod<T> {
        private <T> void g(T t) {
            ...
        }
    }
    ```
3. ***Type argument inference***: the compiler use to figure out the parameter type for generic 
methods. Therefore, there is no need to specify the parameter type for generic methods. But for 
generic class, there is.

## Leveraging Type Argument Inference
1. **Type argument inference** can be used to reduce the code repetition.
    ```java
    // Without type argument inference
    private Map<Integer, List<? extends Base>> map = new Map<Integer, List<? extends Base>>();

    // With type argument inference
    private class New {
        public static <K, V> Map<K, V> map() {
            return new HashMap<K, V>();
        }
    }
    
    // Assignment
    private Map<Integer, List<? extends Base>> map = New.map();

    // Mehtod call
    public void f(Map<Integer, List<? extends Base>> map) {
    }
    public static void main(String[] args) {
        f(New.map());
    }
    ```
**Note:** 
1. This can be used in both **assignment** and **method call**.
2. The parameter type can be specified explicitly.
    ```java
    // The type should match the one in the method signature
    f(New.<Integer, List<? extends Base>>map()); 
    ```
3. Variable argument can also be used in generic methods:
    ```java
    public <T> List<T> createList(T... args);
    ```
    
## Generator
1. Generic method and generic interface can be combined together to implement a generator
    ```java
    public class Generators {
        // This can fill all subclasses of Collection
        public static <T> Collection<T> fill(Collection<T> collection, Generator<T> generator, int size);
    }
    ```
    * The `fill` method for `List` and `LinkedList` **can** be overloaded
    * When call `fill` on `LinkedList` causes ambiguity because `LinkedList` implements both `List` and 
    `Queue`, we need casting to solve this problem. But if `fill(LinkedList<T> linkedList)` exists, this 
    function will be called instead.
    
### General-Purpose Generator
1. This constructs a generator by passing the `Class` object, and uses `newInstance()` method to create an
instance.
2. The generic type for `Class` object is represented by `Class<T>`.

**Notes:**
* This assumes that the class has default constructor.
* Pay attention to the accessibility when it comes to `Class` method.

## Building Complex Models
1. Learn to use `generators` and `generics` to create complex models.
2. One good technique is that a `class` can extend `Collections`, such as
    ```java
    class Cargo {
       ...
    }
    class CargoShip extends ArrayList<Cargo> {
       ...
    }
    ```
    The very good thing is that `CargoShip` can use the methods in `ArrayList`  such as  
    `super.toString()` which returns `[cargo1, cargo2, ...]`.
