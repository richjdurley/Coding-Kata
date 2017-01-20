package bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rich on 21/04/2016.
 */
public class Account {

  ArrayList<AccountTransaction> transaction_history = new ArrayList<AccountTransaction>();

  public double getBalanceForTransaction(AccountTransaction transaction) {
    return transaction_history.subList(0, transaction_history.indexOf(transaction) + 1).stream()
        .mapToDouble(trans -> trans.getAmount()).sum();
  }

  public double getFinalBalance() {
    if (transaction_history.size() > 0)
      return getBalanceForTransaction(getLastTransaction());
    else
      return 0d;
  }

  private AccountTransaction getLastTransaction() {
    return transaction_history.get(transaction_history.size() - 1);
  }

  public void deposit(AccountTransaction deposit) {
    transaction_history.add(deposit);
  }

  public void withdraw(AccountTransaction withdrawl) {
    transaction_history.add(withdrawl);
  }

  public List<AccountTransaction> getTransactionHistory() {
    return transaction_history;
  }

}
