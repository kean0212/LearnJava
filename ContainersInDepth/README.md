## Coding
1. `Map` is not iterable. Therefore, the way to iterate through the `Map` is like below:
    ```java
    for(Map.Entry<T, E> entry : map.entrySet()) { ... }
    ```
    Method `entrySet` returns a `Set` of entries, all included.
2. `Map.Entry` belongs to `util` package, and methods `getKey()` and `getValue()` return
the key and value respectively. However, `Map.Entry` cannot be added to `Map` directly.
    