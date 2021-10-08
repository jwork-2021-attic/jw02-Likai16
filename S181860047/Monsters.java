package S181860047;

import java.util.Random;

import S181860047.Line.Position;

public class Monsters {
    static class Monster implements Linable {
        private final int r;
        private final int g;
        private final int b;

        private Position position;
        public static int flag = 0;
        private int rank_;

        Monster(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
            flag++;
            setRank(flag);
        }

        void setRank(int rank) {
            this.rank_ = rank;
        }

        int rank() {
            return this.rank_;
        }

        @Override
        public int getValue() {
            return this.rank();
        }

        @Override
        public void setPosition(Position position) {
            this.position = position;
        }

        @Override
        public Position getPosition() {
            return this.position;
        }

        public void swapPosition(Monster another) {
            Position p = another.position;
            this.position.setLinable(another);
            p.setLinable(this);
        }

        // @Override
        public String toString(int a) {
            if (a == 1)
                return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m  " + this.rank()
                        + "  \033[0m";
            else
                return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m "
                        + String.format("%03d", this.rank()) + "  \033[0m  ";
        }

    }

    static Monster[] monsters;

    Monsters(int nums) {
        monsters = new Monster[nums];
    }

    void initMonster() {
        Monster.flag = 0;
        Random rd = new Random();
        for (int i = 0; i < monsters.length; i++)
            // if (monsters[i] == null)
            monsters[i] = new Monster(rd.nextInt(256), rd.nextInt(256), rd.nextInt(256));

    }

    static Monster getMonsterByRank(int rank) {
        for (Monster m : monsters)
            if (m.rank() == rank)
                return m;
        return null;
    }

}
