package alivestill;

// refer to next demo
public class LazyInitiate {

    static class Builder {
        public static void build() {
            System.out.println("build");
        }
    }

    public static void main(String[] args) {
        System.out.println("begin");
        new Builder().build();
        System.out.println("end");
    }
}

class SingletonDemo {
    static class Builder {
        private static Singleton singleton;
        static {
            System.out.println("Initiate");
            singleton = new Singleton();
        }
        
        public static Singleton build() {
            System.out.println("build");
            return singleton;
        }
    }

    public static void main(String[] args) {
        System.out.println("begin");
        Singleton singleton = Builder.build();
        singleton.did();
        System.out.println("end");
    }
}

class Singleton {
    public void did() {
        System.out.println("PROCESS");
    }
}
