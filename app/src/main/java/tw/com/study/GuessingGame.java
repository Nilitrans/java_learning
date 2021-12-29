package tw.com.study;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class GuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        List<String> cheatRecord=new ArrayList<>();
        String cheatRecordForEachRound="maybe";
        for(;;) {
            int answer = random.nextInt(10)+1;
            while (in.hasNextInt()) {
                int n = in.nextInt();//should have this line inside the loop
                System.out.println(checkTheAnswer(n, answer));
                if(cheatingCheck(n,answer,checkTheAnswer(n, answer))){
                    cheatRecordForEachRound="yes";
                }
                if (checkTheAnswer(n, answer).equals("correct")) {
                    cheatRecord.add(cheatRecordForEachRound);
                    break;
                }
            }
            if(in.nextInt()==0){
                break;
            }
        }
        System.out.println("end of the game"+"\n");
        System.out.println(cheatRecord);
    }

    private static Boolean cheatingCheck(int n, int answer,String comment){
        return n < answer && !comment.equals("to low") && !comment.equals("correct");
    }

    private static String checkTheAnswer(int n,int answer) {
        String[] comments = {"too low", "too high","too high","too low"};
        Random ran = new Random();
        return n==answer? "correct" : comments[ran.nextInt(comments.length)];
    }

}
