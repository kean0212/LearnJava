import java.util.logging.*;
import java.io.*;

class LoggingExceptionOne extends Exception {
    private static Logger logger = Logger.getLogger("LoggingExceptionOne");

    public LoggingExceptionOne() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

class LoggingExceptionTwo extends Exception {
    private static Logger logger = Logger.getLogger("LoggingExceptionTwo");

    public LoggingExceptionTwo() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

public class ExerciseSix {
    public static void main(String[] args) {
        try {
            throw new LoggingExceptionOne();
        } catch (LoggingExceptionOne exception) {
            System.err.println("Caught " + exception);
        }

        try {
            throw new LoggingExceptionTwo();
        } catch (LoggingExceptionTwo exception) {
            System.err.println("Caught " + exception);
        }
    }
}
