import java.util.HashMap;
import java.util.Map;

public class Main {

    static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna" +
            "aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." +
            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint" +
            "occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {

        Map<Character, Integer> map = new HashMap<>();
        giveMeCharInt(map);

        System.out.println("Символов в тексте - " + text.length()); //442
        System.out.println("Повторяющиеся буквы - " + map.size()); //21
        System.out.println(map.entrySet());
        //[a=29, b=3, c=16, d=19, e=38, f=3, g=3, h=1, i=42, l=22, m=17, n=24, o=29, p=11, q=5, r=22, s=18, t=32, u=29, v=3, x=3]
        maxMin(map);
    }

    static String textLwrCs(String text) {
        String textLwrCs = text.toLowerCase();
        return textLwrCs;
    }

    static void giveMeCharInt(Map<Character, Integer> map) {
        for (int i = 0; i < textLwrCs(text).length(); i++) {
            if (Character.isLetter(textLwrCs(text).charAt(i))) {
                if (!map.containsKey(textLwrCs(text).charAt(i))) {
                    map.put(textLwrCs(text).charAt(i), 1);
                } else {
                    int value = map.get(textLwrCs(text).charAt(i));
                    value++;
                    map.put(textLwrCs(text).charAt(i), value);
                }
            }
        }
    }

    static void maxMin(Map<Character, Integer> map) {
        Character key = ' ';
        int max = -1;
        int min = Integer.MAX_VALUE;
        for (Character k : map.keySet()) {
            int value = map.get(k);
            if (value > max) {
                key = k;
                max = value;
            }
        }
        System.out.println("Буква (" + key + ") встречается [" + max + "] раза");
        for (Character k : map.keySet()) {
            int value = map.get(k);
            if (value < min) {
                key = k;
                min = value;
            }
        }
        System.out.println("Буква (" + key + ") встречается [" + min + "] раза");
    }
}
