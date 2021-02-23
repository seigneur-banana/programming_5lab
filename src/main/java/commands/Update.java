package commands;

import appliances.CommandHandler;
import appliances.StudyGroup;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Update implements Command{
    @Override
    public boolean execute(CommandHandler commandHandler, String... args) {
        if(args.length == 1){
            Integer id; boolean result = false;
            List<StudyGroup> list = commandHandler.sortGroups();
            try{
                id = Integer.parseInt(args[0]);
                if (id<0) return false;
            }
            catch (Exception e){
                System.out.println("В качестве аргумента не Integer");
                return false;
            }
            for(Iterator<StudyGroup> iterator = commandHandler.getGroups().iterator(); iterator.hasNext();){
                if(id.equals(iterator.next().getId())) {
                    iterator.remove();
                    Command cmd = commandHandler.getCommands().get("add");
                    result = cmd.execute(commandHandler, "studygroup");
                    list = commandHandler.sortGroups();
                    list.get(commandHandler.getGroups().size() - 1).setId(id);
                }
            }
            if (!result) System.out.println("Элемента с таким ID и не было :)");
            return true;
        }
        else return false;
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
