public class CubeMove {
    private String[][] cubePlane;

    public CubeMove(String[][] cubePlane, String[] command) {
        this.cubePlane = cubePlane;
        init(command);
    }

    private void init(String[]command){
        for (String s : command) move(s);
    }

    private void move(String command){
    }

    private void moveUp(){

    }

    private void moveDown(){

    }

    private void moveRight(){

    }

    private void moveLeft(){

    }

    public String[][] getCubePlane(){
        return this.cubePlane;
    }
}
