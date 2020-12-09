import java.util.Scanner;

public class InputOutputSystem {
    Scanner scan;
    CubeMove move;
    private String[][] plane;
    final String[][] STARTPLANE = {
            {"R", "R", "W"},
            {"G", "C", "W"},
            {"G", "B", "B"}
    };

    public InputOutputSystem() {
        printCube(STARTPLANE);
        init();
    }

    private void init() {
        String[][] cubePlane = STARTPLANE;
        scan = new Scanner(System.in);
        String command = "";
        while (!command.equalsIgnoreCase("q")) {
            System.out.print("CUBE >");
            command = scan.nextLine();
            splitCommand(command);
        }
        System.out.println("Bye~");
    }

    private void splitCommand(String command) {
        String[] commandArray = command.split("");
        for (int i = 1; i < commandArray.length; i++) {
            if (commandArray[i].equals("`")) {
                commandArray[i - 1] += commandArray[i];
            }
            inputCommandToMove(commandArray[i - 1]);
        }
    }
    
    private void inputCommandToMove(String splitCommand) {
        move = new CubeMove(this.plane, splitCommand);
        System.out.println(splitCommand);
        printCube(move.getCubePlane());
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
