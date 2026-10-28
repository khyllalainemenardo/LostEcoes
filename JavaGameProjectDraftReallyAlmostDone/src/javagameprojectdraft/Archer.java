package javagameprojectdraft;
import java.util.Random;

public class Archer extends Character {
    private Random random;
    private int multiplier;
    
    public Archer(String name, int health, int mana, int speed, int multiplier) {
        super(name, health, mana, speed, DamageType.RANGED);
        this.random = new Random();
        this.multiplier = multiplier;
    }
    
    //setter
    public void setRandom(Random random) {
        this.random = random;
    }
    
    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public void basicAttack(Enemy target) {
        int damage = random.nextInt(9,16) * multiplier;
        int dialogue = random.nextInt(2);
        if (dialogue == 0){
            System.out.println("[" + name + "]: Shoot!");
        } else {
            System.out.println("[" + name + "]: Pew!");
        }
        System.out.println();
        System.out.println(name + " casts Basic Attack: Normal Arrow on " + target.getName());
        System.out.println(name + " dealt " + damage + " damage!");
        System.out.println("Gained 5 Mana.");
        target.takeDamage(damage, DamageType.RANGED);
        mana += 5;
        System.out.println();
    }

    @Override
    public void skill(Enemy target) {
        if (mana >= 10) {
            int damage = random.nextInt(12,20) * multiplier;
            int dialogue = random.nextInt(2);
            if (dialogue == 0){
                System.out.println("[" + name + "]: Pierce!");
            } else {
                System.out.println("[" + name + "]: Penetrate!");
            }
            System.out.println();
            System.out.println(name + " casts Skill: Penetrating Arrow on " + target.getName());
            System.out.println(name + " dealt " + damage + " damage!");
            target.takeDamage(damage, DamageType.RANGED);
            mana -= 10;
        } else {
            basicAttack(target);
        }
    }
    
    @Override
    public void ultSkill(Enemy target) {
        if (ult >= 50) {
            int damage = random.nextInt(45, 55) * multiplier;
            int dialogue = random.nextInt(2);
            if (dialogue == 0){
                System.out.println("[" + name + "]: I see through you!");
            } else {
                System.out.println("[" + name + "]: Target locked.");
            }
            System.out.println();
            System.out.println(name + " casts Ultimate Skill: Windborne Burst on " + target.getName());
            System.out.println(name + " dealt " + damage + " damage!");
            target.takeDamage(damage, DamageType.RANGED);
            ult -= 50;
            addUltPoints();
            System.out.println(name + " has " + ult + " Ult points left.");
        } else {
            basicAttack(target);
        }
    }
    
    @Override
    public String getClassName(){
        String className = "Archer";
        return className;
    }
    
    @Override
    public String getBasicAtkDesc(){
        String firstLine = ("\u001B[33m[Normal Arrow]\u001B[0m");
        String secondLine = ("\n  Deals " + (9*multiplier) + "-" + (16*multiplier) + " ranged damage.");
        String thirdline = "\n  Regains 5 mana while shooting a normal arrow to the enemy.";
        String info = firstLine + secondLine + thirdline;
        return info;
    }
    
    @Override
    public String getSkillDesc(){
        String firstLine = ("\u001B[33m[Penetrating Arrow]\u001B[0m");
        String secondLine = ("\n  Deals " + (12*multiplier) + "-" + (20*multiplier) + " ranged damage.");
        String thirdline = ("\n  Consumes 10 mana while shooting a penetrating arrow to the enemy.");
        String info = firstLine + secondLine + thirdline;
        return info;
    }
    
    @Override
    public String getUltSkillDesc(){
        String firstLine = ("\u001B[33m[Windborne Burst]\u001B[0m");
        String secondLine = ("\n  Deals " + (45*multiplier) + "-" + (55*multiplier) + " ranged damage.");
        String thirdline = ("\n  Consumes 50 ultimate points while shooting a powerful arrow infused by the winds.");
        String info = firstLine + secondLine + thirdline;
        return info;
    }
}
