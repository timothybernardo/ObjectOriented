package answers;

import ratings.FilterCriteria;
import ratings.Show;

public class PushSkew implements FilterCriteria {
  private final FilterCriteria crit;
  private final Show show;

  public PushSkew(FilterCriteria crit, Show show) {
    if (crit == null || show == null) {
      throw new IllegalArgumentException();
    }
    this.crit = crit;
    this.show = show;
  }

  @Override
  public boolean shouldRetrieve(Show show) {
    return crit.shouldRetrieve(show) || show.equals(this.show);
  }
}
