import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("> ");
        String word = input.next();
        int count = input.nextInt();
        String direction = input.next();
        WordMove wordMove = new WordMove(word, count, direction);
    }
}
