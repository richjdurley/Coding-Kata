package bank;

import java.util.ArrayList;
import java.util.List;

public class Account {

  Double balance;

  ArrayList<Transaction> transactionHistory = new ArrayList<>();

  public Account() {
    balance = 0.0d;
  }

  public void deposit(Double amount) {
    balance+=amount;
  }

  public void withdraw(Double amount) {
    if (balance-amount<0)
      throw new InsufficientBalanceException();

    balance-=amount;
  }

  public Double getBalance() {
    return balance;
  }

  public List<Transaction> getTransactionHistory() {
    return transactionHistory;
  }
}
