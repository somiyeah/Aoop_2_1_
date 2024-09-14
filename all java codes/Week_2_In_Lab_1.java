class Logger {
    private static Logger instance;
    private Logger() {}
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

public class Week_2_In_Lab_1 {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Logging system initialized.");
    }
}
