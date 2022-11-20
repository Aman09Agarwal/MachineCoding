package SingletonPattern;

public class Singleton {
    private volatile static Singleton singletonObject;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singletonObject == null) {
            synchronized (Singleton.class) {
                if (singletonObject == null) {
                    singletonObject = new Singleton();
                }
            }
        }
        return singletonObject;
    }

    public void func() {
        //  do something
        System.out.println("Singleton Pattern!!");
    }
}
