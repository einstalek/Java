import java.util.Scanner;
import java.util.TreeMap;

/*
Задача 2057
 */

public class Solution {

    public static class SpecialMap {

        private TreeMap<Integer, Integer> map;

        public SpecialMap() {
            map = new TreeMap<Integer, Integer>();
        }

        public void push(Integer x) {
            if (map.containsKey(x))
                map.put(x, map.get(x) + 1);
            else
                map.put(x, 1);
        }

        public Integer pop() {
            Integer min_value = map.firstKey();
            if (map.isEmpty()) return null;
            map.put(min_value, map.get(min_value)-1);
            if (map.get(min_value) == 0)
                map.remove(min_value);
            System.out.println(min_value);
            return min_value;
        }

        public void print() {
            System.out.println(this.map);
        }
    }

    public static void main(String[] args) {
        SpecialMap map = new SpecialMap();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int command, value;
        for (int i = 0; i < n; i++) {
            command = sc.nextInt();
            if (command == 2) {
                map.pop();
            }
            else if (command == 1) {
                value = sc.nextInt();
                map.push(value);
            }
        }
    }

}
