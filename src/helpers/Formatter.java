package helpers;

public class Formatter {

    public static final String ansiEscape = "\u001B[";
    public static final String ansiColorReset = ansiEscape + "0m";
    public static final String ansiYellowFG = ansiEscape + "33m";
    public static final String ansiCyanFG = ansiEscape + "36m";
    public static final String ansiBlackBG = ansiEscape + "40m";

    public static void nL() { // it's a static method bc i don't want to instantiate any objects in order to use it
        System.out.println();
    }
}