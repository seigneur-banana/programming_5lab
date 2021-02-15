package Commands;

public class Exit implements Command {
    @Override
    public boolean execute(String... args) {
        if (args == null) {
            System.out.println("До скорых встреч! ;)");
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
        return "завершить программу (без сохранения в файл)";
    }
}
