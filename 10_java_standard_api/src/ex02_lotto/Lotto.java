package ex02_lotto;

import java.security.SecureRandom;
import java.util.*;

public class Lotto {

    /**
     * 로또 구매<br>
     * 로또 구매를 위해서 사용자로부터 money를 입력 받는 메소드<br>
     * 로또 구매 비용은 최소 1000, 최대 100000입니다.<br>
     *
     * @return money 실제 로또 구매 비용을 반환. 1000 미만 단위는 버리고 반환. ex) 5999 입력 시 5000 반환
     * @throws RuntimeException 정수를 입력하지 않으면 InputMismatchException 예외 발생. 부적절한 로또 구매 비용 입력 시 예외 발생.
     */
    public int buyLotto() throws RuntimeException {
        Scanner sc = new Scanner(System.in);
        int money = 0;

        while (true) {
            try {
                System.out.print("얼마를 구매하시겠습니까? >>> ");
                money = sc.nextInt();
                if (money > 100000) {
                    throw new RuntimeException("최대 10만원만 구매 가능");
                }
                if (money % 1000 > 0) {
                    System.out.println("잔돈 " + money % 1000 + "원은 반환됩니다.");
                }
                sc.close();
                return money - money % 1000;

            } catch (InputMismatchException e) {
                System.out.println("정수를 입력해주세요");
                sc.nextLine();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

        }



    }

    /**
     * 로또 번호 생성<br>
     * 로또 구매 비용만큼 로또 번호를 자동 생성하는 메소드<br>
     * 생성된 로또 번호를 List<String> papers에 저장한 뒤 이를 반환합니다.<br>
     *
     * @param money 로또 구매 비용
     * @return paper 로또 구매 내역
     */
    public List<String> generateLotto(int money) {

        /*
         * 예시) 5000원 구매 (종이1장, 5게임)
         *
         * Lotto를 얼마나 구입하시겠습니까?(최대 10만원) >>> 5000
         *
         * 01 :   19  21   6  41  42  44
         * 02 :    1   2  22  24   8  30
         * 03 :   32  36  21  25  27  12
         * 04 :   17  19  38  25  10  26
         * 05 :   33  36   4   8  11  45
         */
        /*
         * 예시) 10000원 구매 (종이2장, 10게임)
         *
         * Lotto를 얼마나 구입하시겠습니까?(최대 10만원) >>> 10000
         *
         * 01 :   19  21   6  41  42  44
         * 02 :    1   2  22  24   8  30
         * 03 :   32  36  21  25  27  12
         * 04 :   17  19  38  25  10  26
         * 05 :   33  36   4   8  11  45
         *
         * 01 :    1  36   4  23  27  14
         * 02 :    2   4  25  10  43  13
         * 03 :   34   4  22   8  10  12
         * 04 :   16  21  27  44  45  31
         * 05 :   16  20  23  24   9  44
         */

        List<String> papers = new ArrayList<>();
        Set<Integer> randomNumbers = new HashSet<>();

        int lottoSize = money / 1000;
        int cnt = 1;

        while (lottoSize > 0) {
            lottoSize--;

            while (randomNumbers.size() < 6) {
                randomNumbers.add((int) (Math.random() * 45 + 1));
            }
            Integer[] array = randomNumbers.toArray(new Integer[6]);

            papers.add(String.format("%02d :%4d%4d%4d%4d%4d%4d", cnt++, array[0], array[1], array[2], array[3], array[4], array[5]));
            randomNumbers.clear();
            if (cnt == 6) {
                cnt = 1;
                papers.add("");
            }
        }


        return papers;

    }

}