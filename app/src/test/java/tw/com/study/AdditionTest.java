package tw.com.study;

import org.junit.Assert;
import org.junit.Test;

public class AdditionTest {
    @Test
    public void should_return_sum_when_given_two_numbers() {
        Addition addition = new Addition();
        int sum = addition.sum(1, 3);
        Assert.assertEquals(4, sum);
    }
}
