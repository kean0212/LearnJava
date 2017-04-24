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
    ``` 
    // the type in the second pair of angle brackets cannot be Derived
    Holder<Base> holder = new Holder<Base>(new Derived());
    ```
2. Casts will be taken care of and the type correctness will be ensured at compile time.
    ```
    // It can be only Base. Otherwise, there would be compilation error.
    Base derived = holder.get();
    ```