package ex01_ten_quiz;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.UUID;

public class MainAnswer {

  public static void method1() {
    
    // 문제1. 새로운 파일명 만들기
    // 기존 파일의 확장자만 그대로 사용하고 파일명은 아래 형식을 참고해서 새로 만드세요.
    // 형식 : 하이픈이 제거된 UUID + 밑줄 + 타임스탬프.확장자
    
    String fileName = "apple.jpg";
    String extName = fileName.substring(fileName.lastIndexOf("."));  //-- 마지막 점(.)부터 끝까지 추출 (.jpg)
    StringBuilder builder = new StringBuilder();
    builder.append(UUID.randomUUID().toString().replace("-", ""));  //--- 하이픈이 제거된 UUID
    builder.append("_");  //--------------------------------------------- 밑줄
    builder.append(System.currentTimeMillis());  //---------------------- 타임스탬프
    builder.append(extName);  //----------------------------------------- .jpg
    
    System.out.println(builder.toString());
    
  }
  
  public static Map<String, Object> method2(String id) {
    
    // 문제2. 주민등록번호를 이용해 나이와 성별을 구하고 이를 Map으로 반환하세요.
    // 나이 : 현재년도 - 태어난년도
    //        하이픈 뒤의 숫자가 1,2이면 1900년대생, 3,4이면 2000년대생입니다.
    // 성별 : 하이픈 뒤의 숫자가 1,3이면 "남", 2,4이면 "여"입니다.
    
    // 현재년도
    int nowYear = LocalDate.now().getYear();
    
    // 태어난년도
    int birthYear = 0;  // 아래 코드에서 계산함
    
    // 하이픈 뒤의 숫자
    int afterHyphen = Integer.parseInt(id.substring(7, 8));
    
    switch(afterHyphen) {
    case 1:
    case 2:
      birthYear = 1900 + Integer.parseInt(id.substring(0, 2));
      break;
    case 3:
    case 4:
      birthYear = 2000 + Integer.parseInt(id.substring(0, 2));
      break;
    }
    
    String[] genders = {"여자", "남자"};
    
    return Map.of("age", nowYear - birthYear
                , "gender", genders[afterHyphen % 2]);
    
  }

  public static void method3() {
    
    // 문제3. 각 나라별 수도를 Map으로 저장해 두고, 아래와 같이 동작하도록 구현하세요.
    // 실행 예시)
    // 프랑스 수도는? >>> 
    // 파리
    // 스위스 수도는? >>> 
    // 베른
    // 영국 수도는? >>> 
    // 런던
    // 독일 수도는? >>> 
    // 베를린
    // 이탈리아 수도는? >>> 
    // 로마
    // 5개 정답 성공
    
     Map<String, String> map = Map.of("프랑스", "파리"
                                   , "독일", "베를린"
                                   , "이탈리아", "로마"
                                   , "스위스", "베른"
                                   , "영국", "런던");
     
     Scanner sc = new Scanner(System.in);
     int count = 0;
     for(Entry<String, String> entry : map.entrySet()) {
       System.out.println(entry.getKey() + " 수도는? >>>");
       String capital = sc.next();
       if(capital.trim().equals(entry.getValue())) {
         count++;
       }
     }
     System.out.println(count + "개 정답 성공");
     sc.close();
     
  }
  
  public static void method4() {

    // 문제4. 현재 통장 잔고(balance)가 5000원입니다. 랜덤하게 출금하여 잔고를 0으로 만들고 그 과정을 출력하세요.
    // 실행예시)
    // 출금 전 5000원, 1회 출금액 2917원, 출금 후 2083원
    // 출금 전 2083원, 2회 출금액 1961원, 출금 후 122원
    // 출금 전 122원, 3회 출금액 102원, 출금 후 20원
    // 출금 전 20원, 4회 출금액 2원, 출금 후 18원
    // 출금 전 18원, 5회 출금액 17원, 출금 후 1원
    // 출금 전 1원, 6회 출금액 1원, 출금 후 0원
  
    int balance = 5000;
    int count = 0;
    while(balance > 0) {
      int money = (int)(Math.random() * balance + 1);  //-- 출금액(money) : 1 <= 출금액 <= balance
      count++;  //----------------------------------------- 출금 횟수
      System.out.println("출금 전 " + balance + "원, " + count + "회 출금액 " + money + "원, 출금 후 " + (balance -= money) + "원");
    }
    
  }
  
  public static void method5() {

    // 문제5. 윷놀이를 진행하세요. "윷"이나 "모"가 나오면 계속 던져야 합니다.
    // 실행예시1) "도", 1칸 이동한다.
    // 실행예시2) "개", 2칸 이동한다.
    // 실행예시3) "걸", 3칸 이동한다.
    // 실행예시4) "윷", "도", 5칸 이동한다.
    // 실행예시5) "모", "윷", "도", 10칸 이동한다.
    
    String[] yuts = {"", "도", "개", "걸", "윷", "모"};  // 인덱스가 각 요소별 이동 횟수와 일치하도록 구성 ("도"의 인덱스는 1, "개"의 인덱스는 2, ...)
    
    StringBuilder builder = new StringBuilder();
    int move = 0;
    int totalMove = 0;
    do {
      move = (int)(Math.random() * 5 + 1);  //-- 윷 던지는 코드 : (1 ~ 5) 사이 랜덤 넘버 생성
      totalMove += move;  //-------------------- 나온만큼 이동
      builder.append(yuts[move]);
      builder.append(", ");
    } while(move >= 4);  //--------------------- 윷 또는 모가 나왔다면 다시 반복문 실행
    builder.append(totalMove).append("칸 이동한다.");
    
    System.out.println(builder.toString());
    
  }

  public static void method6() {
    
    // 문제6. SecureRandom을 이용해 "대문자+소문자+숫자"로 구성된 임의의 인증번호를 만드세요.
    // 실행예시1)
    //   몇 자리의 인증번호를 생성할까요? >>> 4
    //   생성된 4자리 인증번호는 7W5e입니다.
    // 실행예시2)
    //   몇 자리의 인증번호를 생성할까요? >>> 6
    //   생성된 6자리 인증번호는 FB0e3a입니다.
    
    Scanner sc = new Scanner(System.in);
    System.out.println("몇 자리의 인증번호를 생성할까요? >>> ");
    int count = sc.nextInt();
    SecureRandom secureRandom = new SecureRandom();
    StringBuilder sb = new StringBuilder();
    for(int n = 0; n < count; n++) {
      double randomNumber = secureRandom.nextDouble();  // 0.0 <= randomNumber < 1.0
      // 정수/대문자/소문자 발생 확률 : 33%/33%/34%
      if(randomNumber < 0.33) {
        sb.append(secureRandom.nextInt(10));  //---------------- 0부터 10개 값 중 랜덤 생성 (0~9)
      } else if(randomNumber < 0.66) {
        sb.append((char)(secureRandom.nextInt(26) + 'A'));  //-- 'A'부터 26개 값 중 랜덤 생성 ('A'~'Z')
      } else {
        sb.append((char)(secureRandom.nextInt(26) + 'a'));  //-- 'a'부터 26개 값 중 랜던 생성 ('a'~'z')
      }
    }
    String code = sb.toString();
    System.out.println("생성된 " + count + "자리 인증번호는 " + code + "입니다.");
    sc.close();
    
  }

  public static void method7() {

    // 문제7. UpDown 게임을 만드세요.
    // 컴퓨터가 1 ~ 10000 사이의 난수를 발생시키면 사용자가 해당 값을 맞추는 게임입니다.
    // 몇 번의 시도만에 성공하는지 결과를 출력하세요.
    // 실행예시)
    // 입력 >>> 5000
    // Down!
    // 입력 >>> 2500
    // Up!
    // ...
    // 입력 >>> 4500
    // 정답입니다. 총 5번만에 성공했습니다.
    
    Scanner sc = new Scanner(System.in);
    int goal = (int)(Math.random() * 10000) + 1;  // 1에서 10000 사이 난수 발생
    int input = 0;
    int nth = 0;
    do {
      //----- 맞추기 도전
      System.out.print("입력 >>> ");
      input = sc.nextInt();
      //----- 도전 횟수 증가
      nth++;
      //----- 맞추면 정답, 아니면 Up 또는 Down
      if(goal == input) {
        System.out.println("정답은 " + goal + "이었습니다. " + nth + "번만에 성공했습니다.");
      } else if(goal > input) {
        System.out.println("Up!");
      } else {
        System.out.println("Down!");
      }
    } while(goal != input);  // 정답을 못 맞췄으면 계속하자!
    sc.close();
    
  }

  public static void method8() {

    // 문제8. 0~9 사이 난수를 100개 발생시키고 발생한 난수들이 생성된 횟수(빈도수)를 그래프화 하여 출력하세요.
    // 실행예시)
    // 0 : #### 4
    // 1 : ############ 12
    // 2 : ############ 12
    // 3 : ##### 5
    // 4 : ######## 8
    // 5 : ########### 11
    // 6 : ############ 12
    // 7 : ################## 18
    // 8 : ####### 7
    // 9 : ########### 11

    int[] numbers = new int[100];  //----- 100개 난수
    int[] frequencies = new int[10]; //----- 각 숫자의 빈도수
    
    for(int i = 0; i < numbers.length; i++) {
      numbers[i] = (int)(Math.random() * 10);  //----- 랜덤 생성한 값(0~9)를 저장하고,
      frequencies[numbers[i]]++;  //------------------ 몇 번 생성했는지 확인하기 위해서 빈도수 배열에 체크
    }
    
    for(int i = 0; i < frequencies.length; i++) {  //----- 빈도수 배열에 저장된 값 만큼 # 그리기
      StringBuilder sb = new StringBuilder();
      for(int n = 0; n < frequencies[i]; n++) {
        sb.append("#");
      }
      String graph = sb.toString();
      System.out.println(i + " : " + graph + " " + frequencies[i]);
    }
    
  }
  
  public static void method9() {
    
    // 문제9. 5 x 5 숫자 빙고판을 만드세요. 아래 과정을 순차적으로 진행하면 됩니다.
    //
    // 지시사항)
    //   1. 가장 먼저 1 ~ 25 사이 정수를 2차원 배열 bingo에 아래와 같이 순서대로 넣습니다.
    //      1  2  3  4  5
    //      6  7  8  9 10
    //     11 12 13 14 15
    //     16 17 18 19 20
    //     21 22 23 24 25
    //   2. 첫 번째 요소([0][0])부터 마지막 요소([4][4])까지 순회하면서 임의의 요소와 값을 교환합니다.
    //      -----------------------------
    //      순차적으로        랜덤하게
    //      모든요소접근      접근
    //      -----------------------------
    //      bingo[0][0]  <->  bingo[1][4]
    //      bingo[0][1]  <->  bingo[0][2]
    //      bingo[0][2]  <->  bingo[2][1]
    //      ...
    //      bingo[4][4]  <->  bingo[3][1]
    //      -----------------------------
    //
    // 실행예시)
    //  10  9  4 25  2
    //  15  3 13 21  1
    //  14 20 11 19  6
    //   8 17  5 12  7
    //  16 22 18 24 23

    //----- 빙고 크기
    final int SIZE = 5;
    
    //----- 빙고판 생성 (모두 0 채워진 상태)
    int[][] bingo = new int[SIZE][SIZE];
    
    //----- 1 ~ 25 값으로 순서대로 빙고판 초기화
    for(int i = 0; i < SIZE; i++) {
      for(int j = 0; j < SIZE; j++) {
        bingo[i][j] = (i * SIZE) + (j + 1);
      }
    }
    
    //----- 셔플(임의로 섞기)
    for(int i = 0; i < SIZE; i++) {
      for(int j = 0; j < SIZE; j++) {
        // bingo[i][j]와 bingo[x][y]의 교환
        int x = (int)(Math.random() * SIZE);
        int y = (int)(Math.random() * SIZE);
        int temp;
        temp = bingo[i][j];
        bingo[i][j] = bingo[x][y];
        bingo[x][y] = temp;
      }
    }
    //----- 빙고판 출력
    for(int i = 0; i < SIZE; i++) {
      for(int j = 0; j < SIZE; j++) {
        System.out.print(String.format("%3d", bingo[i][j]));
      }
      System.out.println();
    }
    
  }
  
  public static void method10() {
    
    // 문제10. 야구 게임(숫자 맞추기 게임)
    // 시스템이 4자리의 서로 다른 수를 저장하면 사용자가 저장된 수를 모두 맞추는 게임입니다.
    // 자리수가 맞으면 "스트라이크"
    // 자리수는 틀리지만 존재하는 수이면 "볼"
    // "4 스트라이크"가 게임 종료

    // NumberInputException을 이용하여 다음의 예외 처리를 하세요.
    // NumberInputException 클래스는 직접 만들어야 합니다.
    //  - 입력이 4자리 수가 아닌 경우는 "4자리 숫자를 입력하세요."를 출력하고 다시 입력받으세요.
    //  - 중복된 숫자가 입력된 경우 "중복된 숫자가 입력되었습니다."를 출력하고 다시 입력받으세요.
    //  - InputMismetchException을 이용해 숫자 아닌 값이 입력되면 "숫자만 가능합니다."를 출력하고 다시 입력받으세요.
    //  - 숫자 체크를 위한 numberCheck() 메소드를 제공합니다. 이를 사용해서 처리하세요.
    
    // 실행 예시)
    // 서로 다른 4자리 정수를 입력하세요 >>> 1234
    // 1234 : 0스트라이크, 1볼
    // 서로 다른 4자리 정수를 입력하세요 >>> 5678
    // 5678 : 2스트라이크, 0볼
    // 서로 다른 4자리 정수를 입력하세요 >>> 2679
    // 2679 정답입니다.
    // 3번 만에 맞추셨습니다. 게임을 종료합니다.
    
    //----- {'0', '1', '2', ... '9'} 배열 생성하기 
    char numbers[] = "0123456789".toCharArray();
    
    //----- 랜덤 값 4개를 저장할 배열 (아직 값 없음)
    char answer[] = new char[4];
    
    //----- 1000번(충분히 많이) 각 요소 임의로 섞기(Shuffle)
    //      완료 시 {'8', '0', '3', ... '2'} 처럼 순서를 알 수 없는 배열이 생성
    for (int i = 0; i < 1000; i++) {
      int a = (int) (Math.random() * numbers.length);
      int b = (int) (Math.random() * numbers.length);
      char temp = numbers[a];
      numbers[a] = numbers[b];
      numbers[b] = temp;
    }
    
    // 임의로 섞인 배열의 첫 4개 요소만 랜덤 값 4개로 선정
    for (int i = 0; i < 4; i++) {
      answer[i] = numbers[i];
    }
    
    // 생성된 난수 확인. 실제 코드에서는 제외합니다.
    for (char a : answer) {
      System.out.print(a);
    }
    
    System.out.println();
    
    Scanner sc = new Scanner(System.in);
    char[] user = new char[4];
    int cnt = 0;  // 몇 번째 입력인가?
    while (true) {
      System.out.print("서로 다른 4자리 정수를 입력하세요 >>> ");
      String num = null;
      try {
        
        //----- 우선 문자열로 입력 받음 (InputMismatchException 예외 발생 안함)
        num = sc.next();
        
        //----- 입력 받았으니 횟수 증가
        cnt++;
        
        //----- 입력값 검증
        numberCheck(num);
        
        // 문자열로 입력된 값을 char[] 배열로 변환
        user = num.toCharArray();
        
        // 스트라이크, 볼 결정
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < answer.length; i++) {
          for (int j = 0; j < user.length; j++) {
            if (answer[i] == user[j]) {  //----- 일단 같은 값이 있다.
              if (i == j)  //------------------- 위치까지 같으니 스트라이크
                strike++;
              else  //-------------------------- 위치는 다르니 볼
                ball++;
              break;
            }
          }
        }
        
        // 입력 후 스트라이크/볼 점검 결과 확인
        if (strike == 4) {
          System.out.println(num + "정답입니다.");
          System.out.println(cnt + "번 만에 맞추셨습니다. 게임을 종료합니다.");
          break;
        } else {
          System.out.println(num + ":" + strike + "스트라이크, " + ball + "볼");
        }
      } catch (InputMismatchException e) {
        System.out.println("숫자만 가능합니다");
      } catch (NumberInputException e) {
        System.out.println(e.getMessage());
      }
    }
    
  }
  
  private static void numberCheck(String str) throws NumberInputException {
    if (str.length() != 4) {
      throw new NumberInputException("4자리 숫자를 입력하세요");
    }
    try {
      Integer.parseInt(str);
    } catch (NumberFormatException e) {
      throw new InputMismatchException("숫자만 가능합니다");
    }   
    int[] cnt = new int[10];
    for(char c : str.toCharArray()) {
      cnt[c-'0']++;  // char c에 저장된 문자 형식의 아라비아 숫자(예: '0')를 숫자 형식(예: 0)으로 변경하기 위해서 '0'을 뺍니다.
      if (cnt[c-'0'] > 1)
        throw new NumberInputException("중복된 숫자가 입력되었습니다.");
    }
  }
  
  public static void main(String[] args) {
    
    // method1(); ~ method10(); 그냥 호출하면 됩니다.
    
    // method2(); 주민등록번호를 전달해서 실행합니다.
    Map<String, Object> map = method2("140101-4123456");
    for(Entry<String, Object> entry : map.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }

  }
  
}