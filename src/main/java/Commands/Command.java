package Commands;
import Appliances.CommandHandler;

public interface Command {
    boolean execute(CommandHandler commandHandler, String... args);
    String getName();
    String getDescription();
}
