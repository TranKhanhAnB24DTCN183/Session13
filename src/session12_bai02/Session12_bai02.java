package session12_bai02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Session12_bai02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Paracetamol");
        list.add("Ibuprofen");
        list.add("Panadol");
        list.add("Paracetamol");
        list.add("Aspirin");
        list.add("Ibuprofen");

        System.out.println("Input: " + list);

        List<String> rs = getList(list);

        System.out.println("Output: " + rs);
    }

    public static List<String> getList(List<String> list) {
        List<String> rs = new ArrayList<>();

        for (String s : list) {
            if (!rs.contains(s)) {
                rs.add(s);
            }
        }
        Collections.sort(rs);
        return rs;
    }
}
