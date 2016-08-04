package bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
public class BankAccountShould {

  @Test
  public void returnBalanceOfZeroForNewAccount() {
    //given
    Account account = new Account();
    //when
    //then
    assertThat(account.getBalance(), is(0.0d));
  }

  @Test
  public void returnBalanceOfDepositWhenOneDeposit() {
    //given
    Account account = new Account();
    //when
    account.deposit(100.0d);
    //then
    assertThat(account.getBalance(), is(100.0d));
  }

  @Test (expected = InsufficientBalanceException.class)
  public void throwExceptionWhenNewAccountAnOneWithdrawl() {
    //given
    Account account = new Account();
    //when
    account.withdraw(100.0d);
    //then
    //expect InsufficientBalanceException
  }

  @Test
  public void returnExpectedBalanceAfterOneDepositandOneWithdrawl() {
    //given
    Account account = new Account();
    //when
    account.deposit(100.0d);
    account.withdraw(50.0d);
    //then
    assertThat(account.getBalance(), is(50.0d));
  }

  @Test
  public void returnListOfTransactionMadeOneAccount() {
    //given
    Account account = new Account();
    List<Transaction> transaction_history= new ArrayList<>();
    Transaction deposit = new Transaction(TransactionType.DEPOSIT, 100.00d);
    Transaction withdrawl = new Transaction(TransactionType.WITHDRAWL, 100.00d);

    transaction_history.add(deposit);
    transaction_history.add(withdrawl);

    //when
    account.deposit(100.0d);
    account.withdraw(50.0d);
    //then
    assertThat(account.getTransactionHistory(), is(50.0d));
  }


}
