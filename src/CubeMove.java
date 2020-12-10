public class CubeMove {
    private final String[][] cubePlane;

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
        String save = this.cubePlane[0][index];
        this.cubePlane[0][index] = this.cubePlane[1][index];
        this.cubePlane[1][index] = this.cubePlane[2][index];
        this.cubePlane[2][index] = save;
    }

    private void moveDown(int index) {
        String save = this.cubePlane[2][index];
        this.cubePlane[2][index] = this.cubePlane[1][index];
        this.cubePlane[1][index] = this.cubePlane[0][index];
        this.cubePlane[0][index] = save;
    }

    private void moveRight(int index) {
        String save = this.cubePlane[index][2];
        this.cubePlane[index][2] = this.cubePlane[index][1];
        this.cubePlane[index][1] = this.cubePlane[index][0];
        this.cubePlane[index][0] = save;
    }

    private void moveLeft(int index) {
        String save = this.cubePlane[index][0];
        this.cubePlane[index][0] = this.cubePlane[index][1];
        this.cubePlane[index][1] = this.cubePlane[index][2];
        this.cubePlane[index][2] = save;
    }

    public String[][] getCubePlane() {
        return this.cubePlane;
    }
}
