package model;

public class Launcher {

    public static void main(String[] args) {
        Die d20 = new Die(20);
        System.out.println(d20);
        System.out.println(d20.roll());
        System.out.println(d20.roll());
        System.out.println(d20.roll());

        Die die = new Die(0);
        System.out.println(die);
        System.out.println(die.roll());
        System.out.println(die.roll());
        System.out.println(die.roll());
        System.out.println(die.roll());
        System.out.println(die.roll());
        System.out.println(die.roll());
        System.out.println(die.roll());
        System.out.println(die.roll());
        System.out.println(die.roll());
    }
}
