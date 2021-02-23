package commands;

import appliances.CommandHandler;

public class Update implements Command{
    @Override
    public boolean execute(CommandHandler commandHandler, String... args) {
        return false;
    }

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescription() {
        return " id {element} : обновить значение элемента коллекции, id которого равен заданному";
    }
}
