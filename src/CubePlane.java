import java.util.HashMap;

public class CubePlane {
    private static final String[] COLOR = {"B", "W", "O", "G", "Y", "R"};
    private static final String[] DIRECTION = {"top", "front", "right", "left", "back", "bottom"};
    private static final int SIZE = 3;
    private HashMap<String, String[][]> cube;

    public CubePlane(String command) {
        if (command.equals("1"))
            makeNormalPlane();
        if (command.equals("2"))
            makeShufflePlane();
    }

    private void makeNormalPlane() {
        for(String s : DIRECTION)
            for (String a : COLOR)
                this.cube.put(s,makeColorArray(a));
    }

    private String[][] makeColorArray(String color) {
        String[][] colorPlane = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++) {
                colorPlane[i][j] = color;
            }
        return colorPlane;
    }

    private void makeShufflePlane() {

    }

    public HashMap<String, String[][]> getCube(){
        return this.cube;
    }
}

