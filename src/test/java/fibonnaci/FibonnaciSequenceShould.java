package fibonnaci;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class FibonnaciSequenceShould {

  FibonnaciSequenceGenerator fibonnaciSequenceGenerator = new FibonnaciSequenceGenerator();

  @Test
  public void return0WhenUserInputIs1() {
    //given
    int userInput = 1;

    //when
    int sequenceNumber = fibonnaciSequenceGenerator.get(userInput);

    //then
    assertTrue(sequenceNumber == 0);
  }

  @Test
  public void return1WhenUserInputIs2() {
    //given
    int userInput = 2;

    //when
    int sequenceNumber = fibonnaciSequenceGenerator.get(userInput);

    //then
    assertThat("sequence", sequenceNumber, is(1));
  }

  @Test
  public void return2WhenUserInputIs4() {
    //given
    int userInput = 4;

    //when
    int sequenceNumber = fibonnaciSequenceGenerator.get(userInput);

    //then
    assertThat("sequence", sequenceNumber, is(2));
  }

  @Test
  public void return8WhenUserInputIs7() {
    //given
    int userInput = 7;

    //when
    int sequenceNumber = fibonnaciSequenceGenerator.get(userInput);

    //then
    assertThat("sequence", sequenceNumber, is(8));
  }

  @Test
  public void return13WhenUserInputIs8() {
    //given
    int userInput = 8;

    //when
    int sequenceNumber = fibonnaciSequenceGenerator.get(userInput);

    //then
    assertThat("sequence", sequenceNumber, is(13));
  }

}

