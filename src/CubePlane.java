public class CubePlane {

    public CubePlane() {
        String[][] plane = {
                {"R", "R", "W"},
                {"G", "C", "W"},
                {"G", "B", "B"}
        };
        init(plane);
    }

    private void init(String[][] plane) {
        printCube(plane);
        InputSystem start = new InputSystem(plane);
    }

    private void printCube(String[][] plane) {
        for (String[] strings : plane) {
            for (String string : strings) {
                System.out.println(string + "\t");
            }
            System.out.println("\n");
        }
    }
}
