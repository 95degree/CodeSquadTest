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
        this.plane = STARTPLANE;
        printCube(STARTPLANE);
        init();
    }

    private void init() {
        scan = new Scanner(System.in);
        String command;
        while (true) {
            System.out.print("CUBE >");
            command = scan.nextLine();
            if (command.equalsIgnoreCase("q"))
                break;
            splitCommand(command);
        }
        System.out.println("Bye~");
    }

    private void splitCommand(String command) {
        String[] commandArray = command.split("");
        for (int i = 1; i < commandArray.length; i++) {
            if (commandArray[i].equals("'")) {
                commandArray[i - 1] += commandArray[i];
            }
        }
        for (String s : commandArray) inputCommandToMove(s);
    }

    private void inputCommandToMove(String splitedCommand) {
        if (!splitedCommand.equals("'")) {
            move = new CubeMove(this.plane, splitedCommand);
            this.plane = move.getCubePlane();
            System.out.println(splitedCommand);
            printCube(this.plane);
        }
    }

    private void printCube(String[][] plane) {
        for (String[] strings : plane) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
