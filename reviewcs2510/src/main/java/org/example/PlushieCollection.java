package org.example;

// Represents a collection of plushies
interface PlushieCollection {
  PlushieCollection add(Plushie p);

  PlushieCollection reduceToNonHuggable();

  PlushieCollection reduceToFluffy();

  PlushieCollection reduce(IPredicate<Plushie> pred);
}
