package com.company;

public class Main {

    private static final String ZERO = "sıfır";
    private static final String[] FIRST_DIGIT = {"", "bir ", "ik i", "üç ", "dört ", "beş ", "altı ", "yedi ", "sekiz ", "dokuz "};
    private static final String[] SECOND_DIGIT = {"", "on ", "yirmi ", "otuz ", "kırk ", "elli ", "altmış ", "yetmiş ", "seksen ", "doksan "};
    private static final String[] THIRD_DIGIT = {"", "yüz ", "iki yüz ", "üç yüz ", "dört yüz ", "beş yüz ", "altı yüz ", "yedi yüz ", "sekiz yüz ", "dokuz yüz "};
    private static final String[] SUFFIX = {"", "bin ", "milyon "};

    public static void main(String[] args) {

        String number = "100356900";
        System.out.println(operations(number));

    }

    private static String operations(String number) {

        if (Integer.parseInt((number)) == 0)
            return ZERO;

        else {

            int count = 0;
            StringBuilder result = new StringBuilder();

            for (int i = number.length(); i > 0; i -= 3) {
                if (i - 3 < 0) {
                    int temp = Integer.parseInt(number.substring(0, i));
                    result.insert(0, convertToWord(temp, count++));

                } else {
                    int temp = Integer.parseInt(number.substring(i - 3, i));
                    result.insert(0, convertToWord(temp, count++));
                }
            }
            return String.valueOf(result).trim();
        }
    }

    private static String convertToWord(int temp, int count) {

        if (temp == 0)
            return SUFFIX[temp];

        if (count == 1 && temp == 1)
            return SUFFIX[count];
        else
            return THIRD_DIGIT[temp / 100] + SECOND_DIGIT[temp % 100 / 10] + FIRST_DIGIT[temp % 10] + SUFFIX[count];

    }

}
