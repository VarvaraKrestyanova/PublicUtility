package com.book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution<result> {
    public static void main(String[] args) throws IOException {

        String bookData = String.valueOf(Files.readAllLines(Paths.get("src/main/resources/hospitalSketches.txt")));

        String withoutSymbols1 = bookData.replace(",", "");
        String withoutSymbols2 = withoutSymbols1.replace(".", "");
        String withoutSymbols3 = withoutSymbols2.replace(";", "");
        String withoutSymbols4 = withoutSymbols3.replace(":", "");
        String withoutSymbols5 = withoutSymbols4.replace("[", "");
        String withoutSymbols6 = withoutSymbols5.replace("]", "");
        String withoutSymbols7 = withoutSymbols6.replace("- ", "");
        String withoutSymbols = withoutSymbols7.replace("\"", "");
        //System.out.println(withoutSymbols);

        String[] bookDataSpliter = withoutSymbols.split(" ");

        String result = "";

        for (int i = 1; i < bookDataSpliter.length; i++) {
            for (int j = i + 1; j < bookDataSpliter.length; j++) {
                if (bookDataSpliter[i].equals(bookDataSpliter[j])) {
                    result = result + " " + bookDataSpliter[i];
                }
                if (j == bookDataSpliter.length - 1) {
                    result += ":";
                }
            }
        }

        String[] duplicatedValuesSpliter = result.split(":");

        //List<String> topDuplicates = Arrays.asList(args);
        StringBuilder topDuplicate = new StringBuilder();
        int count = 0;

        for (int i = 0; i < duplicatedValuesSpliter.length; i++) {                        //["having having"], [" "], [" and and and"],...
            String[] spliterBySpace = duplicatedValuesSpliter[i].split(" ");        //0 = ["having"], ["having"]; 1 = [""]; 2 = ["and"], ["and"], ["and"]; ...
            if (spliterBySpace.length > count) {
                count = spliterBySpace.length;
                topDuplicate.delete(0, topDuplicate.length() + 1);
                topDuplicate.append(spliterBySpace[1]);
            }
        }
        System.out.println("The most common word that occurs " + count + " times is " + "\"" + topDuplicate + "\"" + ".");

    }
}

