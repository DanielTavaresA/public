package goolge;

import java.util.Iterator;
import java.util.Optional;

import internet.Internet;
import model.Result;

import static java.util.Optional.empty;

public class Goolge {

  public static Optional<Result> search(String[] keywords) {
    Iterator<String> iterator = Internet.find(keywords);
    if (iterator.hasNext()) {
      return Optional.of(new Result(iterator));
    }
    return Optional.empty();
  }
}