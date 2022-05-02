package week_1_lash_3_18;

class CustomExceptionHandler extends Exception {
    public CustomExceptionHandler() { }

    public CustomExceptionHandler(String message) {
        super(message);
    }
}

public class ExceptionHandling {
    public static void main(String[] args) {
        if(1 != 1) {
            try {
                throw new CustomExceptionHandler();
            } catch (CustomExceptionHandler e) {
                e.printStackTrace();
            }
        }
    }
}
