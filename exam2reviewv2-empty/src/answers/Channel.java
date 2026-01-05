package answers;

import ratings.FilterCriteria;
import ratings.Show;

public interface Channel {
  String getName();

  void addShow(Show show);

  double averageRating();

  double filterRatings(FilterCriteria crit);
}
