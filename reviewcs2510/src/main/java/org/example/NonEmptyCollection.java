package org.example;

// Represents a non-empty plushie collection
class NonEmptyCollection implements PlushieCollection {
  Plushie first;
  PlushieCollection rest;

  NonEmptyCollection(Plushie first, PlushieCollection rest) {
    this.first = first;
    this.rest = rest;
  }

  // Add a plushie to the back if not already present
  public PlushieCollection add(Plushie p) {
    if (this.contains(p)) {
      return this;  // already exists
    } else {
      return new NonEmptyCollection(this.first, this.rest.add(p));
    }
  }

  // Helper: check if plushie is in collection
  boolean contains(Plushie p) {
    return this.first.samePlushie(p) || this.restContains(p);
  }

  boolean restContains(Plushie p) {
    if (this.rest instanceof NonEmptyCollection) {
      return ((NonEmptyCollection) this.rest).contains(p);
    } else {
      return false;
    }
  }

  // Reduce to non-huggable plushies
  public PlushieCollection reduceToNonHuggable() {
    return this.reduce(new IsNonHuggable());
  }

  // Reduce to fluffy plushies
  public PlushieCollection reduceToFluffy() {
    return this.reduce(new IsFluffy());
  }

  // Abstract reduce method
  public PlushieCollection reduce(IPredicate<Plushie> pred) {
    if (pred.test(this.first)) {
      return new NonEmptyCollection(this.first, this.rest.reduce(pred));
    } else {
      return this.rest.reduce(pred);
    }
  }
}
