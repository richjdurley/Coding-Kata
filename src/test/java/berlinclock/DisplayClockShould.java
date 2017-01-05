package berlinclock;

import berlinclock.BerlinClockTime;
import berlinclock.DisplayClock;
import berlinclock.ANSIColours;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;

public class DisplayClockShould {


  private static final String TEN_HOURS_THIRTEEN_MINUTES_AND_ZERO_SECONDS_DISPLAY = "                 * *\r\n"
      + "               *     *\r\n" + "              *   Y   *\r\n" + "               *     *\r\n"
      + "                 * *\r\n" + " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\r\n"
      + " ║   R   ║║   R   ║║   O   ║║   O   ║\r\n" + " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\r\n"
      + " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\r\n" + " ║   O   ║║   O   ║║   O   ║║   O   ║\r\n"
      + " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\r\n" + " ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗╔═╗ ╔═╗╔═╗\r\n"
      + " ║Y║║Y║║O║ ║O║║O║║O║ ║O║║O║║O║ ║O║║O║\r\n" + " ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝╚═╝ ╚═╝╚═╝\r\n"
  + " ╔═══════╗╔═══════╗╔═══════╗╔═══════╗\r\n" + " ║   Y   ║║   Y   ║║   Y   ║║   O   ║\r\n"
      + " ╚═══════╝╚═══════╝╚═══════╝╚═══════╝\r\n";

  @Test
  public void shouldDisplayGivenClockWhenTimeIsTenHoursThirteenMinutesAndZeroSeconds() {
    StringBuffer output = new StringBuffer();
    DisplayClock.printClock(output, new BerlinClockTime(LocalTime.of(10,13,0)));
    String testable_display_output = output.toString().replace(ANSIColours.ANSI_BLACK.getAnsiColourCode(), "").replace(ANSIColours.ANSI_YELLOW.getAnsiColourCode(),"").replace(ANSIColours.ANSI_RED.getAnsiColourCode(), "");
    Assert.assertThat(testable_display_output, is(TEN_HOURS_THIRTEEN_MINUTES_AND_ZERO_SECONDS_DISPLAY));
  }

}
