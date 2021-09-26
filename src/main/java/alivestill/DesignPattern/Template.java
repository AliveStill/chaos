package alivestill.DesignPattern;

// note, 模板模式，父类调用代理，真正的执行交给子类重写的方法
public class Template {

    public static void main(String[] args) {
        Base obj = new Derived();
        obj.something();
    }

}

class Base {
    void something() {
        reallyDo();
    }

    void reallyDo() {
        System.out.println("I'm Base");
    }
}

class Derived extends Base {
    @Override
    void reallyDo() {
        System.out.println("I'm Derived");
    }
}
