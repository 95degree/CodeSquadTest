public class WordMove {
    char[] wordArray;

    public WordMove(String inputArray) {
        String[] splitArray = inputArray.split(" ");
        String word = splitArray[0];
        int count = Integer.parseInt(splitArray[1]);
        String direction = splitArray[2];
        init(word, count, direction);
    }

    private void init(String word, int count, String direction) {
        MakeWordArray(word);
    }

    private void MakeWordArray(String word){
        for(int i=0; i< word.length(); i++){
            this.wordArray[i]=word.charAt(i);
        }
    }

}
