package alivestill;

public class DoesFinallyMustBeExecuted {

    public static void main(String[] args) {
        try {
            System.out.println("try");
            System.exit(0);
        } catch (Exception e) {
            System.exit(1);
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
    }

    public void do1() {
        try {

        } catch (Exception e) {

        }
    }

    public void do2() {
        try {

        } finally {

        }
    }
}
