package Commands;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class History implements Command{
    private Queue queue;
    public History(){
        queue = new LinkedList();
    }

    @Override
    public boolean execute(String... args) {
        if (args == null) {
            for(Object object : queue) {
                System.out.println((String) object);
            }
        }
        /*if (args == null) {
            Iterator iterator = queue.iterator();
            while (iterator.hasNext()) {
                System.out.println((String) iterator.next());
            }
        }*/
        return true;
    }

    @Override
    public String getName() {
        return "history";
    }
    @Override
    public String getDescription() {
        return "вывести последние 8 команд (без их аргументов)";
    }
    public int getSizeQueue(){
        return queue.size();
    }
    public void removeQueue(){
        queue.remove();
    }
    public void addQueue(String str){
        queue.add(str);
    }
}
