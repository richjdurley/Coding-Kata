package fizz_buzz;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class FizzBuzzShould {

  private TestablePrintStream testablePrintStream;


  class TestablePrintStream extends PrintStream {

    StringBuilder output = new StringBuilder();

    public TestablePrintStream(OutputStream o) {
      super(o);
    }

    @Override
    public void print(String toPrint) {
      output.append(toPrint);
      super.print(toPrint);
    }

    public String getPrintLineNumber(int line_number) {
      String[] printLines = output.toString().split("\n");
      return printLines[line_number - 1];
    }

  }

  @Test()
  public void shouldPrintNumberOneAsFirstPrintLineReturned() {
    //given
    TestablePrintStream printStream =
        new TestablePrintStream(new PrintStream(new ByteArrayOutputStream()));
    FizzBuzz fizzBuzz = new FizzBuzz(printStream);

    //when
    fizzBuzz.printNumbers();

    //then
    assertThat(printStream.getPrintLineNumber(1), is("1"));
  }


  @Test
  public void shouldPrintFizzWhenNumberIsMultiplyOf3() {
    //given
    TestablePrintStream printStream =
        new TestablePrintStream(new PrintStream(new ByteArrayOutputStream()));
    ;
    FizzBuzz fizzBuzz = new FizzBuzz(printStream);

    //when
    fizzBuzz.printNumbers();

    //then
    assertThat(printStream.getPrintLineNumber(3), is("Fizz"));
    assertThat(printStream.getPrintLineNumber(6), is("Fizz"));
    assertThat(printStream.getPrintLineNumber(33), is("Fizz"));
  }

  @Test
  public void shouldPrintBuzzWhenNumberIsMultiplyOf5() {
    //given
    TestablePrintStream printStream =
        new TestablePrintStream(new PrintStream(new ByteArrayOutputStream()));
    FizzBuzz fizzBuzz = new FizzBuzz(printStream);
    //when
    fizzBuzz.printNumbers();

    //then
    assertThat(printStream.getPrintLineNumber(5), is("Buzz"));
    assertThat(printStream.getPrintLineNumber(10), is("Buzz"));
    assertThat(printStream.getPrintLineNumber(20), is("Buzz"));

  }

  @Test
  public void shouldPrintFizzBuzzWhenNumberIsMultiplyOf3And5AtTheSameTime() {
    //given

    TestablePrintStream printStream =
        new TestablePrintStream(new PrintStream(new ByteArrayOutputStream()));
    FizzBuzz fizzBuzz = new FizzBuzz(printStream);

    //when
    fizzBuzz.printNumbers();

    //then
    assertThat(printStream.getPrintLineNumber(15), is("FizzBuzz"));
    assertThat(printStream.getPrintLineNumber(30), is("FizzBuzz"));
    assertThat(printStream.getPrintLineNumber(60), is("FizzBuzz"));
  }

  @Test
  public void printToConsole() {
    FizzBuzz fizzBuzz = new FizzBuzz(System.out);
    //when
    fizzBuzz.printNumbers();
    assertTrue(true);
  }

}
