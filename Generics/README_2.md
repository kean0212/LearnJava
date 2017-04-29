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