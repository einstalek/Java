import com.sun.corba.se.spi.ior.ObjectKey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Arrays.sort;

public class Main {
    public static void main(String[] args) {

        List<Integer> l1 = new ArrayList<Integer>(asList(1, 2, 3));
        List<Double> l2 = new ArrayList<Double>(Arrays.asList(4.1, 5.1, 6.2));

        System.out.println(l1);
        System.out.println(l2);

        List l = CollectionUtils.join(l1, l2);
        System.out.println(l);
//
        System.out.println(l1);
        System.out.println(l2);
    }
}
