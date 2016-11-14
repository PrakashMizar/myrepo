public class HangMan {
	
	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("Enter a word \n");
			System.exit(0);
		}

		Game game = new Game(args[0]);
		
		Prompter prompter = new Prompter(game);
		prompter.play();
		/*
		prompter.displayProgress();

		boolean isHit = prompter.promptForGuess();
			if (isHit) {
				System.out.println("You got a hit");
				
			}else{
				System.out.println("Whoops, that was a miss");
			}
		prompter.displayProgress();
		*/
	}

}