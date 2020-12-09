public class CubeMove {
    private String[][] cubePlane;

    public CubeMove(String[][] cubePlane, String command) {
        this.cubePlane = cubePlane;
        init(command);
    }

    private void init(String command) {
        switch (command) {
            case "U":
                moveRight(0);
            case "U`":
                moveLeft(0);
            case "R":
                moveUp(2);
            case "R`":
                moveDown(2);
            case "L":
                moveDown(0);
            case "L'":
                moveUp(0);
            case "B":
                moveLeft(2);
            case "B`":
                moveRight(2);
        }
    }

    private void moveUp(int index) {

    }

    private void moveDown(int index) {

    }

    private void moveRight(int index) {

    }

    private void moveLeft(int index) {

    }

    public String[][] getCubePlane() {
        return this.cubePlane;
    }
}
