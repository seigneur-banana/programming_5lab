package Commands;
import java.util.Queue;
import Appliances.CommandHandler;

public class History implements Command{
    @Override
    public boolean execute(String... args) {
        if (args == null) {
            CommandHandler commandHandler = new CommandHandler();
            Queue queue = commandHandler.getQueue();
            for(Object object : queue) {
                System.out.println((String) object);
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return "history";
    }
    @Override
    public String getDescription() {
        return "вывести последние 8 команд (без их аргументов)";
    }
}
