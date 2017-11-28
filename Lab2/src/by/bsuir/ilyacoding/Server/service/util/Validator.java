package by.bsuir.ilyacoding.Server.service.util;

public class Validator {

    public static boolean isLoginValid(String login) {
        return login.matches("[a-zA-Z_0-9]+");
    }

    public static boolean isPasswordValid(String password) {
        return password.matches("[a-zA-Z_0-9]+");
    }

    public static boolean isTitleValid(String title) {
        return title.matches("[a-zA-Z0-9\\s,.\\-+#]+");
    }

    public static boolean isAuthorValid(String author) {
        return author.matches("[a-zA-Z\\-\\s.,]+");
    }
}
