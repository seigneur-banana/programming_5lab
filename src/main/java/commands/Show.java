package commands;

import appliances.CommandHandler;
import appliances.StudyGroup;
import java.util.List;

public class Show implements Command{
    @Override
    public boolean execute(CommandHandler commandHandler, String... args) {
        List<StudyGroup> list = commandHandler.sortGroups();
        System.out.println("StudyGroups: " + list);
        return true;
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return " : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
