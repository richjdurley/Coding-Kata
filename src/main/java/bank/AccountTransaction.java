package bank;

import java.util.Date;

/**
 * Created by Rich on 21/04/2016.
 */
public class AccountTransaction {
  private double amount;

  private Date date;
  private TransactionType transactionType;


  public enum TransactionType {
    CREDIT, DEBIT
  }

  public AccountTransaction(Date date, double amount, TransactionType type) {
    if (type.equals(TransactionType.DEBIT))
      this.amount = -1d * amount;
    else
      this.amount = amount;
    this.date = date;
    this.transactionType = type;
  }

  public double getAmount() {
    return amount;
  }

  public Date getDate() {
    return this.date;
  }

  public boolean isCredit() {
    return (transactionType.equals(TransactionType.CREDIT));
  }

  public boolean isDebit() {
    return (transactionType.equals(TransactionType.DEBIT));
  }
}
