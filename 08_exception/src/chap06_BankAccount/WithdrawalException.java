package chap06_BankAccount;

public class WithdrawalException extends Exception {

  private static final long serialVersionUID = 2156902381266421134L;

  public WithdrawalException(String message) {
    super(message);
  }
  
}
