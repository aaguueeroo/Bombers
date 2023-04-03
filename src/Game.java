import gui.window.Frame;
import gui.window.GamePanel;
import gui.window.HomePanel;
import gui.window.A_Panel;
import input_output.KeyHandler;

/**
 * Main class of the game. It manages the screens.
 */
public class Game {

    final private Frame frame;
    final private KeyHandler keyHandler;
    final private StateManager stateManager;

    private A_Panel panel;
    private Gameplay gameplay;

    public Game() {
        frame = new Frame("Bombers");
        stateManager = new StateManager();
        keyHandler = new KeyHandler();
        frame.addKeyListener(keyHandler);
    }

    /**
     * Starts the application showing the main menu.
     */
    public void init() {
        panel = new HomePanel();
        frame.setPanel(panel);
        stateManager.setState(GameStates.INITIALIZED);
    }

    /**
     * Starts the gameplay mode.
     */
    public void start() {
        panel = new GamePanel();
        gameplay = new Gameplay(panel, keyHandler, stateManager);

        frame.setPanel(panel);

        gameplay.init();
        gameplay.run();

        stateManager.setState(GameStates.RUNNING);
    }

//    /**
//     * Finishes the game play mode, showing the end screen with a victory or game over message.
//     * The state is changed to FINISHED.
//     */
//    public void finish() {
//        //Draw somehow the victory dialog or the game over dialog.
//        stateManager.setState(GameStates.FINISHED);
//    }







}
