import java.util.HashMap;

public class OutputCube {
    private final String[] DIRECTION = {"top", "front", "right", "left", "back", "bottom"};
    private final HashMap<String, String[][]> cube;
    private final String s = "";

    public OutputCube(HashMap<String, String[][]> cube) {
        this.cube = cube;
    }

    private void printTopBottomArray(String[][] array){
        for (String[] strings : array) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void printFrontRightLeftBackArray(){
        System.out.printf("%3s",s);

    }

    public void printCube(){
        System.out.printf("%6s",s);
        printTopBottomArray(cube.get("top"));
    }

}