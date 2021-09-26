package alivestill;

import java.util.Properties;

public class SystemProperties {

    /**
     * set system property(ies) in runtime, very very useful
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.setProperty("foo", "bar");
        System.out.println(System.getProperty("foo"));  // sout bar
    }
}
