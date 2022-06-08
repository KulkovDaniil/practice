import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WithId[] game =
                new WithId[]{
                        new Enemy(),
                        new Enemy(),
                        new Friend(),
                        new Enemy()
                };
        int hp = 3;
        int step = 0;
        Scanner scanner = new Scanner(System.in);
        while (hp > 0 && step < game.length) {
            System.out.println("засунуть в жопу палку? true/false");
            boolean inp = scanner.nextBoolean();
            if (inp) {
                hp -= game[step++].getId();
            } else {
                hp += game[step++].getId();
            }
        }
        if (hp <= 0)
            System.out.println("ты сдох, дибил");
        else
            System.out.println("блять, как ты это сделал");
    }
}