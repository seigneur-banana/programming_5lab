package Commands;
import Appliances.CommandHandler;
import java.util.Map;

public class Help implements Command{
    @Override
    public boolean execute(String... args) {
        if (args == null) {
            CommandHandler commandHandler = new CommandHandler();
            Map<String, Command> commands = commandHandler.getMap();
            for (Command cmd : commands.values()) {
                System.out.println(cmd.getName()  + cmd.getDescription());
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return " : вывести справку по доступным командам";
    }
}
