import callback.Callback;
import exception.NoJokeException;
import model.Joke;
import repository.JokeRepository;

public class App {
    public static void main(String[] args) throws NoJokeException {
        JokeRepository repository = new JokeRepository();
        repository.random(new Callback<Joke>() {
            @Override
            public void onSuccess(Joke value) {
                System.out.println(value);
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e);
            }
        });

    }
}