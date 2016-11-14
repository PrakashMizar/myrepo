import java.io.Console;

public class Prompter {
		//all IO
	private Game mGame;

	public Prompter(Game game){
		mGame = game;
	}
	public void play() {
		while(mGame.getRemainingTries() > 0 && !mGame.isSolved()) {
			displayProgress();
			promptForGuess();
		}
		if (mGame.isSolved()) {
			System.out.printf("%s !You won with %d remaining tries \n",mGame.getAnswer(),mGame.getRemainingTries());
			
		}else {
			System.out.printf("You lost. The word was %s \n",mGame.getAnswer());

		}
	}

	public boolean promptForGuess(){
		Console console = System.console();
		boolean isHit = false;
		boolean isValidGuess = false;
		while (! isValidGuess) {
			String guessAsString = console.readLine("Enter a letter: ");
			
			try {
		 		isHit = mGame.applyGuess(guessAsString);
		 		isValidGuess = true;
			} catch (IllegalArgumentException iae) {
				console.printf("%s try again \n",iae.getMessage());
			}	
		}
		return isHit;
	}

	public void displayProgress() {
		System.out.printf("You have %d tries to solve %s\n", mGame.getRemainingTries(),
															 mGame.getCurrentProgress());
		
	}
}