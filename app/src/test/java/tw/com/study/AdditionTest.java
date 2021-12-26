package tw.com.study;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AdditionTest {
    @Test
    public void should_return_sum_when_given_two_numbers() {
        Addition addition = new Addition();
        int sum = addition.sum(1, 3);
        Assert.assertEquals(4, sum);
    }

    @Test
    public void should_print_1_to_100() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(i);
        }
        IntStream.rangeClosed(1,100).forEach(System.out::println);
    }

    @Test
    public void should_return_a_reversed_string() {
        String string = "An apple a day keeps your doctor away";
        char[] chars = string.toCharArray();
        char[] target = new char[chars.length];
        for (int i = chars.length-1; i >= 0 ; i--) {
            char temp = chars[i];
            target[(chars.length-1)-i] =temp;
        }
        String result = new String(target);
        System.out.println(result);
    }
}
