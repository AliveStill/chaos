package alivestill;

import java.util.ArrayList;
import java.util.List;

public class SupplierExtendsConsumerSuper {

    public static void main(String[] args) {
        // note, supplier extends, can read, can't add
        List<? extends vBase> list = new ArrayList<vDerived>() {{
            this.add(new vDerived());
        }}; // only allowed when initialized
//        list.add(new vDerived());   // not allowed

        // note, consumer super, can add, can't read
        // note, because we can't ensure the type of such an element (we can use Object only)
        List<? super vDerived> list2 = new ArrayList<vBase>();
        list2.add(new vDerived());
//        obj v = list2.get(0); // not allowed
    }
}

class vBase {

}

class vDerived extends vBase {

}
