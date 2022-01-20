import tictactoe.controllers.WelcomeController;
import tictactoe.models.Welcome;
import tictactoe.views.WelcomePanel;
import tictactoe.views.Window;

public class Program {

    public static void main(String[] args) {
        //Model
        Welcome welcome = new Welcome();
        //View
        WelcomePanel panel = new WelcomePanel();
        //Controller
        WelcomeController controller = new WelcomeController(welcome, panel);

        Window window = new Window("Welcome!", panel);
        window.setVisible(true);
    }

}