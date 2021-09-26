package alivestill.DesignPattern;

// note， 适用于系统中只需要也只能创建同一个类的一个示例的情形
public class Singleton {

    public static Atom getSingleton() {
        System.out.println("get into getSingleton()");
        return Nested.getAtom();
    }

    static class Nested {
        public static Atom atom;
        static {
            System.out.println("Build new Atom instance");
            atom = new Atom();
        }
        public static Atom getAtom() {
            return atom;
        }
    }

    public static void main(String[] args) {
        Atom atom = getSingleton();
    }
}

class Atom {

}
