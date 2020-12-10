public class CubePlane {
    private static final String[] COLOR = {"B", "W", "O", "G", "Y", "R"};
    private static final int SIZE = 3;
    private String[][] cube;

    public CubePlane(String color) {
        this.cube = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                this.cube[i][j] = color;
    }

    public String[][] getCube() {
        return this.cube;
    }

}

