import java.lang.reflect.*;

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

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
        if (args != null) {
            for (Object arg : args) {
                System.out.println(" " + arg);
            }
        }
        return method.invoke(proxied, args);
    }
}

class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.doSomethingElse();
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);

        Interface proxy = (Interface)Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[] {Interface.class},
                new DynamicProxyHandler(realObject)
        );
        consumer(proxy);

        System.out.println("Count of doSomething() in RealObject: " + RealObject.countOfDoSomething);
        System.out.println("Count of doSomethingElse() in RealObject: " + RealObject.countOfDoSomethingElse);
    }
}