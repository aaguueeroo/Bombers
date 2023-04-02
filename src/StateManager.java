/**
 * Enum for the different states of the game.
 * <ul>
 *   <li>{@code INITIALIZED}: the window frame and panel have been created. The Panel shows the main menu of the game.</li>
 *   <li>{@code RUNNING}: player is being able to interact with the gameplay.</li>
 *   <li>{@code PAUSED}: the game is running but time is paused and player cannot interact with the gameplay. The panel
 *     shows a pause menu, being able to resume the game or go back to the main menu at any time.</li>
 *   <li>{@code FINISHED}: the game is finished and there is a dialog shown on the screen (game over or victory). The
 *         player cannot resume the game.</li>
 * </ul>
 */
enum GameStates {
    INITIALIZED,
    RUNNING,
    PAUSED,
    FINISHED
}

/**
 * Responsible for managing the state of the game.
 */
public class StateManager {

    public GameStates gameState;

    public void setState(GameStates newGameState) {
        //Initialize
        if(newGameState == GameStates.INITIALIZED){
            gameState = GameStates.INITIALIZED;
        }
        //Start
        else if (newGameState == GameStates.RUNNING && gameState == GameStates.INITIALIZED) {
            gameState = GameStates.RUNNING;
        }
        //Resume
        else if (newGameState == GameStates.RUNNING && gameState == GameStates.PAUSED) {
            gameState = GameStates.RUNNING;
        }
        //Pause
        else if (newGameState == GameStates.PAUSED && gameState == GameStates.RUNNING) {
            gameState = GameStates.PAUSED;
        }
        //Finish
        else if (newGameState == GameStates.FINISHED && (gameState == GameStates.RUNNING || gameState == GameStates.PAUSED)) {
            gameState = GameStates.FINISHED;
        }
    }
}
