package com.String;

public class Extrach {


        public static void main(String[] args) {
            String str = "2shubham pawa6r";
            String result = extractAlphabets(str);
            System.out.println(result);
        }

        private static String extractAlphabets(String input) {
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (Character.isLetter(ch) || Character.isWhitespace(ch)) {
                    output.append(ch);
                }
            }

            return output.toString();
        }
    }

