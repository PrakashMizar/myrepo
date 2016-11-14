public class Game {
	//game logic
	public static final int MAX_MISSES = 7;
	private String mAnswer;
	private String mHits;
	private String mMisses;

	public Game(String answer) {

		mAnswer = answer;
		mHits = "";
		mMisses = "";
	}

	public String getAnswer() {
		return mAnswer;
	}

	private char validadeGuess(char letter) {
		if (!Character.isLetter(letter)) {
			throw new IllegalArgumentException("A letter is required.\n");
		}
		letter = Character.toLowerCase(letter);
		if (mMisses.indexOf(letter) >= 0 || mHits.indexOf(letter) >= 0) {
			throw new IllegalArgumentException(letter + " already guessed\n");
		}
		return letter;	
	}

	public boolean applyGuess(String letters) {
		if (letters.length() == 0) {
			throw new IllegalArgumentException("No letters found");
		}
		return applyGuess(letters.charAt(0));
	}

	public boolean applyGuess(char letter) {
		letter = validadeGuess(letter);
		//checking whether the character is in the string
		boolean isHit = mAnswer.indexOf(letter) >= 0;
		if (isHit) {
			mHits += letter;
		}else {
			mMisses +=  letter;
		}
		return isHit;
	}

	public String getCurrentProgress() {

		String progress = "";
		//loop through each of the letter in the answer
		//foreach loop
		for (char letter : mAnswer.toCharArray()) {
			char display = '-';
			if (mHits.indexOf(letter) >= 0) {
				display = letter;
			}
			progress += display;

		}
		return progress;
	}

	public int getRemainingTries() {

		return MAX_MISSES - mMisses.length();
	}

	public boolean isSolved() {
		return getCurrentProgress().indexOf('-') == -1;
	}
}