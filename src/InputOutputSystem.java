import java.util.Scanner;

public class InputOutputSystem {
    Scanner scan;
    CubeMove move;
    final String[][] FIRSTPLANE = {
            {"R", "R", "W"},
            {"G", "C", "W"},
            {"G", "B", "B"}
    };

    public InputOutputSystem() {
        printCube(FIRSTPLANE);
        init();
    }

    private void init() {
        String[][] cubePlane = FIRSTPLANE;
        scan = new Scanner(System.in);
        String command = "";
        while (!command.equalsIgnoreCase("q")) {
            System.out.print("CUBE >");
            command = scan.nextLine();
            splitCommand(command);
        }
        System.out.println("Bye~");
    }

    private String[] splitCommand(String command) {
        String[] commandArray = command.split("");
        for (int i = 1; i < commandArray.length; i++) {
            if (commandArray[i].equals("`"))
                commandArray[i - 1] += commandArray[i];
        }
        return commandArray;
    }

    public void printCube(String[][] plane) {
        for (String[] strings : plane) {
            for (String string : strings) {
                System.out.println(string + "\t");
            }
            System.out.println("\n");
        }
    }
}
