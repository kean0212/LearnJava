import java.util.*;
import java.util.logging.*;
import java.io.*;

public class ExerciseSeven {
    private static Logger logger = Logger.getLogger("ExerciseSeven");

    static void logException(Exception exception) {
        StringWriter trace = new StringWriter();
        exception.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args) {
        int[] array = new int[5];
        try {
            System.out.println(array[6]);
        } catch (ArrayIndexOutOfBoundsException e) {
            logException(e);
        }
    }
}