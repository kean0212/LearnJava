import java.util.*;

public class DogOverload {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.main();
    }

}

class Dog {
    void bark(int i) {
        System.out.println("bark: int");
    }
    void bark(double i) {
        System.out.println("bark: double");
    }
    void bark(char i) {
        System.out.println("bark: char");
    }
    void bark(float i) {
        System.out.println("bark: float");
    }

    void bark(int i, char c) {
        System.out.println("bark: int & char");
    }

    void bark(char c, int i) {
        System.out.println("bark: char & int");
    }

    void main() {
        bark('d');
        bark(2);
        bark(2.0f);
        bark(3.0d);

        bark(3, 'c');
        bark('c', 3);
    }
}