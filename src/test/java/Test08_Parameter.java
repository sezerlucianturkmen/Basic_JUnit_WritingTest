import static org.junit.jupiter.api.Assertions.*;

import entity.Sex;
import entity.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.*;

import java.util.EnumSet;

public class Test08_Parameter {


    @ParameterizedTest
    @ValueSource(strings = {"sezer"})
    void parameterUsage(String s){
        assertTrue(s.startsWith("s"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"sezer","john","deniz","hakan"})
    void parameterMultiUsage(String s){
        assertTrue(s.startsWith("s"));
    }

    @ParameterizedTest
    @ValueSource(ints = {3,32,1,53,9})
    void integerMultiUsage(int n){
        assertTrue(n %2 == 1,"Not a odd number");
    }

    /**
     * Burada ENUM için girilen değerler eğer ENUM CLass içinde var olan
     * değerler ile eşleşmez ise test bu işlemi başlatamıyor.
     * @param sex
     */
    @ParameterizedTest
    @EnumSource(names = {"Female","Male"})
    void enumUsage(Sex sex){
        assertTrue(
                EnumSet.of(Sex.Female).contains(sex)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "Sezer,  40",
            "Deniz,     34",
            "John,     12"
    })
    void csvUsage(String user, int age){
        assertNotNull(user);
        System.out.println("User....: "+ user);
        assertTrue(age>18);
    }

    /**
     * Parametre olarak aranılan tüm alanlar için mutlaka CSV dosyası içinde
     * içi boş dahi olsa virgül(,) ile ayrılmış bir alanın olması gereklidir.
     * Aksi takdirde test bu değeri atayamadığı için hata verecektir.
     * @param user
     * @param age
     * @param address
     */
    @ParameterizedTest
    @CsvFileSource(resources = {"/userList.csv","test2.csv"})
    void csvSourceUsage(String user, int age, String address){
        assertNotNull(user);
        System.out.println("User....: "+ user);
        System.out.println("Address........: "+ address);
        assertTrue(age>18);
    }

    /**
     * Belli bir konumda bulan dosyaları kullanmak için files tercih ederiz.
     * -> e:/testfiles/test1.csv
     * @param user
     * @param age
     * @param address
     */
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/userList.csv")
    void csvFileSourceUsage(String user, int age, String address){
        assertNotNull(user);
        System.out.println("User....: "+ user);
        System.out.println("Address........: "+ address);
        assertTrue(age>18);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "MOCK_DATA.csv",numLinesToSkip = 900)
    void csvArgumentUsage(ArgumentsAccessor arg){
        User user = new User(
                arg.getLong(0), // id
                arg.getString(1),// name
                arg.getString(2),//surname
                arg.getString(3), //address
                arg.getString(4), // phone
                arg.get(5, Sex.class)
        );
        System.out.println(user.toString());
        assertTrue(user.getName().startsWith("A"));
    }

}
