package com.plumbee.codetest;

/**
 * 
 * @author miguelgonzalez776
 *
 */

public class LeaderboardEntry {
    private final String username;
    private final String word;
    private final int score;

    public LeaderboardEntry(String username, String word, int score) {
        this.username = username;
        this.word = word;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public String getWord() {
        return word;
    }

    public Integer getScore() {
        return score;
    }
}
