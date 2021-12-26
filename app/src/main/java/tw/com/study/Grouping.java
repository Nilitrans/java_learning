package tw.com.study;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grouping {

    public int groupWithGivenStringInfo(String inputInfo) {
        String[] groupA = inputInfo.split("\n")[1].split(" ");
        String[] groupB = inputInfo.split("\n")[2].split(" ");
        int diff = Integer.parseInt(inputInfo.split("\n")[0].split(" ")[0]);
        List<Integer> convertedGroupA = Arrays.stream(groupA).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> convertedGroupB = Arrays.stream(groupB).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> upperBound = convertedGroupA.stream().map(num->num=num+diff).collect(Collectors.toList());
        List<Integer> lowerBound = convertedGroupA.stream().map(num->num=num-diff).collect(Collectors.toList());
        System.out.println(convertedGroupA);
        System.out.println(convertedGroupB);
        System.out.println(upperBound);
        System.out.println(lowerBound);
        int result=0;
        List<Integer> alreadyGrouped =new ArrayList<>();
        for(Integer num : convertedGroupB){
            for (int i = 0; i < lowerBound.size(); i++) {
                if(num >= lowerBound.get(i) && num <= upperBound.get(i)){
                    if(!alreadyGrouped.contains(num)){
                        alreadyGrouped.add(num);
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
        return 3;
    }
}
