package tw.com.study;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;


public class GuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
//        int answer = random.nextInt(10)+1;
        Scanner in = new Scanner(System.in);
        for(;;) {
            int answer = random.nextInt(10)+1;
            while (in.hasNextInt()) {
                int n = in.nextInt();//should have this line inside the loop
                System.out.println(checkTheAnswer(n, answer));
                if (checkTheAnswer(n, answer).equals("correct")) {
                    break;
                }
            }
            if(in.nextInt()==0){
                break;
            }
        }
        System.out.println("end of the game"+"\n");

    }

    private static String checkTheAnswer(int n,int answer) {
        String[] comments = {"too low", "too high","too high","too low"};
        Random ran = new Random();
        return n==answer? "correct" : comments[ran.nextInt(comments.length)];
    }

}
