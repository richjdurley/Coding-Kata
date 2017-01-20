package bank;

import bank.Account;
import bank.AccountTransaction;
import bank.StatementFormatter;
import bank.StatementPrinter;
import org.junit.Test;

import java.io.*;
import java.text.ParseException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Rich on 21/04/2016.
 */
public class StatementPrinterTestShould {

  private static String statementHeader= "DATE       | AMOUNT  | BALANCE";
  private static String statementLine3 = "10/01/2012 | 1000.00 | 1000.00";
  private static String statementLine2 = "13/01/2012 | 2000.00 | 3000.00";
  private static String statementLine1 = "14/01/2012 | -500.00 | 2500.00";

  @Test
  public void testStatementReturnsHeaderWhenNoTransactions() throws ParseException {
    //given
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);

    Account newaccount = new Account();
    StatementPrinter statementPrinter = new StatementPrinter(newaccount);

    //when
    statementPrinter.print(ps);
    String statement_out = baos.toString();

    //then
    assertThat(statement_out, is(statementHeader));
  }

  @Test
  public void testStatementReturnsHeaderAndOneAccountLine() throws IOException,ParseException {
    //given
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    Account account = new Account();
    AccountTransaction
        transaction = new AccountTransaction(StatementFormatter.formatDate("10-01-2012"), 1000d,
        AccountTransaction.TransactionType.CREDIT);
    AccountTransaction transaction2 = new AccountTransaction(StatementFormatter.formatDate("13-01-2012"), 2000d,
        AccountTransaction.TransactionType.CREDIT);
    AccountTransaction transaction3 = new AccountTransaction(StatementFormatter.formatDate("14-01-2012"), 500d,
        AccountTransaction.TransactionType.DEBIT);


    account.deposit(transaction);
    account.deposit(transaction2);
    account.withdraw(transaction3);


    StatementPrinter statementPrinter = new StatementPrinter(account);

    //When
    statementPrinter.print(ps);
    BufferedReader input_reader = new BufferedReader(new StringReader(baos.toString()));

    //then
    assertThat(input_reader.readLine(), is(statementHeader));
    assertThat(input_reader.readLine(), is(statementLine1));
    assertThat(input_reader.readLine(), is(statementLine2));
    assertThat(input_reader.readLine(), is(statementLine3));
  }

  @Test
  public void testStatement() {


  }
}
