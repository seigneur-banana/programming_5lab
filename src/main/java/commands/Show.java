package commands;

import appliances.CommandHandler;

public class Show implements Command{
    @Override
    public boolean execute(CommandHandler commandHandler, String... args) {
        System.out.println("StudyGroups: " + commandHandler.getGroups());
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
