package org.example;

// Functional interface for filtering plushies
interface IPredicate<T> {
  boolean test(T t);
}

// Checks if a plushie is non-huggable
class IsNonHuggable implements IPredicate<Plushie> {
  public boolean test(Plushie p) {
    return !p.huggable;
  }
}

// Checks if a plushie is fluffy
class IsFluffy implements IPredicate<Plushie> {
  public boolean test(Plushie p) {
    return p.fluffy;
  }
}
