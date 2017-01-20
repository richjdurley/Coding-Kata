package bank;

import bank.Account;
import bank.AccountTransaction;
import bank.StatementFormatter;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.*;


/**
 * Created by Rich on 21/04/2016.
 */
public class AccountTestShould {

  private Account EMPTY_ACCOUNT = new Account();
  private Account ONE_DEPOSIT = new Account();
  private Account TWO_DEPOSIT = new Account();
  private Account DEPOSITS_AND_WITHDRAWAL = new Account();

  private AccountTransaction deposit1;
  private AccountTransaction deposit2;
  private AccountTransaction withdrawal1;


  @Before
  public void setupAccount() throws ParseException {
    //given
    deposit1 = new AccountTransaction(StatementFormatter.formatDate("10-01-2012"), 1000,
        AccountTransaction.TransactionType.CREDIT);
    ONE_DEPOSIT.deposit(deposit1);

    deposit2 = new AccountTransaction(StatementFormatter.formatDate("13-01-2012"), 2000,
        AccountTransaction.TransactionType.CREDIT);
    TWO_DEPOSIT.deposit(deposit1);
    TWO_DEPOSIT.deposit(deposit2);

    withdrawal1 = new AccountTransaction(StatementFormatter.formatDate("13-01-2012"), 500,
        AccountTransaction.TransactionType.DEBIT);
    DEPOSITS_AND_WITHDRAWAL.deposit(deposit1);
    DEPOSITS_AND_WITHDRAWAL.deposit(deposit2);
    DEPOSITS_AND_WITHDRAWAL.withdraw(withdrawal1);
  }

  @Test
  public void shouldReportBalanceOfZeroForNewAccount() {
    //then
    assertTrue(EMPTY_ACCOUNT.getFinalBalance() == 0);
  }

  @Test
  public void shouldReturnTheBalanceOfDepositedAmountForNew() throws ParseException {
    //given
    //when
    //then
    assertThat(ONE_DEPOSIT.getFinalBalance(), is(1000d));
  }

  @Test
  public void shouldHaveTheCorrectBalanceOfDepositedAmounts() throws ParseException {
    //then
    assertThat(TWO_DEPOSIT.getFinalBalance(), is(3000d));
  }

  @Test
  public void shouldHaveTheCorrectBalanceAfterWithdrawingTheAmount() throws ParseException {
    //then
    assertThat(DEPOSITS_AND_WITHDRAWAL.getFinalBalance(), is(2500d));
  }


  @Test
  public void shouldReturnTransactionHistory() throws ParseException {
      //given
    assertThat(DEPOSITS_AND_WITHDRAWAL.getTransactionHistory().get(0), is(deposit1));
    assertThat(DEPOSITS_AND_WITHDRAWAL.getTransactionHistory().get(1), is(deposit2));
    assertThat(DEPOSITS_AND_WITHDRAWAL.getTransactionHistory().get(2), is(withdrawal1));
  }

  @Test
  public void shouldHaveTheCorrectBalanceAfterEachTransaction() {
    assertThat(DEPOSITS_AND_WITHDRAWAL.getBalanceForTransaction(deposit1), is(1000d));
    assertThat(DEPOSITS_AND_WITHDRAWAL.getBalanceForTransaction(deposit2), is(3000d));
    assertThat(DEPOSITS_AND_WITHDRAWAL.getBalanceForTransaction(withdrawal1), is(2500d));
  }

  @Test
  public void shoudlReturnEmptyHistoryWhenNewAccount() {
    assertThat(EMPTY_ACCOUNT.getTransactionHistory().size(), is(0));
  }

}
