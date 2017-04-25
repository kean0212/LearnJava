public class HolderForThreeSameObjects<T> {
    private T objectOne;
    private T objectTwo;
    private T objectThree;

    public void setObjectOne(T objectOne) {
        this.objectOne = objectOne;
    }

    public T getObjectOne() {
        return objectOne;
    }

    public void setObjectTwo(T objectTwo) {
        this.objectTwo = objectTwo;
    }

    public T getObjectTwo() {
        return objectTwo;
    }

    public void setObjectThree(T objectThree) {
        this.objectThree = objectThree;
    }

    public T getObjectThree() {
        return objectThree;
    }

    public HolderForThreeSameObjects(T objectOne, T objectTwo, T objectThree) {
        this.objectOne = objectOne;
        this.objectTwo = objectTwo;
        this.objectThree = objectThree;
    }

    public String toString() {
        return "" + objectOne + " " + objectTwo + " " + objectThree;
    }

    public static void main(String[] args) {
        HolderForThreeSameObjects<String> holder = new HolderForThreeSameObjects<String>("hello", "world", "!");
        System.out.println(holder);
    }
}