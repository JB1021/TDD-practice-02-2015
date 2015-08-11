package HttpReqeust;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegexTest {

    @Test
    public void test() {
        String string = "'I\\'m a boy.', I said.";
        System.out.println(string);

        Pattern pattern = Pattern.compile("'((?:\\\\'||[^'])+)'");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            String saying = matcher.group(1);
            System.out.println("saying: " + matcher.group(1));
        }
    }
}
