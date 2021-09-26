package alivestill.chaos;

import java.util.Arrays;
import java.util.Comparator;

public class DropWhileTest {

    public static void main(String[] args) {
        String str = "this is something we are looking for without any trouble";
        Arrays.stream(str.split(" "))
                .sorted(Comparator.comparingInt(String::length))
                .distinct()
                .limit(3)
                .forEach(System.out::println);
        // 这样的级联表达式虽然简洁却不好调试，需要编写者拥有熟练的技巧。
    }
}
