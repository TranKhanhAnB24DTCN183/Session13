package session12_bai03;

import java.util.ArrayList;
import java.util.List;

public class Session12_bai03 {
    public static void main(String[] args) {
        List<Integer> a1 = new ArrayList<>();
        a1.add(101);
        a1.add(102);
        a1.add(105);

        List<Integer> b1 = new ArrayList<>();
        b1.add(102);
        b1.add(105);
        b1.add(108);

        List<Integer> r1 = find(a1, b1);
        System.out.println("Case 1 Output: " + r1);

        List<String> a2 = new ArrayList<>();
        a2.add("DN01");
        a2.add("DN02");
        a2.add("DN03");

        List<String> b2 = new ArrayList<>();
        b2.add("DN02");
        b2.add("DN04");

        List<String> r2 = find(a2, b2);
        System.out.println("Case 2 Output: " + r2);
    }

    public static <T> List<T> find(List<T> a, List<T> b) {
        List<T> r = new ArrayList<>();

        for (T x : a) {
            if (b.contains(x) && !r.contains(x)) {
                r.add(x);
            }
        }
        return r;
    }
}
