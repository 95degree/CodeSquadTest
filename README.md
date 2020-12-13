# Step-3(루빅스 큐브 구현하기)

#구현  
큐브는 W, B, G, Y, O, R의 6가지 색깔을 가지고 있다.  
입력: 각 조작법을 한 줄로 입력받는다.  
출력: 큐브의 6면을 펼친 상태로 출력한다.  
Q를 입력받으면 프로그램을 종료하고, 조작 받은 명령의 갯수를 출력시킨다.  

## Main 클래스

CubeMain 클래스를 호출하고 init()함수를 호출합니다.

## CubeMain 클래스

전체적인 루빅스 큐브의 구동을 담당하고 있습니다.



public void init() : 1.기본 큐브와 2.랜덤 큐브로 시작할 것인지 출력을 하고 콘솔로 입력을 받습니다.

입력을 받을 때는 CommandInput 클래스를 생성해서 생성자에서 실행됩니다. CubePlane 클래스에 인자로 입력한 숫자로 넣어주고 OutputCube클래스에 printCube 함수에 인자로 보내서 호출하고 경과 시간을 재기 위한 start = System.currentTimeMillis(); 를 실행합니다. loof()함수에 CubePlane 클래스의 인스턴스를 인자로 넣어줍니다. 그리고 loof()가 끝나면 마무리멘트를 출력하는 printFinish() 함수를 호출합니다.

1. private void loof(CubePlane cube) : 커맨드를 받고 q면 return으로 무한루프문을 종료시키고 아니면 커맨드를 CommandSplit 클래스의 splitCommand 함수에 넣어 String 배열 command를 만들어주고 moveCube() 함수에 인자로 command, CubeMove 인스턴스 클래스, Cubeplane의 인스턴스 클래스를 넣어줍니다.
2. private void moveCube(String[] command, CubeMove move, CubePlane cube) :  command를 받아 각 커맨드에 맞는 움직일 인덱스 값을 넣어주고 움직인 큐브를 출력해준 후 count를 해줍니다.
3. private void printFinish() : long finish = System.currentTimeMillis()로 끝나는 시간을 받아 경과 시간을 구한 후 경과시간과 움직인 횟수 마무리 멘트를 출력합니다.

## CommandInput 클래스

생성자에서 Cube>를 출력하고 Scanner를 통해 콘솔로 입력받습니다.

1. public String getCommand() : 입력 받은 문자열 command를 getter로 만들었습니다.

## CommandSplit 클래스

1. public String[] splitCommand(String command) : 리턴 값으로 매개변수 command를 String 배열로 만든 것을 보내줍니다.

## CubeMove 클래스(전개도를 바탕으로 구현 )
움직이고 출력도 되지만 코드 실수로 인해 사이트와 똑같이 움직이지는 않습니다.

1. public void moveCube(String command, HashMap<String, String[][]> cube, int num) : 쪼개진 command의 문자 하나와 해쉬맵으로 만든 각 방향의 큐브 면, 움직일 index값을 매개변수로 받아 각 커맨드에 맞게 보내줍니다.
2. private void moveCommandFAndB(int num) : 커맨드 F와 B의 큐브 움직임을 담당합니다. 우선 top면의 첫번째 행을 저장하고  그 행에 changeMatrix("top", "left", num)함수를 호출 해 left면의 num열의 색깔을 넣어주고 그 다음에 차례대로 위와 같은 움직임을 각 면에 맞게 해줍니다.
3. private void moveBackCommandFAndB(int num) : moveCommandFAndB의 움직임과 반대 방향으로 색깔을 바꿔줍니다.
4. private void changeMatrix(String row, String column, int num) :  면의 열의 색깔을 다른 면의 행에 넣어줍니다.
6. private void moveCommandRAndL(int num) :  커맨드 R와 L의 큐브 움직임을 담당합니다. top의 움직일 열을 저장을 하고 moveUp()함수를 호출합니다.
7. private void moveBackCommandRAndL(int num) : moveCommandRAndL의 반대방향으로 움직입니다. 따라서 moveDown()함수를 호출합니다.
8. private void moveUp(int num) : 면의 같은 열의 색깔을 위의 면으로 넣어주고 마지막의 for문 열의 위치가 다르기 때문에 따로 만들어줬습니다.
9. private void moveDown(int num) : 면의 같은 열 색깔을 아래의 면으로 넣어주고 위의 moveUp 함수 와 마찬가지로 열의 위치가 다른 면을 받는 것을 따로 만들어줬습니다.
10. private void moveCommandUAndD(int num) : 면의 같은 행의 색깔을 왼쪽으로 이동시킵니다.
11. private void moveBackCommandUAndD(int num) : 면의 같은 행의 색깔을 오른쪽으로 이동시킵니다.
12. public HashMap<String, String[][]> getCube() : 다 움직인 큐브를 해쉬맵의 형태로 return합니다.

## CubePlane 클래스

cube를 만드는것을 담당하는 클래스입니다.

생성자에서 command 매개변수를 받아 랜덤 큐브와 일반큐브를 중 하나를 만들어 줍니다.

큐브는 해쉬맵 형태로<각 방향,면>으로 만들었습니다.

1. private void makeNormalPlane() : 일반 큐브를 만드는 함수로 makeNormalColorPlane() 함수로 만들어진 면을 value, 각 방향을 key값으로 넣은 해쉬맵에 put해줍니다.

2. private void makeRandomPlane(): 랜덤 큐브를 만드는 함수로 36개(한 컬러 당 9개)의 색깔 문자를 ArrayList로 만든 후  makeRandomColorArray()함수에 넣은 후 shuffle 된 문자열을makeRandomColorPlane()에 넣어준 후 리턴을 받아 위와 같이 방향은 key값 리턴값은 value값으로 넣어줍니다.

3. private String[][] makeNormalColorPlane(String color) : 색깔을 받아 면(2차원 배열)으로 만들어 준 후 리턴해줍니다.

4. private void makeRandomColorArray(ArrayList<String> randomArray) :  매개변수 randomArray를 shuffle 함수로 위치를 뒤섞어 줍니다.

5. private String[][] makeRandomColorPlane(ArrayList<String> randomArray, int count): 매개변수 randomArray를 면으로 만드는데 하나의 면을 완성했으면 다음 인덱스부터 넣어지도록 count값을 매개변수로 넣어줬습니다.

6. public HashMap<String, String[][]> getCube() : 다 만들어진 해쉬맵 큐브의 getter입니다.

7. (구현을 다 하고 보니 큐브가 움직일 때 움직이는 면 중에서 하나의 면은 꼭 행렬이 돌아가야 한다는 것을 알게 되었습니다. 추가적으로 넣을려고 했으나 오류가 생길꺼 같아 
 CubeMove 클래스의 119~136 라인에 간단히 오른쪽으로 돌아가는 것을 구현해봤습니다.)

## OutputCube 클래스

해쉬맵으로 받은 큐브를 각 방향에 맞게 전개도 모양으로 출력해주는 클래스입니다.

1. private void printTopBottomArray(String[][] array) : top, bottom 면을 출력해주는 함수 입니다. 기본적인 2차원 배열 출력입니다.

2. private void printFrontRightLeftBackArray : front,right,left,back 면을 출력해주는 함수입니다 일렬로 출력되어야 되기 때문에 printLoop 함수를 통해  각면의 행을 출력하고 그 다음에 다음 면의 행을 출력하는 것을 반복합니다.
3. private void printLoop(String[][] direction, int num) : 출력해야 하는 행을 출력합니다. 
4. public void printCube(HashMap<String, String[][]> cube) : 위의 함수들이 필요한 출력형식으로 만들어진 함수입니다.