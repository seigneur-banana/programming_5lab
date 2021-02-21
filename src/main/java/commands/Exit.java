package commands;

import appliances.CommandHandler;

public class Exit implements Command {
    @Override
    public boolean execute(CommandHandler commandHandler, String... args) {
        if (args == null) {
            System.out.println("До скорых встреч! ;)");
            System.out.println("Coordinates: " + commandHandler.getCoordinates());
            System.out.println("Locations: " + commandHandler.getLocations());
            System.out.println("Persons: " + commandHandler.getPersons());
            System.out.println("StudyGroups: " + commandHandler.getGroups());
            System.exit(0);
        }
        return true;
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return " : завершить программу (без сохранения в файл)";
    }
}
