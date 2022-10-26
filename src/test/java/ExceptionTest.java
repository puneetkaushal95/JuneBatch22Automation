public class ExceptionTest {

    public void divide(int a, int b){
        int result = 0;
        try{
            result = a/b;
        } catch (ArithmeticException ex){
            System.out.println("Invalid operation, can't divide number by zero, please provide valid number");
            result = -1;
        }
        System.out.println("Result is: " + result);
    }

    public static void main(String[] args) {

        ExceptionTest ext = new ExceptionTest();
        ext.divide(10, 0);
    }
}
