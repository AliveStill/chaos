package alivestill.DesignPattern;

import java.util.ArrayList;
import java.util.List;

// note, 一些基本配件不会变，但是其组成配比经常改变，于是可以用builder模式控制其创建过程
public class Builder {

    public static Human build() {
        Human human = new Human();
        human.add(new Kidney());
        human.add(new Liver());
        return human;
    }

    public static void main(String[] args) {
        Human human = Builder.build();
    }
}

class Human {
    List<Organ> list = new ArrayList<>();

    public void add(Organ og) {
        list.add(og);
    }
}

class Organ {

}

class Kidney extends Organ {

}

class Liver extends Organ {

}
