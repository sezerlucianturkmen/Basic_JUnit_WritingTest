import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test09_RepeatingTest {

    @RepeatedTest(10)
    void repeatTest(){
        System.out.println("This test is repeating");
    }

    @RepeatedTest(value = 3,name = "{displayName} {currentRepetition}. Try /{totalRepetitions} TEST")
    @DisplayName("Rename ")
    void repeatDisplayMode(){
        System.out.println("Special repeat mode");
    }
}
