package com.plumbee.codetest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Vector;

/**
 * 
 * @author miguelgonzalez776
 *
 */
public class WordDictionaryImpl implements WordDictionary {

    Vector<String> v = new Vector<String>();

    /**
     * 
     */
    public WordDictionaryImpl() {
      
    	try {
   	
            //Load the file.txt
			 InputStream inputStream = this.getClass().getResourceAsStream("/wordlist.txt");
	         BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
	         
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                v.add(inputLine);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     */
    @Override
    public boolean contains(String word) {
        return v.contains(word);
    }
    
    /**
     * 
     */
    @Override
    public int size() {
        return v.size();
    }
}
