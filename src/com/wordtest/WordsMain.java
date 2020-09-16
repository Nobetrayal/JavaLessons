package com.wordtest;

import java.util.Arrays;

public class WordsMain {

    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis());
        System.out.println(getResult("привет", "прикол"));

        System.out.println(getResult("ааббдд", "ддббаа"));
        System.out.println(getResult("абаб", "ааах"));
        System.out.println(getResult("абыр", "рыба"));
        System.out.println(System.currentTimeMillis());

    }

    private static int getResult(String word1, String word2) {
        
        if (word1.length() != word2.length()) {

            return 0;

        }

        if (word1.equals(word2)) {
            return 1;
        }
        int wordLength = word1.length();
        char[] fromWord1 = word1.toCharArray();
        char[] fromWord2 = word2.toCharArray();

        char[] newWord1 = new char[wordLength];

        System.arraycopy(fromWord1, 0, newWord1, 0, wordLength);

        boolean[] changed = new boolean[wordLength];

        for (int i = 0; i < wordLength; i++) {

            if (fromWord1[i] != fromWord2[i]) {

                for (int j = i; j < wordLength; j++) {

                    if (fromWord1[j] == fromWord1[i]) {

                        if (!changed[j]
                                && fromWord2[j] == fromWord2[i]) {

                            newWord1[j] = fromWord2[i];

                        }
                        changed[j] = true;
                    }

                }

            }

        }

        word1 = Arrays.toString(newWord1);
        word2 = Arrays.toString(fromWord2);
        System.out.println(word1);
        System.out.println(word2);

        if (word1.equals(word2)) {
            return 1;
        } else {
            return 0;
        }



    }

}


