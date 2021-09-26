package alivestill;

public class SystemCommands {

    public static void main(String[] args) throws Exception {
        Process pros = Runtime.getRuntime().exec("pwd");
        System.out.println("command `pwd` has been executed successfully.");
        pros.waitFor();
    }
}
