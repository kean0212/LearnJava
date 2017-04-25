#Generics
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
   SixTuple<String, Integer, Character, Boolean, Float, Double> sixTuple = new SixTuple<String, Integer, Character, Boolean, Float, Double> 
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
