package util;

public class UserValidations {

    public static boolean isIdValid(int id) {
        return id > 0 && id < 100;
    }

    public static boolean isUsernameValid(String username) {
        return isLengthHigherThanThreeAndLowerThanFive(username);
    }

    public static boolean isCPFValid(String cpf) {
        return isLengthHigherThanThreeAndLowerThanFive(cpf);
    }

    private static boolean isLengthHigherThanThreeAndLowerThanFive(String word) {
        return word.length() > 3 && word.length() < 15;
    }
}
