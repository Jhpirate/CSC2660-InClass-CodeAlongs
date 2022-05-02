package week_5_lash_polymorphism;

import java.util.ArrayList;

public class PolymorphismExample {
    public static void main(String[] args) {
        ArrayList<BaseCalculator> calculationList = new ArrayList<>() {{
            add(new AddCalc(5, 7));
            add(new MultiplyCalc(9, 2));
//            add(new Calculator(12, 53)); //not allowed because BaseCalculator is abstract (cannot create an instance of the base class)
        }};

        for (BaseCalculator baseCalculator : calculationList) {
            System.out.printf("%s [%s]\n", baseCalculator.getClass().getSimpleName(), baseCalculator.performCalculation());
        }


        Notification notification = new Notification();
        notification.sendMessage();
        notification.sendMessage(5);
        notification.sendMessage("Hello World!");
        notification.sendMessage("Hi There!", "Adam West");

    }
}

abstract class BaseCalculator {
    protected int x;
    protected int y;

    protected BaseCalculator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int performCalculation() {
        return 0;
    }

    @Override
    public String toString() {
        return "BaseCalculator {%s, %s}".formatted(x, y);
    }
}

class MultiplyCalc extends BaseCalculator {

    public MultiplyCalc(int x, int y) {
        super(x, y);
    }

    @Override
    public int performCalculation() {
        return this.x * this.y;
    }
}

class AddCalc extends BaseCalculator {

    public AddCalc(int x, int y) {
        super(x, y);
    }

    @Override
    public int performCalculation() {
        return this.x + this.y;
    }
}

class Notification {
    // Demonstration of method overloading (polymorphic methods)
    // (Same method with different number of parameters)
    public boolean sendMessage() {
        System.out.println("Message sent to default user with no message");
        return true;
    }

    public boolean sendMessage(String message) {
        System.out.printf("Message sent to default user with content: %s\n", message);
        return true;
    }

    public boolean sendMessage(String recipient, String message) {
        System.out.printf("Sending message to user: %s with message: %s\n", recipient, message);
        return true;
    }

    public boolean sendMessage(int numOfTimes) {
        System.out.printf("We are sending the message #%s times\n", numOfTimes);
        return true;
    }
}
