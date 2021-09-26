package alivestill.DesignPattern;

// note， 将创建类的动作延迟到运行时，根据需要创建需要的类
public class Factory {
    public static void main(String[] args) {
        Goods apple = getInstance("Apple");
        Goods banana = getInstance("Banana");
        apple.print();
        banana.print();
    }

    public static Goods getInstance(String str) {
        if ("Apple".equals(str)) {
            return new Apple();
        } else if ("Banana".equals(str)) {
            return new Banana();
        }
        return null;
    }
}

class Goods {
    public void print() {
        System.out.println("I am goods");
    }
}

class Apple extends Goods {
    @Override
    public void print() {
        System.out.println("I am an apple");
    }
}

class Banana extends Goods {
    @Override
    public void print() {
        System.out.println("I am a banana");
    }
}


