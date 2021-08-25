import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringPatterns {

    public static String symblosToEnd(String s) {
        return s.substring(2) + s.substring(0, 2);
    }

    public static String firstAndLastSymbols(String s, int n) {
        return s.substring(0, n) + s.substring(s.length() - n);
    }

    public static String deleteZip(String s) {
        return s.replaceAll("zip", "zp");
    }

    public static boolean isSameNumberIncludes(String s) {
        return (s + "\0").split("is").length == (s + "\0").split("not").length;
    }

    public static int numberIncludes(String s, String sub) {
        Pattern pattern = Pattern.compile(sub);
        Matcher matcher = pattern.matcher(s);
        Stream<String> stream = matcher.results().map(MatchResult::group);
        List<String> list = stream.collect(Collectors.toList());
        System.out.println(list);
        return list.size();
    }

    public static String telescope(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= s.length(); i++) {
            stringBuilder.append(s, 0, i);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(StringPatterns.symblosToEnd("12"));
        System.out.println(StringPatterns.firstAndLastSymbols("123456", 2));
        System.out.println(StringPatterns.deleteZip("zzzipzipp"));
        System.out.println(StringPatterns.isSameNumberIncludes("This is notnot"));
        System.out.println(StringPatterns.numberIncludes("saaasaasaaddaa", "(?=aa)"));
        System.out.println(StringPatterns.telescope("Telescope"));
    }

}
