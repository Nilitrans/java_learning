package tw.com.study;

import java.util.*;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class Grouping {

    private int addOneToGroupedNumIfPairNotGrouped(int result, List<Integer> alreadyGrouped, List<Integer> alreadyGroupedCompared,Integer num, Integer numCompared) {
        if(!alreadyGrouped.contains(num)&&!alreadyGroupedCompared.contains(numCompared)){
            alreadyGrouped.add(num);
            alreadyGroupedCompared.add(numCompared);
            result++;
        }
        return result;
    }

    public int group(int[] arrayA, int[] arrayB, int kValue,int numA,int numB) {
        if (arrayA.length == 0 || arrayB.length == 0) {
            return 0;
        }
        int[] comparedGroup = numA>numB? arrayB:arrayA;//{1,10,20,26}
        int[] compareToGroup = numA>numB? arrayA:arrayB;//{2,7,14,23,100}
        int[] upperBound = Arrays.stream(compareToGroup).map(num -> num=num+kValue).toArray();
        int[] lowerBound = Arrays.stream(compareToGroup).map(num -> num=num-kValue).toArray();
        int pairNumber = 0;
        List<Integer> alreadyGroupedCompareTo =new ArrayList<>();
        List<Integer> alreadyGroupedCompared =new ArrayList<>();
        for(Integer num : comparedGroup){
            for (int i = 0; i < lowerBound.length; i++) {
                if(num >= lowerBound[i] && num <= upperBound[i]){
                    pairNumber = addOneToGroupedNumIfPairNotGrouped(pairNumber, alreadyGroupedCompareTo,alreadyGroupedCompared, compareToGroup[i],num);

//                    break;

                }
            }
        }
        return pairNumber;
    }

    public int originalGroupingInformationInput(String input) {
        String[] groupA = input.split("\n")[1].split(" ");
        int[] arrayA = Arrays.stream(groupA).mapToInt(Integer::parseInt).toArray();
        String[] groupB = input.split("\n")[2].split(" ");
        int[] arrayB = Arrays.stream(groupB).mapToInt(Integer::parseInt).toArray();
        int kValue = Integer.parseInt(input.split("\n")[0].split(" ")[0]);
        int numA = Integer.parseInt(input.split("\n")[0].split(" ")[1]);
        int numB = Integer.parseInt(input.split("\n")[0].split(" ")[2]);
        return group(arrayA,arrayB,kValue,numA,numB);
    }
}
