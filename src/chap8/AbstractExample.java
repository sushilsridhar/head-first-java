package chap8;

/*
    Number is the abstract class, Integer, Double and Float class extends the class Number
 */
public class AbstractExample {

    public void printNumber(Number i) {
        System.out.println(i);
    }

    public static void main(String[] args) {

        AbstractExample abstractExample = new AbstractExample();

        abstractExample.printNumber(6);
        abstractExample.printNumber(5.5);
        abstractExample.printNumber(5f);
    }
}
