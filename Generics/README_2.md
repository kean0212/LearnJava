## Mystery of Erasure
### Foundings
1. **Truth**: There's no information about generic parameter types available inside generic code. 
Thus, we can know things like the ***identifier*** of the parameter type using:
    ```java 
    // An array of identifiers such as T, E, K, V, etc.
    Class.getClass().getTypeParameters(); 
    ```
    and the ***bound*** of the parameter type, like 
    ```java
    // String is the bound of the parameter type
    class Test<T extends String> { ... } 
    ```
2. Generic is implemented using ***erasure***. This means that any specific type information is 
erased when we use generics. For example, `List<String>` and `List<Integer>` are the same at 
run time.
3. Therefore, in order to call the methods of parameter type, we need to assist the generic 
class by giving it a bound (e.g. `<T extends String>`). The compiler replaces the parameter 
type with its erasure, which in this case is the ***bound***.