package answers;

import ratings.FilterCriteria;
import ratings.Show;

public class NormalSkew implements FilterCriteria {

  private final FilterCriteria crit;

  public NormalSkew(FilterCriteria crit) {
    if (crit == null) {
      throw new IllegalArgumentException();
    }
    this.crit = crit;
  }

  @Override
  public boolean shouldRetrieve(Show show) {
    return crit.shouldRetrieve(show);
  }
}
