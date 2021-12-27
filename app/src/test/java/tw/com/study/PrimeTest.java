package tw.com.study;
import org.junit.Assert;
import org.junit.Test;
public class PrimeTest {
    @Test
    public void should_return_num_of_grouped_prime() {
        Prime prime = new Prime();
        Assert.assertEquals(2,prime.isTwinPrim(8));
    }
}