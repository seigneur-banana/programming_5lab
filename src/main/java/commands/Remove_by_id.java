package commands;

import appliances.CommandHandler;

public class Remove_by_id implements Command{
    @Override
    public boolean execute(CommandHandler commandHandler, String... args) {
        if(args.length == 1){
            System.out.println("StudyGroups: " + commandHandler.getGroups());


            return true;
        }
        else return false;
    }

    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public String getDescription() {
        return " id : удалить элемент из коллекции по его id";
    }
}
