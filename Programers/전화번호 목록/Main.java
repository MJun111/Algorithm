import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] p = {"119", "97674223", "1195524421"};

        System.out.println(solution(p));
    }

    public static boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < phone_book.length; i++) {
            set.add(phone_book[i]);
        }

        for (int i = 0; i < phone_book.length; i++) {
            String str = "";
            for (int j = 0; j < phone_book[i].length(); j++) {
                str += phone_book[i].charAt(j);
                if (set.contains(str) && !str.equals(phone_book[i]))
                    return false;
            }
        }
        return true;
    }
}
