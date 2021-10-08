package S181860047;
import S181860047.Line.Position;
public class Matrix {

    public Matrix(int length) {
        this.positions = new Position[length];
    }

    private Position[] positions;

    public void put(Linable linable, int i) {
        if (this.positions[i] == null) {
            this.positions[i] = new Position(null);
        }
        this.positions[i].setLinable(linable);
    }

    public Linable get(int i) {
        if ((i < 0) || (i > positions.length)) {
            return null;
        } else {
            return positions[i].getLinable();
        }
    }

    @Override
    public String toString() {
        String lineString = "";
        int i = 1;
        for (Position p : positions) {
            if (i % 16 == 0)
                lineString += p.getLinable().toString(0) + "\n\n";
            else
                lineString += p.getLinable().toString(0);
            i++;
        }
        return lineString;
    }

    public Linable[] toArray() {
        Linable[] linables = new Linable[this.positions.length];

        for (int i = 0; i < linables.length; i++) {
            linables[i] = positions[i].getLinable();
        }

        return linables;

    }
}
