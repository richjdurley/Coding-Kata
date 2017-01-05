package berlinclock;

import java.time.LocalTime;

public class BerlinClockTime {

  private LocalTime time;

  public BerlinClockTime(LocalTime time) {
    this.time = time;
  }

  public static BerlinClockTime now() {
    return new BerlinClockTime(LocalTime.now());
  }

  public boolean isSecondLampOn() {
    if (time.getSecond() % BerlinClockTimeUnit.SECONDS.getMetricTimeInterval() == 0)
      return true;
    else
      return false;
  }

  public int numberOfFiveHoursLampsOn() {
    return time.getHour() / BerlinClockTimeUnit.FIVE_HOURS.getMetricTimeInterval();
  }

  public int numberOfOneHoursLampsOn() {
    return time.getHour()-(numberOfFiveHoursLampsOn()*BerlinClockTimeUnit.FIVE_HOURS.getMetricTimeInterval());
  }

  public int numberOfFiveMinuteLampsOn() {
    return time.getMinute()/BerlinClockTimeUnit.FIVE_MINUTES.getMetricTimeInterval();
  }

  public int numberOfOneMinuteLampsOn() {
    return time.getMinute()-(numberOfFiveMinuteLampsOn()*BerlinClockTimeUnit.FIVE_MINUTES.getMetricTimeInterval());
  }


}
