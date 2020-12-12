public class CommandSplit {

    public String[] splitCommand(String command){
        String[] commandArray = command.split("");
        for (int i = 1; i < commandArray.length; i++) {
            if (commandArray[i].equals("'")) {
                commandArray[i - 1] += commandArray[i];
            }
        }
        return commandArray;
    }
}
