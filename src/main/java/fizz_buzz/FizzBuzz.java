package fizz_buzz;

import java.io.PrintStream;

public class FizzBuzz {

  PrintStream printStream;

  public FizzBuzz(PrintStream toPrint) {
    this.printStream = toPrint;
  }

  public void printNumbers() {
    for (int i = 1; i <= 100; i++) {
      if (i % 3 == 0) {
        printStream.print("Fizz");
      }
      if (i % 5 == 0) {
        printStream.print("Buzz");
      }

      if (i % 3 != 0 && i % 5 != 0) {
        printStream.print(String.valueOf(i));
      }
      printStream.print("\n");
    }
  }



}
