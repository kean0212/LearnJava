public class DemonstrateAssertions<T> { // class parameter
    T[] array;

    @SuppressWarnings("unchecked")
    public void ArrayOfGenericType(int size) {
//        array = new T[size];
        array = (T[])new Object[size];
    }

//    public <U> U[] makeArray() {
//        return new U[10];
//    }
}