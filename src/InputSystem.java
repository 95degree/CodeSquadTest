import java.util.Scanner;

public class InputSystem {
    Scanner scan;

    public InputSystem() {
        scan = new Scanner(System.in);
        while (true) {
            init();
            System.out.println("\n종료하시겠습니까 1.Yes 2.No");
            if (scan.nextInt()==1)
                break;
        }
        scan.close();
    }

    private void init() {
        System.out.print("> ");
        String word = scan.next();
        int count = scan.nextInt();
        String direction = scan.next();
        WordMove wordMove = new WordMove(word, count, direction);
    }
}
