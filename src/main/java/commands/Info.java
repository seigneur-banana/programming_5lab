package commands;

import appliances.CommandHandler;

public class Info implements Command {
    @Override
    public boolean execute(CommandHandler commandHandler, String... args) {
        System.out.println("Дата инициализации "+commandHandler.getGroups().getClass()+" : "+commandHandler.getTime()+
                " ; Кол-во элементов : "+commandHandler.getGroups().size());
        return true;
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return " : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}

