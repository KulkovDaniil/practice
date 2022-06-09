package Llist;
import java.util.Scanner;
public class Main {
    static boolean a = true;
    public static void main(String[] args) {
        Llist list = new Llist();
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
                            public boolean exec() {
                                a=false;

                                return false;
                            }
                        },
                        new Command() {
                            @Override
                            public String name() {
                                return "prev";
                            }
                            @Override
                            public boolean exec() {
                                System.out.println(list.get(list.getSize()-1).toString());
                                return false;
                            }
                        },
                        new Command() {
                            @Override
                            public String name() {
                                return "history";
                            }
                            @Override
                            public boolean exec() {
                                for (int i = 0; i < list.getSize(); ++ i)
                                    System.out.println(list.get(i).toString());
                                return true;
                            }
                        },
                        new Command() {
                            @Override
                            public String name() {
                                return "size";
                            }
                            @Override
                            public boolean exec() {
                                System.out.println(list.getSize());
                                return false;
                            }
                        },
                        new Command() {
                            @Override
                            public String name() {
                                return "remove";
                            }
                            @Override
                            public boolean exec() {
                                list.remove(list.getSize()-1);
                                return false;
                            }
                        }
                };
        String inp;
        Scanner scanner = new Scanner(System.in);

        while (a) {
            inp = scanner.nextLine();
            for (Command command : commands) {
                if (inp.equals(command.name())) {
                    if (command.exec()) {
                    list.add(command.name());
                    }
                }
            }
        }
    }
}


