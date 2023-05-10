package interfaces;

import org.junit.jupiter.api.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface ITestInterface {

    static final Logger logg = Logger.getLogger(ITestInterface.class.getName());

    @BeforeAll
    default void beforeAllTest(){
        logg.log(Level.WARNING,"Bu olmadı");
        System.out.println("TEST BAŞLADI ....: "+ System.currentTimeMillis());
    }
    @AfterAll
    default void afterAllTest(){
        System.out.println("TEST BİTTİ ....: "+ System.currentTimeMillis());
    }
    @BeforeEach
    default void beforeEachTest(){
        System.out.println("Birim Testi Başladı....: "+ System.currentTimeMillis());
    }
    @AfterEach
    default void afterEachTest(){
        System.out.println("Birim Testi Bitti....: "+ System.currentTimeMillis());
    }

}

