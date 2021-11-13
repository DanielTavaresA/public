import controller.Controller;
import model.Model;
import view.TextView;
import view.View;

public class App {

  /** Starts the "Rock Paper Scissors" game */
  public static void main(String[] args) {
    // TODO: instantiate MVC components so you can play the game
    Model model = new Model();
    Controller controller = new Controller(model);
    View view = new TextView(model, controller);


  }
}
