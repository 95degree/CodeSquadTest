import java.util.Scanner;

public class InputSystem {
    Scanner scan;
    final String[][] FIRSTPLANE = {
            {"R", "R", "W"},
            {"G", "C", "W"},
            {"G", "B", "B"}
    };

    public InputSystem() {
        printCube(FIRSTPLANE);
        init();
    }

    private void init() {
        scan = new Scanner(System.in);
        String command = "";
        while (!command.equalsIgnoreCase("q")) {
            System.out.print("CUBE >");
            command = scan.next();
            String[] commandArray = command.split("");
            CubeMove move = new CubeMove(FIRSTPLANE, commandArray);
        }
        System.out.println("Bye~");
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
