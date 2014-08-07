import org.springframework.cglib.core.Local;

import java.util.Locale;

/**
 * @version 1.5
 *          Created by wenzhouyang on 8/7/2014.
 */
public class T {
    public static void main(String[] args) {
        Locale[] locales = Locale.getAvailableLocales();
//        for (Locale locale : locales) {
//            System.out.println(locale.toString());
//        }

        System.out.println(Locale.CHINA);
    }
}
