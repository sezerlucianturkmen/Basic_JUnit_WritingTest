import com.pera.Calculation;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
public class Test03_AssertUsing {

    private final Calculation calc= new Calculation();

    @Test
    void standartAsseritons() throws Exception {
        assertEquals(14,calc.sum(9,5));
        assertEquals(45,calc.multiply(9,5),"something went wrong");
        assertTrue(calc.divide(90,10)==9);
        assertTrue(calc.divide(90,10)==10, ()-> "it is necessary to write down something");
    }

    @Test
    void groupedAssertions(){
        assertAll("first control list",
                ()-> assertEquals(5,calc.sum(3,2)),
                ()-> assertTrue(20>calc.divide(200,4))
        );
    }

    @Test
    void exceptionTesting(){
        Exception exception = assertThrows(Exception.class,()-> calc.divide2(2,0));
        assertEquals("/ by zero",exception.getMessage());
    }

    @Test
    void exceptionTestingInnerCode(){
        Exception exception = assertThrows(ArithmeticException.class,()->{
            int i=1, s=0;
            int result = i/s;
        });
        assertEquals("/ by zero",exception.getMessage());
    }

    @Test
    void timeoutTest(){
        assertTimeout(Duration.ofSeconds(1),()->{
            System.out.println("Succesful");
            Thread.sleep(800);
            System.out.println("It is done");
        });
    }

    @Test
    void timeoutResultTest(){
        String result = assertTimeout(Duration.ofMinutes(1),()->{
            return "It is done";
        }) ;
        assertEquals("It is done", result);
    }

}
