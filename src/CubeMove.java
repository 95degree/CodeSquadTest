public class CubeMove {
    private String[][] cubePlane;

    public CubeMove(String[][] cubePlane, String command) {
        this.cubePlane = cubePlane;
        init(command);
    }

    private void init(String command) {
        switch (command) {
            case "U":
                moveLeft(0);
                break;

            case "U'":
                moveRight(0);
                break;

            case "R":
                moveUp(2);
                break;

            case "R'":
                moveDown(2);
                break;

            case "L":
                moveDown(0);
                break;

            case "L'":
                moveUp(0);
                break;

            case "B":
                moveRight(2);
                break;
            case "B'":
                moveLeft(2);
                break;
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
