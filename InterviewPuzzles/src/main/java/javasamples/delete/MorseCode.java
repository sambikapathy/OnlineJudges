package javasamples.delete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MorseCode {
    private static final String[] mapping = new String[]{"A", ".-", "B", "-...", "C", "-.-.", "D", "-..", "E", ".", "F", "..-.", "G", "--.", "H", "....", "I", "..", "J", ".---", "K", "-.-", "L", ".-..", "M", "--", "N", "-.", "O", "---", "P", ".--.", "Q", "--.-", "R", ".-.", "S", "...", "T", "-", "U", "..-", "V", "...-", "W", ".--", "X", "-..-", "Y", "-.--", "Z", "--..", "0", "------", "1", ".-----", "2", "..---", "3", "...--", "4", "....-", "5", ".....", "6", "-....", "7", "--...", "8", "---..", "9", "----."};

    static Set<String> words = new HashSet<>();
    static Map<String, String> codeMapping = new HashMap<>();

    private static void populateMapping() {
        for (int i = 0; i < mapping.length; i += 2) {
            codeMapping.put(mapping[i + 1], mapping[i]);
        }
        Arrays.stream(new String[]{"AN", "EARTHQUAKE", "EAT", "GOD", "HATH", "IM", "READY", "TO", "WHAT", "WROTH"}).forEach(item -> words.add(item));
    }


    public static void main(String[] args) {
        populateMapping();
        String[] temp = new String[]{".--.....--   .....--....", "--.----..   .--.-.----..", ".--.....--   .--.", "..-.-.-....--.-..-.--.-.", "..--   .-...--..-.--", "----        ..--"};
        List<String> input = new ArrayList<>();
        for (String str : temp) {
            String[] parts = str.split("\\s+");
            for (String part : parts) {
                input.add(part);
            }
        }

        for (String data : input) {
            if (!".--.-.----..".equals(data)) {
//                continue;
            }
            Set<String> list = new HashSet<>();
            findWord(data, "", new ArrayList<>(), list);
            System.out.println(list);
//            System.out.println(count);
//            break;
        }
    }

    private static void findWord(String data) {

    }

    static int count = 0;
    static Set<String> visited = new HashSet<>();
    private static void findWord(String data, String prefix, List<String> temp, Set<String> result) {
        if(visited.contains(data+":"+prefix)){
            return;
        }
        if (data.length() == 0) {
            if (codeMapping.containsKey(prefix)) {
                temp.add(codeMapping.get(prefix));
                String concat = (String.join("", temp));
                if (words.contains(concat)) {
                    result.add(concat);
                } else {
//                    System.out.println(concat);
                }
                temp.remove(temp.size() - 1);
            }
            return;
        }

        // Its end of current word or continue with it
        //for (int i = 0; i < data.length(); i++) {
        if (codeMapping.containsKey(prefix)) {
            temp.add(codeMapping.get(prefix));
            findWord(data.substring(1), "" + data.charAt(0), temp, result);
            temp.remove(temp.size() - 1);
        }
        findWord(data.substring(1), prefix + data.charAt(0), temp, result);
//        visited.add(data+":"+prefix);
        //}

    }
}
