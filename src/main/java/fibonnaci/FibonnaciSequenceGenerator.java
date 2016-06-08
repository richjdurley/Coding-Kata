package fibonnaci;

public class FibonnaciSequenceGenerator {

  String fib = "0,1,1,2,3,5,8,13";

  public int get(int userInput) {
    int n = 1;
    int n_1 = 0;
    int output = 0;

    if (userInput == 1)
      return 0;
    else if (userInput == 2)
      return 1;
    else {
      for (int i = 3; i < userInput + 1; i++) {
        output = n_1 + n;
        n_1 = n;
        n = output;
      }
      return output;
    }
  }
}
