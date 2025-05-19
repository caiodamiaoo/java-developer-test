package org.example.q1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @Test
    void testInputWithTwoLetters() {
        List<String> result = Anagram.getAnagrams("ab");
        assertEquals(2, result.size());
        assertTrue(result.contains("ab"));
        assertTrue(result.contains("ba"));
    }

    @Test
    void testInputWithFourLetters() {
        List<String> result = Anagram.getAnagrams("abcd");
        assertEquals(24, result.size()); // 4! = 24
    }

    @Test
    void testSingleLetter() {
        List<String> result = Anagram.getAnagrams("x");
        assertEquals(1, result.size());
        assertEquals("x", result.get(0));
    }

    @Test
    void testEmptyInputThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Anagram.getAnagrams("");
        });
        assertEquals("A entrada não pode ser nula ou vazia.", exception.getMessage());
    }

    @Test
    void testInputWithInvalidCharactersThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Anagram.getAnagrams("a1b2");
        });
        assertEquals("A entrada deve conter apenas letras (a-z, A-Z).", exception.getMessage());
    }

    @Test
    void testNullInputThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Anagram.getAnagrams(null);
        });
        assertEquals("A entrada não pode ser nula ou vazia.", exception.getMessage());
    }
}