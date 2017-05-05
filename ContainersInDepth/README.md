## Coding
1. `Map` is not iterable. Therefore, the way to iterate through the `Map` is like below:
    ```java
    for(Map.Entry<T, E> entry : map.entrySet()) { ... }
    ```
    Method `entrySet` returns a `Set` of entries, all included.

2. `Entry` is an inner interface of `Map`, and it is **NOT**  `Comparable`.
Methods `getKey()` and `getValue()` return the key and value respectively. However, `Entry` cannot be added to `Map` 
directly, only using `put(key, value)`.

3. The mechanism used to add element to `Set` is: checks if the element exists in the `Set` 
based on hash code, and then create and add a new element in the `Set`.

4. The element in `TreeSet` has to be `Comparable`.

5. Remember the pain caused by ***flyweight design pattern***, see 
[SetFilling.java](https://github.com/kean0212/Thinking-In-Java-Notes/blob/master/ContainersInDepth/SetFilling.java#L23).


    