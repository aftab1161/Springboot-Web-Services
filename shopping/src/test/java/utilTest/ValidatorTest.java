package utilTest;



import com.spring.model.Address;
import com.spring.model.User;
import com.spring.util.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;


public class ValidatorTest {



    @ParameterizedTest
    @CsvSource(
            {
                    "123,true",
                    "tEst,true",
                    "@&, false",
                    "ab&c, false",
                    "abc123&, false"
            })
    void isAlphaNumericalTest(String input, String  expected) {

        String actualValue = String.valueOf(Validator.isAlphaNumerical(input));
        Assertions.assertEquals(expected, actualValue);
    }



    @ParameterizedTest
    @CsvSource(
            {
                    "123,true",
                    "tEst,false",
                    "@&, false",
                    "ab&c, false",
                    "abc123, false"
            })
    void isNumericalTest(String input, String  expected) {

        String actualValue = String.valueOf(Validator.isNumerical(input));
        Assertions.assertEquals(expected, actualValue);
    }


    @ParameterizedTest
    @CsvSource(
            {
                    ", false",
                    "abc@gmail, false",
                    "@gmail.com, false",
                    "abc.com, false",
                    "test@gmail.com,true",
                    "@gmail.com,false",
                    "abc@iiitb.ac.in, true"
            })
    void isValidEmailTest(String input, String  expected) {

        String actualValue = String.valueOf(Validator.isValidEmail(input));
        Assertions.assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    ",false",
                    "tEst,false",
                    "abc.jpg, true",
                    "abc.ppt, false"
            })
    void isImageFileTest(String input, String  expected) {

        String actualValue = String.valueOf(Validator.isImageFile(input));
        Assertions.assertEquals(expected, actualValue);
    }


    @ParameterizedTest
    @CsvSource(
            {
                    " ,",
                    "  test,test",
                    "test  ,test",
                    "  test  ,test",
                    "te  st,test",
                    "  t es t ,test",

            })
    void removeSpacesTest(String input, String  expected) {

        String actualValue = Validator.removeSpaces(input);
        Assertions.assertEquals(expected, actualValue);
    }


    @ParameterizedTest
    @CsvSource({"1, abc@gmail.com, abc, xyz, 27, false"})
    void isUserEmptyTest(int userid, String email, String username, String password, int age, String expected) {
        User user = new User(userid, email, username, password, age, new Address());

        String actualValue = String.valueOf(Validator.isUserEmpty(user));
        Assertions.assertEquals(expected, actualValue);
    }

}
