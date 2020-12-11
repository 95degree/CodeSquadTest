import java.util.HashMap;

public class OutputCube {
    private final HashMap<String, String[][]> cube;
    private final String s = "";

    public OutputCube(HashMap<String, String[][]> cube) {
        this.cube = cube;
    }

    private void printTopBottomArray(String[][] array) {
        for (String[] strings : array) {
            System.out.printf("%12s", s);
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    private void printFrontRightLeftBackArray(String[][] left, String[][] front, String[][] right, String[][] back) {
        System.out.println();
        for (int i = 0; i < left.length; i++) {
            printLoop(left, i);
            printLoop(front, i);
            printLoop(right, i);
            printLoop(back, i);
            System.out.println();
        }
        System.out.println();
    }

    private void printLoop(String[][] direction, int num) {
        for (int i = 0; i < direction.length; i++) {
            System.out.print(direction[num][i] + " ");
        }
        System.out.printf("%2s", s);
    }

    public void printCube() {
        printTopBottomArray(cube.get("top"));
        printFrontRightLeftBackArray(cube.get("left"), cube.get("front"), cube.get("right"), cube.get("back"));
        printTopBottomArray(cube.get("bottom"));
    }

}