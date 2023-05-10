import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class Test10_TimeoutTest {

    @Test
    @Timeout(1)
    void method1() throws InterruptedException {
        Thread.sleep(1900);
        System.out.println("Long test");
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void method2() throws InterruptedException {
        Thread.sleep(499);
        for(int i=0;i<10_000_000;i++)
            if(i==999_999)
                System.out.println("Long test");
    }

}
