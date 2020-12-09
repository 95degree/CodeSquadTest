import java.util.Scanner;

public class InputSystem {
    Scanner scan;
    private String[][] cubePlane;

    public InputSystem(String[][] cubePlane) {
        this.cubePlane = cubePlane;
        init();
    }

    private void init() {
        scan = new Scanner(System.in);
        String command = "";
        while (!command.equalsIgnoreCase("q")) {
            System.out.print("CUBE >");
            command = scan.next();
            String[] commandArray = command.split("");
            CubeMove move = new CubeMove(this.cubePlane,commandArray);
        }
        System.out.println("Bye~");
    }
}
