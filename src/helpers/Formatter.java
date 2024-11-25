package helpers;

public class Formatter {

    public static final String reset = "0";
    public static final String yellowFG = "33";
    public static final String cyanFG = "36";
    public static final String blackBG = "40";

    public static String ansiColor(String code) { // static method: you don't have to instantiate any objects in order to use it
        return new StringBuilder()
                .append("\u001B[")
                .append(code)
                .append("m")
                .toString();
    }

    public static String ansiColor(String code, String code2) {
        return new StringBuilder()
                .append("\u001B[")
                .append(code)
                .append(";")
                .append(code2)
                .append("m")
                .toString();
    }
}