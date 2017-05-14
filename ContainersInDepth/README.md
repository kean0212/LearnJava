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

### Sets and Storage Order
Set Type|Element Requirements
:-------------:|:-------------
`Set`| The element type should have a proper `equals()`
`HashSet`| The element type should have a proper `hashCode()`
`TreeSet`, `SortedSet`| The element type should implement `Comparable`
`LinkedHashSet`| The element type should have a proper `hashCode()`

**Note:** For good programming style, we should always override `hashCode()` when we override `equals()`.

### SortedSet
1. `SortedSet` is **ONLY** an interface which has special methods, one of the implementing class is `TreeSet`.

2. Useful methods: 
    ```java 
    // List
    list.isEmpty(); 
    
    // LinkedList
    linkedList.add(index, element); 
    linkedList.get(index);
    linkedList.getFirst();
    linkedList.getLast();
    
    // Comparable
    comparableOne.compareTo(comparableTwo);
    
    // SortedSet
    sortedSet.first();
    sortedSet.last();
    sortedSet.subSet(fromElement, toElement); // [fromElement, toElement)
    sortedSet.tailSet(fromElement); // [fromElement...)
    sortedSet.headSet(toElement); // (...toElement)
    
    ```
    
### PriorityQueue
1. The construction of `PriorityQueue` requires either `Comparator` or "natural ordering" (the element implements 
interface `Comparable`).
    ```java
    // Comparator
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(10, Collections.reverseOrder());
    
    // Natural ordering
    PriorityQueue<String> priorityQueue = new PrirotityQueue<Integer>();
    ```

1. `PriorityQueue` is a `class`, not an `interface`.

1. Methods: `offer(element), peek(), poll(), size(), clear()`; if the queue is empty, `peek()` and `poll()` will return 
`null`. 

**Recall**: `compareTo(object)` in `Comparable`; `compare(o1, o2)` of `Comparator` in `java.lang`; `compare(o1, o2)` in 
`Comparator` in `java.util`.

### Understanding Maps
Map | Characteristics of Order
:---:|:---
`HashMap`|Order is based on the hash code
`TreeMap`|Order is based on the key
`LinkedHashMap`|Order is same as the insertion order 

### Performance

`Map` | Performance
:----:|:----
`HashMap`|Provides constant-time performance for inserting and locating pairs.
`LinkedHashMap`|When iterating through it, we get the pairs in insertion order, or in least-recently-used(**LRU**).
`TreeMap`|Pairs will be in sorted order(determined by `Comparable` or `Comparator`. The only `Map` provides `subMap()` method.
`WeakHashMap`|If no references to a particular key are held outside the map,that key may be garbage collected.
`ConcurrentHashMap`|A thread-safe `Map` which does not involve synchronization locking.
`IdentityHashMap`|A hash map that uses `==` instead of `equals()` to compare keys.

**Notes**:
1. `put()` or `putAll()` updates the `Map` if the key already exists in it.
2. `keySet()` and `values()` are backed by the `Map`. Therefore, any changes to the `Collection` will be reflected in the
associated `Map`.
3. `Properties` in `java.util` package is backed by `HashTable<Object, Object>`.
