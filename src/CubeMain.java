public class CubeMain {

    public void init(){
        System.out.println("1:기본 큐브, 2:랜덤 큐브");
        CommandInput input = new CommandInput();
        OutputCube print = new OutputCube();
        CubePlane cube = new CubePlane(input.getCommand());
        print.printCube(cube.getCube());
    }
}


