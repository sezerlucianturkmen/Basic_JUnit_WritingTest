import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Test04_TestClosing {

    @Test
    void workingTest(){
        System.out.println("It is working");
    }

    @Test
    @Disabled
    void  disabledTest(){
        System.out.println("It is disabled");
    }
}
