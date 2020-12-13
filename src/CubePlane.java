import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CubePlane {
    private static final String[] COLOR = {"B", "W", "O", "G", "Y", "R"};
    private final String[] DIRECTION = {"top", "left", "front", "right", "back", "bottom"};
    private static final int SIZE = 3;
    private final HashMap<String, String[][]> cube;

    public CubePlane(String command) {
        cube = new HashMap<>();
        if (command.equals("1"))
            makeNormalPlane();
        if (command.equals("2"))
            makeRandomPlane();
    }

    private void makeNormalPlane() {
        for (int i = 0; i < DIRECTION.length; i++)
            this.cube.put(DIRECTION[i], makeNormalColorPlane(COLOR[i]));
    }

    private void makeRandomPlane() {
        ArrayList<String> randomArray = new ArrayList<>();
        int count = 0;
        makeRandomColorArray(randomArray);
        for (String s : DIRECTION)
            this.cube.put(s, makeRandomColorPlane(randomArray, count++));
    }

    private String[][] makeNormalColorPlane(String color) {
        String[][] colorPlane = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colorPlane[i][j] = color;
            }
        }
        return colorPlane;
    }

    private void makeRandomColorArray(ArrayList<String> randomArray) {
        for (String s : COLOR) {
            for (int j = 0; j < SIZE * SIZE; j++) {
                randomArray.add(s);
            }
        }
        Collections.shuffle(randomArray);
    }

    private String[][] makeRandomColorPlane(ArrayList<String> randomArray, int count) {
        String[][] colorPlane = new String[SIZE][SIZE];
        for (int j = 0; j < SIZE * SIZE; j++) {
            colorPlane[j / SIZE][j % SIZE] = randomArray.get(j + (SIZE * SIZE * count));
        }
        return colorPlane;
    }

    public HashMap<String, String[][]> getCube() {
        return this.cube;
    }
}