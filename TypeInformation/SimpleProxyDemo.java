interface Interface {
    void doSomething();

    void doSomethingElse();
}

class RealObject implements Interface {
    public static int countOfDoSomething = 0;
    public static int countOfDoSomethingElse = 0;

    public void doSomething() {
        System.out.println("do something");
        countOfDoSomething++;
    }

    public void doSomethingElse() {
        System.out.println("do something else");
        countOfDoSomethingElse++;
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    public void doSomething() {
        System.out.println("SimpleProxy do something");
        proxied.doSomething();
    }

    public void doSomethingElse() {
        System.out.println("SimpleProxy do something else");
        proxied.doSomethingElse();
    }
}

class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.doSomethingElse();
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
        System.out.println("Count of doSomething() in RealObject: " + RealObject.countOfDoSomething);
        System.out.println("Count of doSomethingElse() in RealObject: " + RealObject.countOfDoSomethingElse);
    }
}