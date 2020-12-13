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

        changeMatrix("top", "left", num);

        for (int i = 0; i < cube.get("top").length; i++)
            cube.get("left")[i][num] = cube.get("bottom")[2 - num][i];

        changeMatrix("bottom", "right", 2 - num);

        for (int i = 0; i < cube.get("right").length; i++)
            cube.get("right")[i][2-num] = save[i];
    }

    private void moveBackCommandFAndB(int num) {
        save = cube.get("top")[num];

        changeMatrix("top", "right", num);

        for (int i = 0; i < cube.get("right").length; i++)
            cube.get("right")[i][2 - num] = cube.get("bottom")[num][i];

        changeMatrix("bottom", "left", 2-num);

        for (int i = 0; i < cube.get("left").length; i++)
            cube.get("left")[i][num] = save[i];
    }

    private void changeMatrix(String row, String column, int num) {
        String[] rotateSave = new String[cube.get(row).length];
        for (int i = 0; i < cube.get(row).length; i++)
            rotateSave[i] = cube.get(column)[2-i][num];
        cube.get(row)[num] = rotateSave;
    }

    private void moveCommandRAndL(int num) {
        for (int i = 0; i < cube.get("top").length; i++)
            save[i] = cube.get("top")[num][i];
        moveUp(num);
    }

    private void moveBackCommandRAndL(int num) {
        for (int i = 0; i < cube.get("back").length; i++)
            save[i] = cube.get("back")[i][2-num];
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
            cube.get(stringForMove[i])[0][num] = cube.get(stringForMove[i + 1])[0][num];
            cube.get(stringForMove[i])[1][num] = cube.get(stringForMove[i + 1])[1][num];
            cube.get(stringForMove[i])[2][num] = cube.get(stringForMove[i + 1])[2][num];
        }

        for (int i = 0; i < cube.get("bottom").length; i++) {
            cube.get("bottom")[i][num] = cube.get("back")[i][2-num];
            cube.get("back")[i][2-num] = save[i];
        }
    }

    private void moveDown(int num) {
        for (int i = 0; i < 2; i++) {
            cube.get(stringForMove[i + 1])[0][num] = cube.get(stringForMove[i])[0][num];
            cube.get(stringForMove[i + 1])[1][num] = cube.get(stringForMove[i])[1][num];
            cube.get(stringForMove[i + 1])[2][num] = cube.get(stringForMove[i])[2][num];
        }

        for (int i = 0; i < cube.get("back").length; i++) {
            cube.get("back")[i][num] = cube.get("bottom")[i][2-num];
            cube.get("bottom")[i][2-num] = save[i];
        }
    }

    public HashMap<String, String[][]> getCube() {
        return this.cube;
    }



    private void rotateRight(String direction) {
        String[] matrixSave = cube.get(direction)[0];

        rightRotate(direction,0);

        for (int i = 0; i < 3; i++)
            cube.get(direction)[i][0] = cube.get(direction)[2][i];

        rightRotate(direction,2);

        for (int i = 0; i < 3; i++)
            cube.get(direction)[i][2] = matrixSave[i];
    }

    private void rightRotate(String direction,int num){
            for(int i=0; i<3; i++)
                cube.get(direction)[num][i] = cube.get(direction)[i][num];
        }
}