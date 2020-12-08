public class WordMove {
    private final String[] wordArray;
    private String direction;
    private final int length;

    public WordMove(String word, int count, String direction) {
        this.wordArray = word.split("");
        this.direction = direction.toUpperCase();
        this.length = word.length();
        init(word, count);
        print();
    }

    private void init(String word, int count) {
        if (count < 0) this.direction = changeDirection();
        MoveWordArray(Math.abs(count));
    }

    private String changeDirection() {
        if (this.direction.equals("L"))
            return "R";
        return "L";
    }

    private void MoveWordArray(int count) {
        switch (this.direction) {

            case "R":
                MoveRight(count);
                break;

            case "L":
                MoveLeft(count);
                break;
        }
    }

    private void MoveRight(int count) {
        String save;
        for (int i = 0; i < count; i++) {
            save = this.wordArray[this.length-1];
            for (int j = this.length-1; j >0; j--)
                this.wordArray[j] = this.wordArray[j - 1];
            this.wordArray[0] = save;
        }
    }

    private void MoveLeft(int count) {
        String save;
        for (int i = 0; i < count; i++) {
            save = this.wordArray[0];
            for (int j = 0; j < this.length - 1; j++)
                this.wordArray[j] = this.wordArray[j + 1];
            this.wordArray[this.length - 1] = save;
        }

    }

    private void print() {
        for (String a : this.wordArray)
            System.out.print(a);
    }
}
