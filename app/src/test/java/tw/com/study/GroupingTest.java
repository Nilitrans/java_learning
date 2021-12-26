package tw.com.study;

import org.junit.Assert;
import org.junit.Test;

public class GroupingTest {
    @Test
    public void should_give_correct_grouping_result_when_given_three_lines_of_information() {
        Grouping grouping = new Grouping();
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
