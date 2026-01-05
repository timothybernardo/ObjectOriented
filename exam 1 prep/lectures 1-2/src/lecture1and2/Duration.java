package lecture1and2;

// IN OOD - data and operations on it are kept together
// this means representations of information is related to the operations we wish to perform on it

// for durations, operations: convert to seconds, one form of formatting, addition, comparisons

// assumptions: what time do we want to support? upper/lower bounds? diff units but same time?


public interface Duration extends Comparable<Duration> {
  long inSeconds();

  String asHMS();

  Duration plus(Duration other);

}
