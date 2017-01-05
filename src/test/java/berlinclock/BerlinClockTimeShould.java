package berlinclock;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

public class BerlinClockTimeShould {

  @Test
  public void returnSecondOnWhenSecondIsEvenZero() {
    //given
    LocalTime time = LocalTime.of(0, 0, 0);

    //when
    BerlinClockTime berlinClockTime = new BerlinClockTime(time);

    //then
    Assert.assertThat(berlinClockTime.isSecondLampOn(), is(true));
  }

  @Test
  public void returnSecondOnFalseWhenSecondIsOddOne() {
    //given
    LocalTime time = LocalTime.of(0, 0, 1);

    //when
    BerlinClockTime berlinClockTime = new BerlinClockTime(time);

    //then
    Assert.assertThat(berlinClockTime.isSecondLampOn(), is(false));
  }

  @Test
  public void returnSecondLampOnWhenSecondIsEvenTwo() {
    //given
    LocalTime time = LocalTime.of(0, 0, 2);

    //when
    BerlinClockTime berlinClockTime = new BerlinClockTime(time);

    //then
    Assert.assertThat(berlinClockTime.isSecondLampOn(), is(true));
  }


  @Test
  public void returnZeroFiveHourLampsOnWhenLessThanFiveHours() {
    //given
    LocalTime time0 = LocalTime.of(1, 0, 0);
    LocalTime time1 = LocalTime.of(2, 0, 0);
    LocalTime time2 = LocalTime.of(4, 0, 0);

    //when
    BerlinClockTime berlinClockTime0 = new BerlinClockTime(time0);
    BerlinClockTime berlinClockTime1 = new BerlinClockTime(time1);
    BerlinClockTime berlinClockTime2 = new BerlinClockTime(time2);


    //then
    assertTrue(berlinClockTime0.numberOfFiveHoursLampsOn() == 0);
    assertTrue(berlinClockTime1.numberOfFiveHoursLampsOn() == 0);
    assertTrue(berlinClockTime2.numberOfFiveHoursLampsOn() == 0);

  }

  @Test
  public void returnOneFiveHourLampsOnWhenGreaterThanOrEqualsToFiveAndLessThan10() {
    //given
    LocalTime time1 = LocalTime.of(5, 0, 0);
    LocalTime time2 = LocalTime.of(7, 0, 0);
    LocalTime time3 = LocalTime.of(10, 0, 0);

    //when
    BerlinClockTime berlinClockTime1 = new BerlinClockTime(time1);
    BerlinClockTime berlinClockTime2 = new BerlinClockTime(time2);
    BerlinClockTime berlinClockTime3 = new BerlinClockTime(time3);


    //then
    Assert.assertTrue(berlinClockTime1.numberOfFiveHoursLampsOn() == 1);
    Assert.assertTrue(berlinClockTime2.numberOfFiveHoursLampsOn() == 1);
    Assert.assertTrue(berlinClockTime3.numberOfFiveHoursLampsOn() != 1);

  }


  @Test
  public void returnTwoFiveHoursLampsOnWhenGreaterThanTenAndLessThanFifteen() {
    //given
    LocalTime time0 = LocalTime.of(1, 0, 0);
    LocalTime time1 = LocalTime.of(10, 0, 0);
    LocalTime time2 = LocalTime.of(12, 0, 0);
    LocalTime time3 = LocalTime.of(15, 0, 0);

    //when
    BerlinClockTime berlinClockTime0 = new BerlinClockTime(time0);
    BerlinClockTime berlinClockTime1 = new BerlinClockTime(time1);
    BerlinClockTime berlinClockTime2 = new BerlinClockTime(time2);
    BerlinClockTime berlinClockTime3 = new BerlinClockTime(time3);


    //then
    Assert.assertTrue(berlinClockTime0.numberOfFiveHoursLampsOn() != 2);
    Assert.assertThat(berlinClockTime1.numberOfFiveHoursLampsOn(), is(2));
    Assert.assertThat(berlinClockTime2.numberOfFiveHoursLampsOn(), is(2));
    Assert.assertTrue(berlinClockTime3.numberOfFiveHoursLampsOn() != 2);

  }


  @Test
  public void returnThreeFiveHourLampsONWhenGreaterThanFourteenAndLessThanTwenty() {
    //given
    LocalTime time0 = LocalTime.of(14, 0, 0);
    LocalTime time1 = LocalTime.of(15, 0, 0);
    LocalTime time2 = LocalTime.of(17, 0, 0);
    LocalTime time3 = LocalTime.of(20, 0, 0);

    //when
    BerlinClockTime berlinClockTime0 = new BerlinClockTime(time0);
    BerlinClockTime berlinClockTime1 = new BerlinClockTime(time1);
    BerlinClockTime berlinClockTime2 = new BerlinClockTime(time2);
    BerlinClockTime berlinClockTime3 = new BerlinClockTime(time3);


    //then
    Assert.assertTrue(berlinClockTime0.numberOfFiveHoursLampsOn() != 3);
    Assert.assertThat(berlinClockTime1.numberOfFiveHoursLampsOn(), is(3));
    Assert.assertThat(berlinClockTime2.numberOfFiveHoursLampsOn(), is(3));
    Assert.assertTrue(berlinClockTime3.numberOfFiveHoursLampsOn() != 3);

  }


  @Test
  public void returnFourFiveHourLampsONWhenGreaterThanTwentyAndLessThanTwentyFour() {
    //given
    LocalTime time0 = LocalTime.of(19, 0, 0);
    LocalTime time1 = LocalTime.of(20, 0, 0);
    LocalTime time2 = LocalTime.of(23, 0, 0);
    LocalTime time3 = LocalTime.of(22, 0, 0);

    //when
    BerlinClockTime berlinClockTime0 = new BerlinClockTime(time0);
    BerlinClockTime berlinClockTime1 = new BerlinClockTime(time1);
    BerlinClockTime berlinClockTime2 = new BerlinClockTime(time2);
    BerlinClockTime berlinClockTime3 = new BerlinClockTime(time3);


    //then
    Assert.assertTrue(berlinClockTime0.numberOfFiveHoursLampsOn() != 4);
    Assert.assertThat(berlinClockTime1.numberOfFiveHoursLampsOn(), is(4));
    Assert.assertThat(berlinClockTime2.numberOfFiveHoursLampsOn(), is(4));
    Assert.assertThat(berlinClockTime3.numberOfFiveHoursLampsOn(), is(4));

  }

  @Test
  public void returnZeroOneHourLampsONWhenZeroFiveTenFifteenAndTwentyHours() {
    //given
    LocalTime time0 = LocalTime.of(0, 0, 0);
    LocalTime time1 = LocalTime.of(5, 0, 0);
    LocalTime time2 = LocalTime.of(10, 0, 0);
    LocalTime time3 = LocalTime.of(15, 0, 0);
    LocalTime time4 = LocalTime.of(20, 0, 0);

    //when
    BerlinClockTime berlinClockTime0 = new BerlinClockTime(time0);
    BerlinClockTime berlinClockTime1 = new BerlinClockTime(time1);
    BerlinClockTime berlinClockTime2 = new BerlinClockTime(time2);
    BerlinClockTime berlinClockTime3 = new BerlinClockTime(time3);
    BerlinClockTime berlinClockTime4 = new BerlinClockTime(time4);

    //then
    Assert.assertThat(berlinClockTime0.numberOfOneHoursLampsOn(), is(0));
    Assert.assertThat(berlinClockTime1.numberOfOneHoursLampsOn(), is(0));
    Assert.assertThat(berlinClockTime2.numberOfOneHoursLampsOn(), is(0));
    Assert.assertThat(berlinClockTime3.numberOfOneHoursLampsOn(), is(0));
    Assert.assertThat(berlinClockTime4.numberOfOneHoursLampsOn(), is(0));
  }

  @Test
  public void returnOneOneHourLampsONWhenOneSixElevenSixteenAndTwentyOneHours() {
    //given
    LocalTime time0 = LocalTime.of(1, 0, 0);
    LocalTime time1 = LocalTime.of(6, 0, 0);
    LocalTime time2 = LocalTime.of(11, 0, 0);
    LocalTime time3 = LocalTime.of(21, 0, 0);

    //when
    BerlinClockTime berlinClockTime0 = new BerlinClockTime(time0);
    BerlinClockTime berlinClockTime1 = new BerlinClockTime(time1);
    BerlinClockTime berlinClockTime2 = new BerlinClockTime(time2);
    BerlinClockTime berlinClockTime3 = new BerlinClockTime(time3);

    //then
    Assert.assertThat(berlinClockTime0.numberOfOneHoursLampsOn(), is(1));
    Assert.assertThat(berlinClockTime1.numberOfOneHoursLampsOn(), is(1));
    Assert.assertThat(berlinClockTime2.numberOfOneHoursLampsOn(), is(1));
    Assert.assertThat(berlinClockTime3.numberOfOneHoursLampsOn(), is(1));
  }

  @Test
  public void returnTwoOneHourLampsONWhenTwoSevenTwelveSeventeenAndTwentyTwoHours() {
    //given
    LocalTime time0 = LocalTime.of(2, 0, 0);
    LocalTime time1 = LocalTime.of(7, 0, 0);
    LocalTime time2 = LocalTime.of(12, 0, 0);
    LocalTime time3 = LocalTime.of(22, 0, 0);

    //when
    BerlinClockTime berlinClockTime0 = new BerlinClockTime(time0);
    BerlinClockTime berlinClockTime1 = new BerlinClockTime(time1);
    BerlinClockTime berlinClockTime2 = new BerlinClockTime(time2);
    BerlinClockTime berlinClockTime3 = new BerlinClockTime(time3);

    //then
    Assert.assertThat(berlinClockTime0.numberOfOneHoursLampsOn(), is(2));
    Assert.assertThat(berlinClockTime1.numberOfOneHoursLampsOn(), is(2));
    Assert.assertThat(berlinClockTime2.numberOfOneHoursLampsOn(), is(2));
    Assert.assertThat(berlinClockTime3.numberOfOneHoursLampsOn(), is(2));
  }

  @Test
  public void returnThreeOneHourLampsONWhenThreeEightThirteenEighteenAndTwentyThreeHours() {
    //given
    LocalTime time0 = LocalTime.of(3, 0, 0);
    LocalTime time1 = LocalTime.of(8, 0, 0);
    LocalTime time2 = LocalTime.of(13, 0, 0);
    LocalTime time3 = LocalTime.of(23, 0, 0);

    //when
    BerlinClockTime berlinClockTime0 = new BerlinClockTime(time0);
    BerlinClockTime berlinClockTime1 = new BerlinClockTime(time1);
    BerlinClockTime berlinClockTime2 = new BerlinClockTime(time2);
    BerlinClockTime berlinClockTime3 = new BerlinClockTime(time3);

    //then
    Assert.assertThat(berlinClockTime0.numberOfOneHoursLampsOn(), is(3));
    Assert.assertThat(berlinClockTime1.numberOfOneHoursLampsOn(), is(3));
    Assert.assertThat(berlinClockTime2.numberOfOneHoursLampsOn(), is(3));
    Assert.assertThat(berlinClockTime3.numberOfOneHoursLampsOn(), is(3));
  }

  @Test
  public void returnFourOneHourLampsONWhenFourNineFourteenAndNineteenHours() {
    //given
    LocalTime time0 = LocalTime.of(4, 0, 0);
    LocalTime time1 = LocalTime.of(9, 0, 0);
    LocalTime time2 = LocalTime.of(14, 0, 0);
    LocalTime time3 = LocalTime.of(19, 0, 0);

    //when
    BerlinClockTime berlinClockTime0 = new BerlinClockTime(time0);
    BerlinClockTime berlinClockTime1 = new BerlinClockTime(time1);
    BerlinClockTime berlinClockTime2 = new BerlinClockTime(time2);
    BerlinClockTime berlinClockTime3 = new BerlinClockTime(time3);

    //then
    Assert.assertThat(berlinClockTime0.numberOfOneHoursLampsOn(), is(4));
    Assert.assertThat(berlinClockTime1.numberOfOneHoursLampsOn(), is(4));
    Assert.assertThat(berlinClockTime2.numberOfOneHoursLampsOn(), is(4));
    Assert.assertThat(berlinClockTime3.numberOfOneHoursLampsOn(), is(4));
  }


  @Test
  public void returnOneFiveMinuteLampsONWhenFiveMinutes() {
    //given
    LocalTime time0 = LocalTime.of(4, 5, 0);

    //when
    BerlinClockTime berlinClockTime0 = new BerlinClockTime(time0);

    //then
    Assert.assertThat(berlinClockTime0.numberOfFiveMinuteLampsOn(), is(1));

  }

  @Test
  public void returnElevenFiveMinuteLampsONWhenFiftyFiveMinutes() {
    //given
    LocalTime time0 = LocalTime.of(4, 55, 0);

    //when
    BerlinClockTime berlinClockTime0 = new BerlinClockTime(time0);

    //then
    Assert.assertThat(berlinClockTime0.numberOfFiveMinuteLampsOn(), is(11));

  }

  @Test
  public void returnFourOneMinuteLampsONWhenFiftyNineMinutes() {
    //given
    LocalTime time0 = LocalTime.of(4, 59, 0);

    //when
    BerlinClockTime berlinClockTime0 = new BerlinClockTime(time0);

    //then
    Assert.assertThat(berlinClockTime0.numberOfOneMinuteLampsOn(), is(4));

  }




}
