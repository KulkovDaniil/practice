package Main.java.Test;
import java.util.Scanner;
public class Main {
    static boolean a = true;
    public static void main(String[] args) {
        Command[] commands =
                new Command[]{
                        new GetDate(),
                        new GetTime(),
                        new Command() {
                            @Override
                            public String name() {
                                return "exit";
                            }
                            @Override
                            public void exec() {
                                a=false;

                            }
                        },
                };
        String inp;
        Scanner scanner = new Scanner(System.in);
        while (a) {

            inp = scanner.nextLine();
            for (Command command : commands) {
                if (inp.equals(command.name())) {
                    command.exec();
                }
            }
        }
    }
}


