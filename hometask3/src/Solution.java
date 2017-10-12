import java.util.*;

/*
Задача 2057
 */

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();

        String temp[], sym;
        while (sc.hasNext()) {
            temp = sc.nextLine().split(" ");
            if (temp != null) {
                for (String key : temp) {
                    sym = key.toLowerCase();
                    if (map.containsKey(sym))
                        map.put(sym, map.get(sym) + 1);
                    else
                        map.put(sym, 1);
                }
            }
        }
        if (map.containsKey(""))
            map.remove("");


        int max_count = 0;
        ArrayList<String> result = new ArrayList<String>();

        for (String key: map.keySet()) {
            if (map.get(key) > max_count)
                max_count = map.get(key);
        }
        for (String key: map.keySet()) {
            if (map.get(key) == max_count)
                result.add(key);
        }

        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });

        for (String x: result)
            System.out.println(x + " ");
    }

}
