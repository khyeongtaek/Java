package chap06_BankAccount;

public class DepositException extends Exception {

  private static final long serialVersionUID = 9060969671278883728L;

  public DepositException(String message) {
    super(message);
  }
  
}
