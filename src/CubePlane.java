import java.util.ArrayList;
import java.util.Collections;
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
            makeRandomPlane();
    }

    private void makeNormalPlane() {
        for (String s : DIRECTION)
            for (String a : COLOR)
                this.cube.put(s, makeNormalColorArray(a));
    }

    private void makeRandomPlane() {
        for (String s : DIRECTION)
            this.cube.put(s, makeRandomColorPlane());
    }

    private String[][] makeNormalColorArray(String color) {
        String[][] colorPlane = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colorPlane[i][j] = color;
            }
        }
        return colorPlane;
    }

    private String[][] makeRandomColorPlane() {
        ArrayList<String> randomArray = new ArrayList<>();
        for (String s : COLOR) {
            for (int j = 0; j < SIZE * SIZE; j++) {
                randomArray.add(s);
            }
        }
        Collections.shuffle(randomArray);
        return makeRandomColorArray(randomArray);
    }

    private String[][] makeRandomColorArray(ArrayList<String> randomArray) {
        String[][] colorPlane = new String[SIZE][SIZE];
        for (int i = 0; i < DIRECTION.length; i++) {
            for (int j = 0; j < SIZE * SIZE; j++) {
                colorPlane[j / SIZE][j % SIZE] = randomArray.get(j + (SIZE * SIZE * i));
            }
        }
        return colorPlane;
    }

    public HashMap<String, String[][]> getCube() {
        return this.cube;
    }
}

