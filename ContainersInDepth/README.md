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

## Filling Containers
### `Collections` -- `fill` and `nCopies` for `List`
1. `fill(list, object)`: replaces all elements with the specified object
    * An **empty** list after `fill` is still **empty**

2. `nCopies(number, object)`: returns an **immutable** list of the specified objects.
    ```java
    // Output: "immutable" list: [world, world, world, world]
    List<String> list = Collections.nCopies(4, "world"); 
      
    // To make it "mutable" - construct a "mutable" list
    list = new ArrayList<String>(list);
    ```
**Note**: no matter it's `fill` or `nCopies`, the reference of the specified object is used to fill the 
`List`, which means if the specified object changes, the `List` changes. Even though the result of 
`nCopies` is immutable (which means the value (reference) of the element is immutable), the `List` still
reflects the change.
    