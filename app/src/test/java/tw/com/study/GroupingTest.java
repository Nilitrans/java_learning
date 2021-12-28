package tw.com.study;

import org.junit.Assert;
import org.junit.Test;

public class GroupingTest {
    Grouping grouping = new Grouping();
    @Test
    public void shouldReturn0whenGiven2EmptyGroup() {
        int[] arrayA = {};
        int[] arrayB = {};
        Assert.assertEquals(0,grouping.group(arrayA,arrayB,1));
    }

    @Test
    public void shouldReturn0whenOnlyOneOfTheGroupHasMember() {
        int[] arrayA = {1};
        int[] arrayB = {};
        Assert.assertEquals(0,grouping.group(arrayA,arrayB,1));
    }

    @Test
    public void shouldReturn1WhenTwoGroupsWithOneMemberWithinTheDifference() {
        int[] arrayA = {3};
        int[] arrayB = {4};
        Assert.assertEquals(1,grouping.group(arrayA,arrayB,1));
    }

    @Test
    public void shouldReturn0WhenTwoGroupsWithOneMemberEachBeyondTheDifference() {
        int[] arrayA = {3};
        int[] arrayB = {6};
        Assert.assertEquals(0,grouping.group(arrayA,arrayB,1));
    }

    @Test
    public void should_give_correct_grouping_result_when_given_three_lines_of_information() {
        Assert.assertEquals(3,grouping.groupWithGivenStringInfo("3 4 5\n" +
                "1 10 20 26\n" +
                "2 7 14 23 100"));
    }

    @Test
    public void should_given_correct_grouping_result_when_given_three_lines_of_information_instance_2() {
        Grouping grouping = new Grouping();
        Assert.assertEquals(4,grouping.groupWithGivenStringInfo("0 5 5\n" +
                "1 74 50 23 10\n" +
                "10 50 23 74 100"));
    }
}
