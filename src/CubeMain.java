public class CubeMain {

    public void init(){
        System.out.println("1:기본 큐브, 2:랜덤 큐브");
        CommandInput input = new CommandInput();
        CubePlane cube = new CubePlane(input.getCommand());
        OutputCube print = new OutputCube();
        print.printCube(cube.getCube());
    }
}


