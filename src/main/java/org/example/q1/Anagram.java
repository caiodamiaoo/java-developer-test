package org.example.q1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Anagram {


    public static List<String> getAnagrams(String letters) {
        List<String> anagrams = new ArrayList<>();

        if (letters == null || letters.isEmpty()) {
            throw new IllegalArgumentException("A entrada não pode ser nula ou vazia.");
        }

        if (!letters.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("A entrada deve conter apenas letras (a-z, A-Z).");
        }

        Set<Character> uniqueChars = new HashSet<>();
        for (char c : letters.toCharArray()) {
            if (!uniqueChars.add(c)) {
                throw new IllegalArgumentException("Todas as letras devem ser distintas.");
            }
        }

        if (letters.length() == 1) {
            anagrams.add(letters);
            return anagrams;
        }

        List<Character> lettersList = letters.chars()
                .mapToObj(c -> (char) c)
                .toList();

        for (Character letter : lettersList) {
            char atual = letter;

            String restantes = lettersList.stream()
                    .filter(l -> l != atual)
                    .map(String::valueOf)
                    .collect(Collectors.joining());

            List<String> anagramasRestantes = getAnagrams(restantes);

            for (String parcial : anagramasRestantes) {
                anagrams.add(atual + parcial);
            }
        }

        return anagrams;
    }

    public static void main(String[] args) {
        String input = "abcd";

        List<String> anagramas = getAnagrams(input);
        for (String a : anagramas) {
            System.out.println(a);
        }
    }
}