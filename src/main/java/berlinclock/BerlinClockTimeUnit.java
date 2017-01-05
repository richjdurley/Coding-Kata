package berlinclock;

import java.util.concurrent.TimeUnit;

public enum BerlinClockTimeUnit {

  SECONDS (TimeUnit.SECONDS, 2),
  FIVE_HOURS (TimeUnit.HOURS, 5),
  ONE_HOURS (TimeUnit.HOURS, 1),
  FIVE_MINUTES (TimeUnit.MINUTES, 5);

  private TimeUnit metricTimeUnit;
  private int metricTimeInterval;

  BerlinClockTimeUnit(TimeUnit metricTimeUnit, int metricTimeInterval) {
    this.metricTimeUnit = metricTimeUnit;
    this.metricTimeInterval = metricTimeInterval;
  }

  public TimeUnit getMetricTimeUnit() {
    return metricTimeUnit;
  }

  public int getMetricTimeInterval() {
    return metricTimeInterval;
  }


}
