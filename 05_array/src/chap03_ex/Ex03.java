package chap03_ex;

import java.util.Arrays;

public class Ex03 {

  public static void main(String[] args) {
    
    // 다음 배열의 길이를 4로 늘려서 "autumn", "winter"를 저장하세요.
    // Tip. 배열의 길이를 늘일 수는 없으니, 길이가 4인 새로운 배열을 만들고,
    //      기존 배열의 요소를 새로운 배열로 모두 복사한 뒤, 
    //      기존 배열의 참조를 새로운 배열의 참조로 바꿉니다.
    
    String[] seasons = {"spring", "summer"};
    int length = seasons.length;

    String[] newSeasons = new String[length + 2];
    for (int i = 0; i < length; i++) {
      newSeasons[i] = seasons[i];
    }

    newSeasons[length] = "autumn";
    newSeasons[length + 1] = "winter";
    seasons = newSeasons;
    System.out.println( "seasons = " + Arrays.toString(seasons));

        
  }
  
}
