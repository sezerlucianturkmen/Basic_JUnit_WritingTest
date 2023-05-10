import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("This class helps for DB relation test")
public class Test02_DisplayName {

    @Test
    @DisplayName("Sort by the name of users")
    void findAllByUserNameTest(){
        System.out.println("Here it is the list of all user.");
    }

    @Test
    @DisplayName("😱")
    void whatHappens(){

    }

    @Nested
    class nestedClass{

        @Test
        @DisplayName("example fot the nested class")
        void trialTest(){

        }
    }
}
