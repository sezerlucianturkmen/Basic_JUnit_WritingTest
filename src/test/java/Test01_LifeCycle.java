import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test01_LifeCycle {

    /**
     * ilk önce çalışan kısımdır ve tekrar etmez
     */
    @BeforeAll
    void initAll(){

        System.out.println("1. step");
    }

    /**
     * 2. adımda çalışır ve her test için ayrı ayrı çalışmaya devam eder.
     */
    @BeforeEach
    void init(){
        System.out.println("2. step repeat");
    }

    @Test
    void succesfulTest(){
        System.out.println("Test is done.");
    }

    @Test
    void unsuccesfulTest(){
        fail("Unfortunately test is not done :(");
        System.out.println("Here it is a test. :)");
    }

    @Test
    @Disabled("Not functioning anymore")
    void disabledTest(){
        System.out.println("Test example");
    }

    @Test
    void abortedTest(){
        assertEquals(5,"Sezer".length());
        fail("I have been left alone");
    }

    /**
     * Her  test sonlandıktan sonra tekrar tekrar çalışan kısım
     */
    @AfterEach
    void lastFunctioning(){
        System.out.println("Functions works in the each of end");
    }

    /**
     * tüm test ve kodlamalar bittikten sonra çalışan kısım
     */
    @AfterAll
    void theEnd(){
        System.out.println("I left the last...");
    }
}
