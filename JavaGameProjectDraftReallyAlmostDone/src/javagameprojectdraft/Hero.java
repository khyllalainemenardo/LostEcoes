package javagameprojectdraft;
import java.util.Random;

public class Hero extends Character {
    private Random random;
    private int multiplier;
    
    public Hero(String name, int health, int mana, int speed, int multiplier) {
        super(name, health, mana, speed, DamageType.MELEE);
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
        int damage = random.nextInt(10,15) * multiplier;
        int dialogue = random.nextInt(3);
        if (dialogue == 0){
            System.out.println("[" + name + "]: Slash!");
        } else if (dialogue == 1) {
            System.out.println("[" + name + "]: Forte!");
        } else {
            System.out.println("[" + name + "]: Take This!");
        }
        System.out.println();
        System.out.println(name + " casts Basic Attack: Forte Slash on " + target.getName());
        System.out.println(name + " dealt " + damage + " damage!");
        System.out.println("Gained 5 Mana.");
        addUltPoints();
        target.takeDamage(damage, DamageType.MELEE);
        mana += 5;
        System.out.println();
    }
    
    @Override
    public void skill(Enemy target) {
        if (mana >= 10) {
            int damage = random.nextInt(15,18) * multiplier;
            int dialogue = random.nextInt(3);
            if (dialogue == 0){
                System.out.println("[" + name + "]: With form, thurst!");
            } else if (dialogue == 1) {
                System.out.println("[" + name + "]: Step, thurst!");
            } else {
                System.out.println("[" + name + "]: Epee!");
            }
            System.out.println();
            System.out.println(name + " casts Skill: Epee Thrust on " + target.getName());
            System.out.println(name + " dealt " + damage + " damage!");
            addUltPoints();
            target.takeDamage(damage, DamageType.MELEE);
            mana -= 10;
        } else {
            basicAttack(target);
        }
    }
    
    @Override
    public void ultSkill(Enemy target) {
        if (ult >= 35) {  // Check if enough Ult points are available
            int damage = random.nextInt(35, 40) * multiplier;
            int dialogue = random.nextInt(3);
            if (dialogue == 0){
                System.out.println("[" + name + "]: Smite!");
            } else if (dialogue == 1) {
                System.out.println("[" + name + "]: Holy Light!");
            } else {
                System.out.println("[" + name + "]: Take This!");
            }
            System.out.println();
            System.out.println(name + " casts Ultimate Skill: Glory Slash on " + target.getName());
            System.out.println(name + " dealt " + damage + " damage!");
            target.takeDamage(damage, DamageType.MELEE);
            ult -= 35;
            addUltPoints();
            System.out.println(name + " has " + ult + " Ult points left.");
        } else {
            basicAttack(target);
        }
    }
    
    @Override
    public String getClassName(){
        String className = "Hero";
        return className;
    }
    
    @Override
    public String getBasicAtkDesc(){
        String firstLine = ("\u001B[33m[Forte Slash]\u001B[0m");
        String secondLine = ("\n  Deals " + (10*multiplier) + "-" + (15*multiplier) + " melee damage.");
        String thirdline = "\n  Regains 5 mana while performing a sword slash to a single enemy.";
        String info = firstLine + secondLine + thirdline;
        return info;
    }
    
    @Override
    public String getSkillDesc(){
        String firstLine = ("\u001B[33m[Epee Thrust]\u001B[0m");
        String secondLine = ("\n  Deals " + (15*multiplier) + "-" + (18*multiplier) + " melee damage.");
        String thirdline = ("\n  Consumes 10 mana while performing a powerful thrust.");
        String info = firstLine + secondLine + thirdline;
        return info;
    }
    
    @Override
    public String getUltSkillDesc(){
        String firstLine = ("\u001B[33m[Glory Slash]\u001B[0m");
        String secondLine = ("\n  Deals " + (35*multiplier) + "-" + (40*multiplier) + " melee damage.");
        String thirdline = ("\n  Consumes 35 ultimate points while performing a slash infused with holy melee light");
        String info = firstLine + secondLine + thirdline;
        return info;
    }
}

