import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;


import static org.junit.jupiter.api.condition.OS.*;

public class Test05_ConditionalTest {
    /**
     * İşletim sisteminwe dayalı olarak çalışan testler
     */
    @Test
    @EnabledOnOs(MAC)
    void onlyOnMac(){
        System.out.println("works only on IOS");
    }

    @Test
    @EnabledOnOs(WINDOWS)
    void onlyOnWIN(){
        System.out.println("works only on Windows");
        System.out.println("System....: "+System.getProperty("os.arch"));
    }

    @Test
    @EnabledOnOs({LINUX,MAC})
    void testMulti(){

    }

    @Test
    @DisabledOnOs(WINDOWS)
    void disabledWindows(){

    }

    /**
     * Islemci mimarilerinde çalıştırma örnekleri
     */
    @Test
    @EnabledOnOs(architectures = "amd64")
    void systemIntel(){
        System.out.println("works on Intel");
    }



    @Test
    @EnabledOnOs(architectures = "aarch64")
    void systemMAC(){
        System.out.println("works on MAC");
    }

    /**
     * FArklı java sürümleri için test çalıştırmak
     */
    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void forJava17(){
        System.out.println("Java17 Test");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_19)
    void forJava19(){
        System.out.println("Java19 Test");
    }

    @Test
    @EnabledOnJre({JRE.JAVA_17,JRE.JAVA_19})
    //@EnabledForJreRange(min = JRE.JAVA_11,max = JRE.JAVA_17)
    void forJava17And19(){
        System.out.println("Java19 Test");
    }

}
