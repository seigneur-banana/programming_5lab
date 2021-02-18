package Commands;

import java.util.Scanner;

public class Add implements Command {
    @Override
    public boolean execute(String... args) {
        if (args.length != 1) return false;
        switch (args[0]) {
            case "Coordinates":
            {
                Double Y; double x;
                System.out.println("Чтобы добавить элемент в Coordinates, введите такие поля, как (Обязательные поля помечены *):" +
                        "\n1*. Координата Y (Double Значение поля должно быть больше -748)\n2. Координата Х (double).");
                Scanner scanner = new Scanner(System.in);

                do{
                    try {
                        System.out.print("Введите Y> ");
                        Y = Double.parseDouble(scanner.nextLine());
                        //Y = scanner.nextDouble();
                        if (Y < -748){
                            System.out.println("Введено неверное значение для Y (меньше -748)");
                        }
                        else break;
                    }
                    catch (Exception e){
                        System.out.println("Неверный формат ввода, пожалуйста, попробуйте снова.");
                    }
                }while(true);

                try {
                    System.out.print("Введите X> ");
                    x = Double.parseDouble(scanner.nextLine());
                    //x = scanner.nextDouble();
                }
                catch (Exception e){
                    x = 0;
                }
                System.out.println("Y = " + Y.toString() + "\nX = " + x);
            };break;

            case "Location":
            {
                System.out.println("add Location");
            }break;

            case "Person":
            {
                System.out.println("add Person");
            }break;

            case "StudyGroup":
            {
                System.out.println("add StudyGroup");
            }break;

            default:{
                System.out.println("Аргумент не распознан, попробуйте снова :) ");
            }break;
        }

        return true;
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return " {element} : добавить новый элемент в коллекцию";
    }
}
