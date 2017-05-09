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
**Note**: No matter it's `fill` or `nCopies`, the reference of the specified object (even for the object instantiated 
using `new` ) is used to fill the `List`, which means if the specified object changes, the `List` changes. Even though 
the result of `nCopies` is immutable (which means the value (reference) of the element is immutable), the `List` still
reflects the change.
  
### A Generator Solution
1. All `Collection` subtypes have a constructor which takes another `Collection` instance 
to fill the new container
    ```java
    List<String> stringList = Arrays.asList({"hello", "world"});
    Set<String> stringSet = new HashSet<String>(stringList);
    List<String> stringListTwo = new ArrayList<String>(stringList);
    Queue<String> stringQueue = new Queue<String>(stringList);
    ```
    
2. Method `toCollection.addAll(fromCollection)` can be used to fill a `Collection` as well.

### Map Generators
1. Read-only **Data Transfer Object**:
    ```java
    // This is a data object
    // "public" makes it easy to access,
    // "final" makes it immutable
    public class DTO<T> {
        public final T property;
        ...
    }
    ```

### Using Abstract Classes
1. All containers including `Collection`, `List`, `Set`, and `Map` have abstract classes, 
so that we only need to implement partial methods to produce the desired container.

2. **Flyweight** design pattern: it is a design pattern that uses only simple properties to satisfy
a complex need, such as adding a `size` property in a `EntrySet` to indicate what data is stored in
the `EntrySet` instead of storing the real data inside the `EntrySet`.

### Unsupported Operations
It appears that some methods in `interface` are optional, meaning that the implementing classes
do **NOT** have to implement those methods. For example, the `List` returned by `Arrays.asList(array)`
does not support the optional methods, such as `add()`, `remove()`, becuase the list is fixed-size.

### ListIterator
1. A **bidirectional** iterator of `List`.

2. It is a cursor between nodes, shown as follow:

    ![alt text](https://github.com/kean0212/Thinking-In-Java-Notes/blob/master/ContainersInDepth/img/ListIterator.png)
3. The call of `previous()` or `next()` will move the cursor.

4. Method `add(element)` adds the element to the left of the cursor; while `set(element)` sets the element
returned by the last call of `previous()` or `next()`. Under both circumstances, the cursor postion is updated.

**Note**: When using `ListIterator` to add element backwards, pay attention to `previous()`. The number of 
the calls in [ListInsertion.java](https://github.com/kean0212/Thinking-In-Java-Notes/blob/master/ContainersInDepth/ListInsertion.java#L39).
