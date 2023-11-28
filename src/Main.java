// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Player Hero_1 = new Player("Hero_1",1,20,10,3);
        Player Hero_2 = new Player("Hero_2",1 , 35 ,10,2);
        Sword Excalibur = new Sword(5,50);
        Sword  Dull_Blade = new Sword(1 ,10);
        Shield America_Shield = new Shield(10 , 20);

        Hero_1.showstate();
        Hero_2.showstate();
        Hero_1.equipSword(Dull_Blade);
        Hero_1.showstate();

        Hero_1.attack(Hero_2);

        Hero_2.showstate();

        Hero_2.heal();
        Hero_2.showstate();

        Hero_2.equipSword(Excalibur);
        Hero_1.equipShield(America_Shield);
        Hero_1.level_up();
        Dull_Blade.level_up();
        America_Shield.level_up();
        Hero_1.showstate();
        Hero_2.showstate();

        Hero_1.attack(Hero_2);
        Hero_2.attack(Hero_1);

        Hero_1.showstate();
        Hero_2.showstate();


    }
}