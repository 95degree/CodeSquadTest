import java.util.Scanner;

public class CommandInput {
    private final String command;

    public CommandInput(){
        System.out.print("Cube>");
        Scanner scan = new Scanner(System.in);
        this.command = scan.nextLine();
    }

    public String getCommand(){
        return this.command;
    }
}
