public class CubePlane {

    public CubePlane() {
        String[][] plane = {
                {"R", "R", "W"},
                {"G", "C", "W"},
                {"G", "B", "B"}
        };
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
