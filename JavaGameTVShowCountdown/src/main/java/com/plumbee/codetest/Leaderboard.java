package com.plumbee.codetest;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

/** 
 * 
 * @author miguelgonzalez776
 *
 */
public class Leaderboard {
	
    private final Vector<LeaderboardEntry> entries = new Vector<LeaderboardEntry>();
    private final Comparator<LeaderboardEntry> scoreComparator = Collections.<LeaderboardEntry>reverseOrder(
            new Comparator<LeaderboardEntry>() {
                @Override
                public int compare(LeaderboardEntry o1, LeaderboardEntry o2) {
                    if (o1 == null && o2 == null) {
                        return 0;
                    } else if (o2 == null) {
                        return 1;
                    } else if (o1 == null) {
                        return -1;
                    } else {
                        return o1.getScore().compareTo(o2.getScore());
                    }
                }
            });
 
     /**
      * 
      * @param username
      * @param word
      * @param score
      */
    protected synchronized void insertEntry(String username, String word, int score) {
        LeaderboardEntry newEntry = new LeaderboardEntry(username, word, score);
        if (entries.isEmpty()) {
            entries.add(newEntry);
            return;
        }
        LeaderboardEntry lastEntry = entries.lastElement();
        if (lastEntry != null && lastEntry.getScore() >= score) {
            return;
        }
        entries.add(newEntry);
        Collections.sort(entries, scoreComparator);
        entries.setSize(10);
    }

    /**
     * 
     * @param position
     * @return
     */
    public synchronized LeaderboardEntry getEntryAtPosition(int position) {
       return entries.get(position);
    }
}
