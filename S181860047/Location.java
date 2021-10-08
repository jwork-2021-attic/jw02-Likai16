package S181860047;

import java.util.ArrayList;
import java.util.Random;

class Location {
    static final int count = 256;
    static ArrayList<Integer> list = new ArrayList<>(count);

    static {
        Random r = new Random();
        int i = 0;
        while (i < count) {
            int tmp = r.nextInt(count);
            if (!list.contains(tmp)) {
                list.add(tmp);
                i++;
            }
        }
    }

    static int get(int i) {
        return list.get(i);
    }

}
