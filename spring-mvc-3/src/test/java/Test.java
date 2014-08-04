import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wenzhouyang on 2014/8/5.
 */
public class Test {

    public static void main(String[] args) {
        String patrn;
        patrn = "[^('\"<>()~!@#$%^&*+=,./\\\\]*";

        Pattern pattern = Pattern.compile(patrn);
        Matcher matcher = pattern.matcher("wo温周洋123__'");
        System.out.println(matcher.matches());
    }
}
