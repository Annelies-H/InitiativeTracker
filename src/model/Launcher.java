package model;

public class Launcher {

    public static void main(String[] args) {
        Die D20 = new Die(20);
        System.out.println(D20);
        System.out.println(D20.roll());
        System.out.println(D20.roll());
        System.out.println(D20.roll());

        Die die = new Die(3);
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
