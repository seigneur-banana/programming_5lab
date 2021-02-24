package commands;

import appliances.CommandHandler;
import appliances.StudyGroup;

import java.util.Iterator;

public class Remove_greater implements Command {
    @Override
    public boolean execute(CommandHandler commandHandler, String... args) {
        if (args != null) {
            if (args.length != 1) return false;
            Integer id;
            boolean result = false;
            try {
                id = Integer.parseInt(args[0]);
                if (id < 0) return false;
            } catch (Exception e) {
                System.out.println("В качестве аргумента не Integer или <0");
                return false;
            }

            for (Iterator<StudyGroup> iterator = commandHandler.getGroups().iterator(); iterator.hasNext(); ) {
                if (id < iterator.next().getId()) {
                    iterator.remove();
                    result = true;
                }
            }
            if (!result) System.out.println("Элементов больеш такого ID и не было :)");
            return true;
        } else return false;
    }

    @Override
    public String getName() {
        return "remove_greater";
    }

    @Override
    public String getDescription() {
        return " {element} : удалить из коллекции все элементы, превышающие заданный";
    }
}
