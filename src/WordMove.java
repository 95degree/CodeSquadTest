public class WordMove {
    private char[] wordArray;
    private String direction;

    public WordMove(String word, int count, String direction) {
        this.direction = direction.toUpperCase();
        init(word, count);
        print();
    }

    private void init(String word, int count) {
        if (count < 0) this.direction = changeDirection();
        MakeWordArray(word);
    }

    private void MakeWordArray(String word) {
        for (int i = 0; i < word.length(); i++) {
            this.wordArray[i] = word.charAt(i);
        }
    }

    private String changeDirection() {
        if (this.direction.equals("L"))
            return "R";
        return "L";
    }

    private void print(){
        for(char a : this.wordArray)
            System.out.println(a);
    }
}
