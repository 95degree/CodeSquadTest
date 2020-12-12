import java.util.HashMap;

public class CubeMain {

    private int count;
    long start;
    OutputCube print = new OutputCube();
    CommandSplit commandSplit = new CommandSplit();

    public void init() {
        System.out.println("1:기본 큐브, 2:랜덤 큐브");
        CommandInput input = new CommandInput();
        CubePlane cube = new CubePlane(input.getCommand());
        print.printCube(cube.getCube());
        start = System.currentTimeMillis();
        loof(cube);
        printFinish();
    }

    private void loof(CubePlane cube) {
        CubeMove move = new CubeMove();
        while (true) {
            CommandInput input = new CommandInput();
            if (input.getCommand().equalsIgnoreCase("q"))
                return;
            String[] command = commandSplit.splitCommand(input.getCommand());
            moveCube(command, move, cube);
        }
    }

    private void moveCube(String[] command, CubeMove move, CubePlane cube) {
        HashMap<String, String[][]> movedCube = cube.getCube();
        for (String s : command) {
            if (s.contains("F") || s.contains("R") || s.contains("D"))
                move.moveCube(s, movedCube, 2);
            if (s.contains("B") || s.contains("L") || s.contains("U"))
                move.moveCube(s, movedCube, 0);
            if(s.equals("'")) continue;
            System.out.println(s);
            print.printCube(move.getCube());
            System.out.println();
            count++;
        }
    }

    private void printFinish(){
        long finish = System.currentTimeMillis();
        long time = (finish-start)/1000;
        System.out.println("경과 시간 : "+time/60+":"+time%60);
        System.out.println("조작 갯수 : "+count);
        System.out.println("이용해 주셔서 감사합니다.");
    }
}


