package javagameprojectdraft;
import java.util.Random;
import java.util.Scanner;

public class Mage extends Character {
    private Random random;
    private int multiplier;
    
    public Mage(String name, int health, int mana, int speed, int multiplier) {
        super(name, health, mana, speed, DamageType.MAGIC);
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
        int damage = random.nextInt(8,17) * multiplier;
        int dialogue = random.nextInt(3);
        if (dialogue == 0){
            System.out.println("[" + name + "]: A simple spell for you.");
        } else if (dialogue == 1) {
            System.out.println("[" + name + "]: Fire Ball!");
        } else {
            System.out.println("[" + name + "]: Hyah!");
        }
        System.out.println();
        System.out.println(name + " casts Basic Attack: Fire Ball on " + target.getName());
        System.out.println(name + " dealt " + damage + " damage!");
        System.out.println("Gained 6 Mana.");
        addUltPoints();
        target.takeDamage(damage, DamageType.MAGIC);
        mana += 6;
        System.out.println();
    }

    @Override
    public void skill(Enemy target) {
        if (mana >= 10) {
            Scanner scanner = new Scanner(System.in);
            int damage = random.nextInt(13,18) * multiplier;
            int minorDamage;
            int totalMinorDamage;
            
            int dialogue = random.nextInt(2);
            if (dialogue == 0){
                System.out.println("[" + name + "]: Electrify!");
            } else if (dialogue == 1) {
                System.out.println("[" + name + "]: Take this!");
            } else {
                System.out.println("[" + name + "]: Lightning Bolt!");
            }
            System.out.println();
            System.out.println(name + " casts Skill: Lightning Bolt on " + target.getName());
            System.out.println(name + " dealt " + damage + " damage initial!");
            target.takeDamage(damage, DamageType.MAGIC);
            System.out.println();
            
            dialogue = random.nextInt(2);
            if (dialogue == 0){
                System.out.println("[" + name + "]: Chain!");
            } else {
                System.out.println("[" + name + "]: Static!");
            }
            System.out.println();
            
            System.out.println("   Press Enter start triggering...");
            scanner.nextLine(); // Wait for user input
            int triggerCount = random.nextInt(3) + 1;
            for (int i = 0; i < triggerCount; i++){
                minorDamage = random.nextInt(1,4) * multiplier;
                target.takeDamage(minorDamage, DamageType.MAGIC);
                System.out.println("Dealt " + minorDamage + " minor damage!");
            }
            mana -= 10;
        } else {
            basicAttack(target);
        }
    }
    
    @Override
    public void ultSkill(Enemy target) {
        if (ult >= 50) {
            int damage = random.nextInt(40, 50) * multiplier;
            int dialogue = random.nextInt(2);
            if (dialogue == 0){
                System.out.println("[" + name + "]: Witness arcane wisdom!");
            } else {
                System.out.println("[" + name + "]: In the name of frost, I beseech thee!");
            }
            System.out.println();
            System.out.println(name + " casts Ultimate Skill: Ice Missile on " + target.getName());
            System.out.println(name + " dealt " + damage + " damage!");
            target.takeDamage(damage, DamageType.MAGIC);
            ult -= 50;
            addUltPoints();
            System.out.println(name + " has " + ult + " Ult points left.");
        } else {
            basicAttack(target);
        }
    }
    
    @Override
    public String getClassName(){
        String className = "Mage";
        return className;
    }
    
    @Override
    public String getBasicAtkDesc(){
        String firstLine = ("\u001B[33m[Fire Ball]\u001B[0m");
        String secondLine = ("\n  Deals " + (8*multiplier) + "-" + (17*multiplier) + " magic damage.");
        String thirdline = "\n  Regains 5 mana while casting a fire ball to a single enemy.";
        String info = firstLine + secondLine + thirdline;
        return info;
    }
    
    @Override
    public String getSkillDesc(){
        String firstLine = ("\u001B[33m[Lightning Bolt]\u001B[0m");
        String secondLine = ("\n  Deals " + (10*multiplier) + "-" + (18*multiplier) + " magic damage (additional " + (2*multiplier) + "-" + (5*multiplier) + " repeated minor magic damage.)");
        String thirdline = ("\n  Consumes 10 mana while casting a lightning bolt.\n  It then triggers an arc bolt in set amount of times.");
        String info = firstLine + secondLine + thirdline;
        return info;
    }
    
    @Override
    public String getUltSkillDesc(){
        String firstLine = ("\u001B[33m[Ice Missile]\u001B[0m");
        String secondLine = ("\n  Deals " + (40*multiplier) + "-" + (50*multiplier) + " magic damage.");
        String thirdline = ("\n  Consumes 50 ultimate points while casting a large ice projectile to the enemy.");
        String info = firstLine + secondLine + thirdline;
        return info;
    }
}

