import java.util.HashMap;

public class CubeMove {
    private HashMap<String, String[][]> cube;
    private String[] save = new String[3];
    private final String[] stringForMove = {"top", "front", "bottom", "back"};

    public void moveCube(String command, HashMap<String, String[][]> cube, int num) {
        this.cube = cube;
        if (command.equals("F") || command.equals("B'"))
            moveCommandFAndB(num);
        if (command.equals("F'") || command.equals("B"))
            moveBackCommandFAndB(num);
        if (command.equals("R") || command.equals("L'"))
            moveCommandRAndL(num);
        if (command.equals("R'") || command.equals("L"))
            moveBackCommandRAndL(num);
        if (command.equals("U") || command.equals("D'"))
            moveCommandUAndD(num);
        if (command.equals("U'") || command.equals("D"))
            moveBackCommandUAndD(num);
    }

    private void moveCommandFAndB(int num) {
        save = cube.get("top")[num];
        cube.get("top")[num] = cube.get("left")[num];
        cube.get("left")[num] = cube.get("bottom")[num];
        cube.get("bottom")[num] = cube.get("right")[num];
        cube.get("right")[num] = save;
    }

    private void moveBackCommandFAndB(int num) {
        save = cube.get("top")[num];
        cube.get("top")[num] = cube.get("right")[num];
        cube.get("right")[num] = cube.get("bottom")[num];
        cube.get("bottom")[num] = cube.get("left")[num];
        cube.get("left")[num] = save;
    }

    private void moveCommandRAndL(int num) {
        for (int i = 0; i < cube.get("top").length; i++)
            save[i] = cube.get("top")[num][i];
        moveUp(num);
    }

    private void moveBackCommandRAndL(int num) {
        for (int i = 0; i < cube.get("back").length; i++)
            save[i] = cube.get("back")[3 - num][i];
        moveDown(num);
    }

    private void moveCommandUAndD(int num) {
        save = cube.get("left")[num];
        cube.get("left")[num] = cube.get("front")[num];
        cube.get("front")[num] = cube.get("right")[num];
        cube.get("right")[num] = cube.get("back")[num];
        cube.get("back")[num] = save;
    }

    private void moveBackCommandUAndD(int num) {
        save = cube.get("back")[num];
        cube.get("back")[num] = cube.get("right")[num];
        cube.get("right")[num] = cube.get("front")[num];
        cube.get("front")[num] = cube.get("left")[num];
        cube.get("left")[num] = save;
    }

    private void moveUp(int num) {
        for (int i = 0; i < 2; i++) {
            cube.get(stringForMove[i])[num][0] = cube.get(stringForMove[i + 1])[num][0];
            cube.get(stringForMove[i])[num][1] = cube.get(stringForMove[i + 1])[num][1];
            cube.get(stringForMove[i])[num][2] = cube.get(stringForMove[i + 1])[num][2];
        }

        for (int i = 0; i < cube.get("bottom").length; i++) {
            cube.get("bottom")[num][i] = cube.get("back")[3 - num][i];
            cube.get("back")[3 - num][i] = save[i];
        }
    }

    private void moveDown(int num) {
        for (int i = 0; i < 2; i++) {
            cube.get(stringForMove[i + 1])[num][0] = cube.get(stringForMove[i])[num][0];
            cube.get(stringForMove[i + 1])[num][1] = cube.get(stringForMove[i])[num][1];
            cube.get(stringForMove[i + 1])[num][2] = cube.get(stringForMove[i])[num][2];
        }

        for (int i = 0; i < cube.get("back").length; i++) {
            cube.get("back")[3 - num][i] = cube.get("bottom")[num][i];
            cube.get("front")[num][i] = save[i];
        }
    }

    public HashMap<String, String[][]> getCube() {
        return this.cube;
    }
}

