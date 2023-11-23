public class Player {
    private final String name;
    private int level;
    private double max_hp,hp,max_mana,mana,damage,defense,max_speed;

    private final double d,s,r;

    private Shield e_shield;
    private Sword e_sword;



    public Player(String name,int level,double d , double s, double r){
        this.name = name;
        this.level = level;
        this.d = d ;
        this.s = s ;
        this.r = r ;
        hp = 100+10*(level-1);
        mana = 50+2*(level-1);
        e_sword = null;
        e_shield = null;

    }

    public void level_up(){
        level++;
    }

    private void update_state(){
        max_hp = 100+10*(level-1);
        max_mana = 50+2*(level-1);
        max_speed =  r + (r * (0.1+0.03*(level-1)));
        damage = d * (1 + 0.1 * (level - 1));
        defense = s * (1 + 0.05 * (level - 1));
        if(e_sword != null){
            damage = damage+e_sword.getdamageSword();
            max_speed -= (0.1+0.04*e_sword.getLevelSword());
        }
        if(e_shield != null){
            defense = defense+e_shield.getdefenseShield();
            max_speed -= (0.1+0.08*e_shield.getLevelShield());
        }
        if(max_speed < 0 ){
            max_speed = 0;
        }


    }

    public void showstate(){
        update_state();
        System.out.println("|----------------------------|");
        System.out.println("    Name = " + name);
        System.out.println("    Max Hp = " + max_hp);
        System.out.println("    Hp = " + hp);
        System.out.println("    Max Mana = " + max_mana);
        System.out.println("    Mana = " + mana);
        System.out.println("    Base Speed = " + r);
        System.out.println("    Max Speed = " + max_speed);
        System.out.println("    Damage = " + damage);
        System.out.println("    Defense = " + defense);
        if(e_sword != null){
            System.out.println("    equipSword");
        }
        if(e_shield != null){
            System.out.println("    equipShield");
        }
        System.out.println("|----------------------------|");
        System.out.println(" ");
    }

    public void equipSword(Sword sword){
        unequipSword();
        e_sword = sword;
    }

    public void unequipSword(){
        e_sword = null;
    }

    public void equipShield(Shield Shield){
        unequipShield();
        e_shield = Shield;
    }

    public void unequipShield(){
        e_shield = null;
    }

    public void attack(Player p){
        p.Takedamage(damage);
    }

    private void Takedamage(double d){
        double da = defense - d;
        if(da > 0){
            da = 0;
        }

        hp += da;
        if(hp  < 0){
            hp = 0;
        }
    }

    public void heal() {
        double h = max_mana/10;
        mana = mana - h;
        hp += h;
        if(hp > max_hp){
            hp = max_hp;
        }
    }


}
