package S181860047;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {
    public static void main(String[] args) throws IOException {
        final int nums = 256;
        Line line = new Line(nums);
        Matrix matrix = new Matrix(nums);
        Monsters m = new Monsters(nums);
        
        m.initMonster();
        Snake theSnake = Snake.getTheSnake();
        Sorter sorter1 = new HeapSort();
        Sorter sorter2 = new QuickSort();
        theSnake.setSorter(sorter1);
        for (int i = 0; i < nums; i++)
            matrix.put(Monsters.monsters[i], Location.get(i));
        String log = theSnake.lineup(matrix);
        BufferedWriter writer;
        writer = new BufferedWriter((new FileWriter("matrixheapsort.txt")));
        writer.write(log);
        writer.flush();
        writer.close();

    }
}
