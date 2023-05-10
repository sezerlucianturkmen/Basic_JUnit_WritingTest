import interfaces.ITestInterface;
import org.junit.jupiter.api.Test;

public class Test07_TestInterface implements ITestInterface {
    @Test
    void testTry1() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("Working 1");
    }

    @Test
    void testTry2() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("Working 2");
    }

}
