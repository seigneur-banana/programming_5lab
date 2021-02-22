package commands;

import appliances.CommandHandler;
import appliances.StudyGroup;

import java.util.Iterator;

public class Remove_by_id implements Command{
    @Override
    public boolean execute(CommandHandler commandHandler, String... args) {

        if(args.length == 1){
            Integer id; boolean result = false;
            try{
                id = Integer.parseInt(args[0]);
            }
            catch (Exception e){
                System.out.println("В качестве аргумента не Integer или <0");
                return false;
            }
            /*Set<StudyGroup> groups = commandHandler.getGroups();
            for(StudyGroup studyGroup : groups){
                if(studyGroup.getId() == id){
                    groups.remove(studyGroup);
                    result = true;
                }
            }*/
            for(Iterator<StudyGroup> iterator = commandHandler.getGroups().iterator(); iterator.hasNext();){
                if(id.equals(iterator.next().getId())) {
                    iterator.remove();
                    result = true;
                }
            }
            if (!result) System.out.println("Элемента с таким ID и не было :)");
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
