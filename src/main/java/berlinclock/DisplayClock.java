package berlinclock;

public class DisplayClock {

  private static final String ANSI_CLS = "\u001b[2J";

  public static StringBuffer printClock(StringBuffer print, BerlinClockTime berlinClockTime) {
    print.append((berlinClockTime.isSecondLampOn() ?
        ANSIColours.ANSI_YELLOW.getAnsiColourCode() :
        ANSIColours.ANSI_BLACK.getAnsiColourCode()));
    print.append("                 * *\r\n");
    print.append("               *     *\r\n");
    print
        .append("              *   " + (berlinClockTime.isSecondLampOn() ? 'Y' : 'O') + "   *\r\n");
    print.append("               *     *\r\n");
    print.append("                 * *\r\n");


    printLamps(4, print, berlinClockTime.numberOfFiveHoursLampsOn(), ANSIColours.ANSI_RED);
    printLamps(4, print, berlinClockTime.numberOfOneHoursLampsOn(), ANSIColours.ANSI_RED);
    printFiveMinuteLamps(print, berlinClockTime.numberOfFiveMinuteLampsOn());
    printLamps(4, print, berlinClockTime.numberOfOneMinuteLampsOn(), ANSIColours.ANSI_YELLOW);


    return print;
  }

  private static void printFiveMinuteLamps(StringBuffer print, int numberOfLamps) {
    print.append(" ");
    for (int i = 0; i < 11; i++) {
      if ((i + 1) % 3 != 0) {
        print.append(numberOfLamps > i ?
            ANSIColours.ANSI_YELLOW.getAnsiColourCode() :
            ANSIColours.ANSI_BLACK.getAnsiColourCode());
        print.append("╔═╗");
      } else {
        print.append(numberOfLamps > i ?
            ANSIColours.ANSI_RED.getAnsiColourCode() :
            ANSIColours.ANSI_BLACK.getAnsiColourCode());
        print.append("╔═╗ ");
      }
    }

    print.append("\r\n");
    print.append(" ");

    for (int i = 0; i < 11; i++) {
      if ((i + 1) % 3 != 0) {
        print.append(numberOfLamps > i ?
            ANSIColours.ANSI_YELLOW.getAnsiColourCode() :
            ANSIColours.ANSI_BLACK.getAnsiColourCode());
        print.append("║" + (numberOfLamps > i ? "Y" : "O") + "║");
      } else {
        print.append(numberOfLamps > i ?
            ANSIColours.ANSI_RED.getAnsiColourCode() :
            ANSIColours.ANSI_BLACK.getAnsiColourCode());
        print.append("║" + (numberOfLamps > i ? "R" : "O") + "║ ");
      }

    }

    print.append("\r\n");
    print.append(" ");

    for (int i = 0; i < 11; i++) {
      if ((i + 1) % 3 != 0) {
        print.append(numberOfLamps > i ?
            ANSIColours.ANSI_YELLOW.getAnsiColourCode() :
            ANSIColours.ANSI_BLACK.getAnsiColourCode());
        print.append("╚═╝");
      } else {
        print.append(numberOfLamps > i ?
            ANSIColours.ANSI_RED.getAnsiColourCode() :
            ANSIColours.ANSI_BLACK.getAnsiColourCode());
        print.append("╚═╝ ");
      }
    }

    print.append("\r\n");

  }

  private static void printLamps(int totalLamps, StringBuffer print, int numberOfLamps,
      ANSIColours onColour) {
    print.append(" ");
    for (int i = 0; i < totalLamps; i++) {
      print.append(numberOfLamps > i ?
          onColour.getAnsiColourCode() :
          ANSIColours.ANSI_BLACK.getAnsiColourCode());
      print.append("╔═══════╗");
    }

    print.append("\r\n");
    print.append(" ");
    for (int i = 0; i < totalLamps; i++) {
      print.append(numberOfLamps > i ?
          onColour.getAnsiColourCode() :
          ANSIColours.ANSI_BLACK.getAnsiColourCode());
      if (onColour.equals(ANSIColours.ANSI_RED))
        print.append("║   " + (numberOfLamps > i ? "R" : "O") + "   ║");
      else
        print.append("║   " + (numberOfLamps > i ? "Y" : "O") + "   ║");
    }

    print.append("\r\n");
    print.append(" ");
    for (int i = 0; i < totalLamps; i++) {
      print.append(numberOfLamps > i ?
          onColour.getAnsiColourCode() :
          ANSIColours.ANSI_BLACK.getAnsiColourCode());
      print.append("╚═══════╝");
    }
    print.append("\r\n");
  }

  public static void main(String args[]) throws Exception {
    while (true) {
      System.out.print(ANSI_CLS);
      System.out.println(DisplayClock.printClock(new StringBuffer(), BerlinClockTime.now()));
      Thread.currentThread().sleep(1000);
    }

  }

}
