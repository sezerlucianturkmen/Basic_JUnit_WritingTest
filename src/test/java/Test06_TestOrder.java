import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test06_TestOrder {
    @Test
    @Order(2)
    void order2(){
        System.out.println("second");
    }

    @Test
    @Order(1)
    void order1(){
        System.out.println("first");
    }
    @Test
    @Order(3)
    void order3(){
        System.out.println("third");
    }

}
