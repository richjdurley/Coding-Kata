package bank;

import java.io.PrintStream;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.stream.Collectors;

/**
 * Created by Rich on 21/04/2016.
 */
public class StatementPrinter {

  private Account account;

  public StatementPrinter(Account account) {
    this.account = account;
  }

  private static final String HEADER = "DATE       | AMOUNT  | BALANCE";
  private static final String BODY_LINE = "%s | %s | %s";

  public static StatementPrinter using(Account account) {
    return new StatementPrinter(account);
  }

  private void printHeader(PrintStream ps) {
    ps.print(HEADER);
  }

  private void printBodyLine(AccountTransaction accountTransaction, PrintStream ps) {
    try {
      ps.println(String
          .format(BODY_LINE, StatementFormatter.formatDate(accountTransaction.getDate()),
              StatementFormatter.formatAmount(accountTransaction.getAmount()), StatementFormatter
                  .formatAmount(account.getBalanceForTransaction(accountTransaction))));
    } catch (ParseException e) {
      throw new StatementPrinterException("Parse exception printing statement line", e);
    }
  }

  private void printBody(PrintStream ps) {
    ps.print("\r\n");
    account.getTransactionHistory().stream().collect(Collectors.toCollection(ArrayDeque::new))
        .descendingIterator().forEachRemaining(e -> printBodyLine(e, ps));
  }

  public void print(PrintStream ps) throws ParseException {
    printHeader(ps);
    if (account.getTransactionHistory().size() > 0)
      printBody(ps);
  }

}
