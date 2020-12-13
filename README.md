# step-2

##초기 상태
R R W  
G C W  
G B B 
## 동작
> U  가장 윗줄을 왼쪽으로 한 칸 밀기 RRW -> RWR  
> U' 가장 윗줄을 오른쪽으로 한 칸 밀기 RRW -> WRR  
> R  가장 오른쪽 줄을 위로 한 칸 밀기 WWB -> WBW  
> R' 가장 오른쪽 줄을 아래로 한 칸 밀기 WWB -> BWW  
> L  가장 왼쪽 줄을 아래로 한 칸 밀기 RGG -> GRG (L의 경우 R과 방향이 반대임을 주의한다.)  
> L' 가장 왼쪽 줄을 위로 한 칸 밀기 RGG -> GGR  
> B  가장 아랫줄을 오른쪽으로 한 칸 밀기 GBB -> BGB (B의 경우도 U와 방향이 반대임을 주의한다.)  
> B' 가장 아랫줄을 왼쪽으로 한 칸 밀기 GBB -> BBG  
> Q  Bye~를 출력하고 프로그램을 종료한다.
 
## CubeMain 클래스

InputOutputSystem 클래스를 생성합니다.

## InputOutputSystem 클래스

생성자에서 면을 초기화 시킨 후 printCube() 함수에 인자로 보내 콘솔 창에출력하고 init()함수로 넘어갑니다.

1. private void init() : scan이라는 Scanner 변수를 만들고 무한 루프문을 돌립니다. 무한 루프문에는 CUBE>를 출력해주고 command를 String으로 받고  command를 splitCommand()함수의 인자로 보내줍니다. command에 q가 들어오면 무한 루프문이 중지 되고 Bye~가 출력됩니다. 
2. private void splitCommand(String command) : 매개변수 command를 split으로 나누어 주고 String 배열 commandArray를 만들어줍니다.    만약 " ' " 이 포함되어있으면 " ' " 앞에 있는 문자의 인덱스에 문자+" ' "를 넣어 줍니다.  그리고 commandArray 길이 만큼 inputCommandToMove() 함수에 commandArray의 각 단어를 넣어주고 실행합니다.
3. private void inputCommandToMove(String splitedCommand) : 매개변수 splitCommand 안에      " ' " 가 아니면 CubeMove 클래스에 인자로 넣어줍니다. 그리고 움직인 큐브를 CubeMove 클래스의  getCubePlane 함수로 받고 splitedCommand를 출력하고 printCube()에 인자로 넣어줍니다.
4. private void printCube(String [] [] plane) : 매개변수 plane을 콘솔 창에 출력합니다.

## CubeMove 클래스

매개변수로 String [] [] cubePlane, String command 를 받습니다.

생성자에서 cubePlane을 받고 init함수의 인자로 command를 넘겨줍니다.

private void init(String command) : 쪼개진 문자열인 command를 받아 각 command에 맞는 함수로 swtich로 넘겨줍니다.



기본적으로 큐브를 움직이는 함수들은 움직이기전에 첫번째로 움직일 값을 저장을 하고 각 방향에 맞게 한칸씩 움직여 준 후 마지막에 움직인 인덱스에 저장된 값을 넣어주는 형태입니다. Step-1의 움직이는 방식과 같습니다.

2. private void moveUp(int index)  

3. private void moveDown(int index)

4. private void moveRight(int index)

5. private void moveLeft(int index)

6. public String[][] getCubePlane() : 움직인 큐브의 값을 getter로 만들어 줬습니다.