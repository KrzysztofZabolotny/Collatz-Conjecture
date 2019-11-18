import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        checkSteps();
    }

    private static void collatz(CollatzNumber c){

        int multiplication = 0;
        int division = 0;
        int multiplicationTmp = 0;
        int divisionTmp = 0;
        int number = c.getNumber();
        int step = 0;
        int highestNumber = 0;
        while (number != 1) {
            if (number % 2 == 0) {
                number /= 2;
                step++;
                division++;
                if(division>divisionTmp)divisionTmp = division;
                multiplication = 0;


            } else if (number % 2 == 1) {
                number = number * 3 + 1;
                if(highestNumber<number)
                    highestNumber=number;
                c.setMaxValue(highestNumber);
                step++;
                multiplication++;
                if(multiplication>multiplicationTmp)multiplicationTmp = multiplication;
                division = 0;
            }
        }
        c.setStep(step);
    }
    private static void checkSteps() throws Exception{

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of steps");
        int maxStep = in.nextInt();
        System.out.println("Enter the start number");
        int startNumber= in.nextInt();
        CollatzNumber c = new CollatzNumber(startNumber);
        try (PrintWriter write = new PrintWriter(new FileWriter("numbers.txt", false))) {
            int tmp = 0;
            while (c.getMaxStep() < maxStep) {
                collatz(c);
                if (c.getMaxStep() > tmp) {
                    write.println(c);
                    write.println("____________________________________________________________________________________");
                    write.println();
                    tmp = c.getMaxStep();
                    write.flush();
                }
                c.setNumber(c.getNumber() + 1);
            }
        }

    }
}