package com.techtamasha.techtamasha.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SimilarityUtil {

    public static double calculate(String a, String b) {
        Set<String> set1 = new HashSet<>(Arrays.asList(a.toLowerCase().split(" ")));
        Set<String> set2 = new HashSet<>(Arrays.asList(b.toLowerCase().split(" ")));

        int match = 0;

        for (String word : set1) {
            if (set2.contains(word)) match++;
        }

        return (double) match / set1.size() * 100;
    }
}