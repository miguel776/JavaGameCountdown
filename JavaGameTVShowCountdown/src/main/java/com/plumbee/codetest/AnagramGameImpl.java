package com.plumbee.codetest;


/**
 * 
 * 
 * @author miguelgonzalez776
 *
 */
public class AnagramGameImpl implements AnagramGame {

    private final String letters;
    private final WordDictionary wordDictionary;
    private final Leaderboard leaderboard = new Leaderboard();

    /**
     * 
     * @param letters
     * @param wordDictionary
     */
    public AnagramGameImpl(String letters, WordDictionary wordDictionary) {
        this.letters = letters;
        this.wordDictionary = wordDictionary;
    }
    /**
     * 
     * @param username
     * @param word 
     */

    @Override
    public int submitWord(String username, String word) {
        final boolean isAnagram = checkIsAnagram(word);
        final boolean isValidWord = wordDictionary.contains(word);
        final int score = isAnagram && isValidWord ? word.length() : 0;
        if (score > 0) {
            leaderboard.insertEntry(username, word, score);
        }
        return score;
    }
    
	/**
	 * 
	 * @param position
	 */
    @Override
    public String getUserNameAtPosition(int position) {
        return leaderboard.getEntryAtPosition(position).getUsername();
    }

	/**
	 * 
	 * @param position
	 */
    @Override
    public String getWordEntryAtPosition(int position) {
        return leaderboard.getEntryAtPosition(position).getWord();
    }
    
	/**
	 * 
	 * @param position
	 */
    @Override
    public Integer getScoreAtPosition(int position) {
        return leaderboard.getEntryAtPosition(position).getScore();
    }
    
	/**
	 * 
	 * @param word
	 */
    private boolean checkIsAnagram(String word) {
        String auxLetters = letters;
        for (char c : word.toCharArray()) {
            if (auxLetters.indexOf(c) == -1) {
                return false;
            }
            auxLetters = auxLetters.replaceFirst(Character.toString(c), "");
        }
        return true;
    }
}
