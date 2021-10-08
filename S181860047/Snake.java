package S181860047;

public class Snake {
    private static Snake theSnake;

    public static Snake getTheSnake() {
        if (theSnake == null)
            theSnake = new Snake();
        return theSnake;
    }

    private Sorter sorter;

    public void setSorter(Sorter sorter){
        this.sorter=sorter;
    }
    public String lineup(Line line){
        String log=new String();
        if (sorter == null) {
            return null;
        }

        Linable[] linables = line.toArray();
        int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
        }

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());

        for (String step : sortSteps) {
            this.execute(step);
            log += line.toString();
            log += "\n[frame]\n";
        }

        return log;
    }
    public String lineup(Matrix line){
        String log=new String();
        if (sorter == null) {
            return null;
        }

        Linable[] linables = line.toArray();
        int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
        }

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());

        for (String step : sortSteps) {
            this.execute(step);
            log += line.toString();
            log += "\n[frame]\n";
        }

        return log;
    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(String step) {
        String[] couple = step.split("<->");
        Monsters.getMonsterByRank(Integer.parseInt(couple[0]))
                .swapPosition(Monsters.getMonsterByRank(Integer.parseInt(couple[1])));
    }

}
