package repository;

import callback.Callback;
import exception.NoJokeException;
import model.Joke;
import service.JokeService;

public class JokeRepository {
  private JokeService service = new JokeService();

  public void random(Callback<Joke> callback) throws NoJokeException {
    try {
      callback.onSuccess(service.random());
    }catch (Exception e){
      callback.onError(e);
    }
  }
}