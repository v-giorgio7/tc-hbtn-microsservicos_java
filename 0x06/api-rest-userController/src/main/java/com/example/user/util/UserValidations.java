package com.example.user.util;

public class UserValidations {

    public static boolean isIdValid(int id) {
        return id > 0 && id < 100;
    }

    public static boolean isUsernameValid(String username) {
        return isLengthHigherThanThreeAndLowerThanFifteen(username);
    }

    public static boolean isCPFValid(String cpf) {
        return isLengthHigherThanThreeAndLowerThanFifteen(cpf);
    }

    private static boolean isLengthHigherThanThreeAndLowerThanFifteen(String word) {
        return word.length() > 3 && word.length() < 15;
    }
}
