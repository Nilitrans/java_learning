package tw.com.study;

import org.junit.Assert;
import org.junit.Test;

public class GroupingTest {
    Grouping grouping = new Grouping();
    @Test
    public void shouldReturn0whenGiven2EmptyGroup() {
        int[] arrayA = {};
        int[] arrayB = {};
        Assert.assertEquals(0,grouping.group(arrayA,arrayB,1,0,0));
    }

    @Test
    public void shouldReturn0whenOnlyOneOfTheGroupHasMember() {
        int[] arrayA = {1};
        int[] arrayB = {};
        Assert.assertEquals(0,grouping.group(arrayA,arrayB,1,1,0));
    }

    @Test
    public void shouldReturn1WhenTwoGroupsWithOneMemberWithinTheDifference() {
        int[] arrayA = {3};
        int[] arrayB = {4};
        Assert.assertEquals(1,grouping.group(arrayA,arrayB,1,1,1));
    }

    @Test
    public void shouldReturn0WhenTwoGroupsWithOneMemberEachBeyondTheDifference() {
        int[] arrayA = {3};
        int[] arrayB = {6};
        Assert.assertEquals(0,grouping.group(arrayA,arrayB,1,1,1));
    }

    @Test
    public void shouldReturn0WhenGivenTwoGroupWithMultipleMembersButNoPairWithinTheDifference() {
        int[] arrayA = {3,8};
        int[] arrayB = {6};
        Assert.assertEquals(0,grouping.group(arrayA,arrayB,1,2,1));
    }

    @Test
    public void shouldReturn1WhenGivenTwoGroupWithMultipleMembersAndOnePairWithinTheDifference() {
        int[] arrayA = {3,7};
        int[] arrayB = {6};
        Assert.assertEquals(1,grouping.group(arrayA,arrayB,1,2,1));

    }

    @Test
    public void shouldReturnGroupedNumberWithMultipleMembersV1() {
        int[] arrayA = {3,7,8};
        int[] arrayB = {6,4};
        Assert.assertEquals(2,grouping.group(arrayA,arrayB,4,3,2));
    }
    @Test
    public void shouldReturnGroupedNumberWithMultipleMembersV2() {
        int[] arrayA = {1,10,20,26};
        int[] arrayB = {2,7,14,23,100};
        Assert.assertEquals(3,grouping.group(arrayA,arrayB,3,4 ,5));
    }

    @Test
    public void should_give_correct_grouping_result_when_given_three_lines_of_information() {
        Assert.assertEquals(3,grouping.originalGroupingInformationInput("3 4 5\n" +
                "1 10 20 26\n" +
                "2 7 14 23 100"));
    }

    @Test
    public void should_given_correct_grouping_result_when_given_three_lines_of_information_instance_2() {
        Grouping grouping = new Grouping();
        Assert.assertEquals(4,grouping.originalGroupingInformationInput("0 5 5\n" +
                "1 74 50 23 10\n" +
                "10 50 23 74 100"));
    }
}
