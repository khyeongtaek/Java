package chap06_BankAccount;

public class BankAccount {
  
  private String accNo;  //----- 계좌번호
  private long balance;  //----- 잔고
  
  public BankAccount(String accNo, long balance) {
    super();
    this.accNo = accNo;
    this.balance = balance;
  }
  
  /**
   * 입금 메소드입니다. 마이너스 입금은 불가능합니다.
   * @param money 입금하려는 금액을 의미합니다.
   * @throws DepositException 마이너스 입금을 처리하는 예외입니다.
   */
  public void deposit(long money) throws DepositException {  //-- 예외 회피(위임)
    if (money < 0) {
      throw new DepositException(money + "원 입금 불가");  //----- 예외 발생
    }
    balance += money;
  }
  
  /**
   * 출금 메소드입니다. 마이너스 출금과 잔고보다 큰 금액의 출금은 불가능합니다.
   * @param money 출금하고자 하는 금액입니다. 실제 출금액과 차이가 있을 수 있습니다.
   * @return 실제 출금액을 의미합니다. 출금이 되었다면 money와 동일하고 아니라면 0입니다.
   * @throws WithdrawalException 마이너스 출금과 잔고보다 큰 금액의 출금을 처리하는 예외입니다.
   */
  public long withdrawal(long money) throws WithdrawalException {  //---------------- 예외 회피
    if (money < 0) {
      throw new WithdrawalException(money + "원 출금 불가");  //---------------------- 예외 발생 (0을 반환)
    }
    if (balance < money) {
      throw new WithdrawalException("잔고 부족 (현재 잔고: " + balance + "원)");  //-- 예외 발생 (0을 반환)
    }
    balance -= money;
    return money;
  }
  
  /**
   * 이체 메소드입니다. 입금 메소드와 출금 메소드를 활용해서 구현해야 합니다.
   * 현재 통장에서 출금된 금액이 상대 통장으로 입금되도록 구현합니다.
   * @param bankAccount 이체해줘야할 은행계좌 객체입니다.
   * @param money 이체하고자 하는 금액입니다.
   * @throws DepositException 
   * @throws WithdrawalException 
   */
  public void transfer(BankAccount bankAccount, long money) throws DepositException, WithdrawalException {
    bankAccount.deposit( withdrawal(money) );
  }
  
  /**
   * 계좌 조회 메소드입니다. 계좌번호와 잔고를 출력합니다.
   */
  public void inquiry() {
    System.out.println("계좌번호: " + accNo);
    System.out.println("잔고: " + balance);
  }
  
}
