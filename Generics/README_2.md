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

## Compensating for Erasure
1. **Erasure** loses the exact type information at runtime, therefore, the methods require the 
information can **NOT** work:
    ```java
    class Test<T> {
       ...
           // Error with instanceof
           if (argument instanceof T) {
               ...
           }
           // Error with new
           T var = new T();
       ...
    }
    ```
2. The way to compensate this is adding a **type tag**, as following:
    ```java
    class Test<T> {
        Class<?> type;
        
        public Test(Class<?> type) {
            this.type = type;
        }
        ...
            if (type.isInstance(argument)) {...}
        ...
            T var = (T) type.newInstance();
    }
    ```
    
:trollface:

