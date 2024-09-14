public class week_5_in_lab_1 {

    public static void main(String[] args) {
      // Create handlers
      InfoHandler infoHandler = new InfoHandler();
      DebugHandler debugHandler = new DebugHandler();
      ErrorHandler errorHandler = new ErrorHandler();
  
      // Set up chain of responsibility
      infoHandler.setNext(debugHandler);
      debugHandler.setNext(errorHandler);
  
      // Create logger
      Logger logger = new Logger();
  
      // Create and add log commands
      logger.addCommand(new LogCommand(LogLevel.INFO, "System started successfully", infoHandler));
      logger.addCommand(new LogCommand(LogLevel.DEBUG, "Connecting to database", debugHandler));
      logger.addCommand(new LogCommand(LogLevel.ERROR, "Failed to open file", errorHandler));
  
      // Process logs
      logger.processLogs();
    }
  }
  
  enum LogLevel {
    INFO, DEBUG, ERROR
  }
  
  interface Command {
    void execute();
  }
  
  class LogCommand implements Command {
    private LogLevel level;
    private String message;
    private LogHandler handler;
  
    public LogCommand(LogLevel level, String message, LogHandler handler) {
      this.level = level;
      this.message = message;
      this.handler = handler;
    }
  
    @Override
    public void execute() {
      handler.handle(level, message);
    }
  }
  
  abstract class LogHandler {
    protected LogHandler nextHandler;
  
    public void setNext(LogHandler nextHandler) {
      this.nextHandler = nextHandler;
    }
  
    public abstract void handle(LogLevel level, String message);
  }
  
  class InfoHandler extends LogHandler {
  
    @Override
    public void handle(LogLevel level, String message) {
      if (level == LogLevel.INFO) {
        System.out.println("[INFO] " + message);
      } else if (nextHandler != null) {
        nextHandler.handle(level, message);
      }
    }
  }
  
  class DebugHandler extends LogHandler {
  
    @Override
    public void handle(LogLevel level, String message) {
      if (level == LogLevel.DEBUG) {
        System.out.println("[DEBUG] " + message);
      } else if (nextHandler != null) {
        nextHandler.handle(level, message);
      }
    }
  }
  
  class ErrorHandler extends LogHandler {
  
    @Override
    public void handle(LogLevel level, String message) {
      if (level == LogLevel.ERROR) {
        System.out.println("[ERROR] " + message);
      } else if (nextHandler != null) {
        nextHandler.handle(level, message);
      }
    }
  }
  
  class Logger {
    private List<Command> commands;
    private Iterator<Command> iterator;
  
    public Logger() {
      commands = new ArrayList<>();
    }
  
    public void addCommand(Command command) {
      commands.add(command);
    }
  
    public void processLogs() {
      iterator = commands.iterator();
      while (iterator.hasNext()) {
        iterator.next().execute();
      }
      commands.clear();
    }
  }