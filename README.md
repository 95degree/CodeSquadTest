# Step-1(단어 밀어 내기)


1.입력: 사용자로부터 단어 하나, 정수 숫자 하나( -100 <= N < 100),  L 또는 R을 입력받는다. L 또는 R은 대소문자 모두 입력 가능하다.  

2.주어진 단어를 L이면 주어진 숫자 갯수만큼 왼쪽으로, R이면 오른쪽으로 밀어낸다.  

3.밀려나간 단어는 반대쪽으로 채워진다.

## main 클래스

InputSystem클래스를 생성한다.

## InputSystem 클래스



1. public InputSystem() : Scanner 생성, 무한루프문을 실행 ,루프문(종료 번호을 받으면)이 끝나면 Scanner 닫습니다.

2. private void init() :움직일 단어와 횟수 방향을 입력받고 WordMove 클래스의 인자로 넣어줍니다.  

 ## WordMove 클래스

1. public WordMove(String word, int count, String direction) : word 매개변수는 split으로 나누어 String 배열로 만들고, direction 매개변수는 모두 대문자로 변경, word의 길이를  int 변수 length에 저장하고 init(word,count)함수와 print()함수를 순서대로 실행합니다.
2. private void init(int count) : 만약 count가 마이너스이면 방향을 바꾸는 함수 changeDirection()을 실행하고 절대값으로 만들어 moveWordArray(int count)함수에 인자로 넣어줍니다.
3. private String changeDirection() : direction의 방향을 바꾸는 함수
4. private void moveWordArray(int count): count수 만큼 direction에 따라 moveRight()함수나 moveLeft()함수를 실행합니다.
5. private void moveRight() : String  배열이 된 word의 마지막 인덱스의 단어는 저장을 하고 오른쪽으로 한칸씩 이동후 0 인덱스에 저장된 단어를 넣어줍니다.
6. private void moveLeft()  : 0인덱스의 단어를 저장하고 왼쪽으로 한칸씩 이동후 마지막 인덱스에 저장된 단어를 넣어줍니다.
7. private void print() : 움직인 단어를 출력합니다. 