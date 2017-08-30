package com.plumbee.codetest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * 
 * @author miguelgonzalez776
 *
 */
public class SubmissionTest {
    WordDictionary dictionary;
    AnagramGame service;

    /**
     * 
     */
    public SubmissionTest() {
        dictionary = new WordDictionaryImpl();
    }
	/**
	 * 
	 * @throws Exception
	 */
    @Before
    public void setUp() throws Exception {
        service = new AnagramGameImpl("areallylongword", dictionary);
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testSubmission() throws Exception {
        assertEquals(2, service.submitWord("1", "no"));
        assertEquals(4, service.submitWord("2", "grow"));
        assertEquals(0, service.submitWord("3", "bold"));
        assertEquals(0, service.submitWord("4", "glly"));
        assertEquals(6, service.submitWord("5", "woolly"));
        assertEquals(0, service.submitWord("6", "adder"));
    }
}
