package tw.com.study;

import java.util.*;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class Grouping {

    public int groupWithGivenStringInfo(String inputInfo) {
        String[] groupA = inputInfo.split("\n")[1].split(" ");
        String[] groupB = inputInfo.split("\n")[2].split(" ");
        int diff = Integer.parseInt(inputInfo.split("\n")[0].split(" ")[0]);
        List<Integer> convertedGroupA = Arrays.stream(groupA).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> convertedGroupB = Arrays.stream(groupB).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> upperBound = convertedGroupA.stream().map(num->num=num+diff).collect(Collectors.toList());
        List<Integer> lowerBound = convertedGroupA.stream().map(num->num=num-diff).collect(Collectors.toList());
        int result=0;
        List<Integer> alreadyGrouped =new ArrayList<>();
        for(Integer num : convertedGroupB){
            for (int i = 0; i < lowerBound.size(); i++) {
                if(num >= lowerBound.get(i) && num <= upperBound.get(i)){
                    result = addOneToGroupedNumIfPairNotGrouped(result, alreadyGrouped, num);
                }
            }
        }
        return result;
    }

    private int addOneToGroupedNumIfPairNotGrouped(int result, List<Integer> alreadyGrouped, Integer num) {
        if(!alreadyGrouped.contains(num)){
            alreadyGrouped.add(num);
            result++;
        }
        return result;
    }
    public int group(int[] arrayA, int[] arrayB, int kValue) {
        if (arrayA.length == 0 || arrayB.length == 0)
            return 0;
        if (Math.abs(arrayA[0] - arrayB[0]) <= kValue) {
            return 1;
        }
        return 0;
    }
}
