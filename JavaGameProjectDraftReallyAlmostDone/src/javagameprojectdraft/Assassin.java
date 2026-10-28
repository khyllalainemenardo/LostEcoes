package javagameprojectdraft;
import java.util.Random;
import java.util.Scanner;

public class Assassin extends Character {
    private Random random;
    private int multiplier;
    
    public Assassin(String name, int health, int mana, int speed, int multiplier) {
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
        int damage = random.nextInt(8,13) * multiplier;
        int dialogue = random.nextInt(2);
        if (dialogue == 0){
            System.out.println("[" + name + "]: Strike!");
            } else {
            System.out.println("[" + name + "]: Stab!");
        }
        System.out.println();
        System.out.println(name + " casts Basic Attack: Dagger Slash on " + target.getName());
        System.out.println(name + " dealt " + damage + " damage!");
        System.out.println("Gained 5 Mana.");
        addUltPoints();
        target.takeDamage(damage, DamageType.MELEE);
        mana += 5;
        System.out.println();
    }

    @Override
    public void skill(Enemy target) {
        if (mana >= 15) {
            Scanner scanner = new Scanner(System.in);
            int damage = random.nextInt(10,18) * multiplier;
            int finalizedDamage = 0;
            System.out.println(name + " casts Skill: Evasive Backslash on " + target.getName());
            
            System.out.println("[" + name + "]: Time to take my chances!");
            System.out.println();
            
            System.out.println("Press Enter to flip heads(x2 Damage) or tails(-3 Damage)");
            System.out.print("   Flip coin...");
            scanner.nextLine(); // Wait for user input
            System.out.println();
            
            int flip = random.nextInt(2); //0 for heads, 1 for tails
            if (flip == 0){
                finalizedDamage = damage*2;
                System.out.println("Heads!");
                System.out.print("   Press Enter to continue...");
                scanner.nextLine();
                System.out.println();
                int dialogue = random.nextInt(2);
                if (dialogue == 0){
                    System.out.println("[" + name + "]: Rend!");
                } else {
                    System.out.println("[" + name + "]: You didn't expect this!");
                }
            } else {
                finalizedDamage = damage-3;
                System.out.println("Tails!");
                System.out.print("   Press Enter to continue...");
                scanner.nextLine();
                System.out.println();
                int dialogue = random.nextInt(2);
                if (dialogue == 0){
                    System.out.println("[" + name + "]: Woops.");
                } else {
                    System.out.println("[" + name + "]: Messed up.");
                }
            }
            System.out.println();
            System.out.println(name + " dealt " + finalizedDamage + " damage!");
            addUltPoints();
            target.takeDamage(finalizedDamage, DamageType.MELEE);
            mana -= 10;
        } else {
            basicAttack(target);
        }
    }
    
    @Override
    public void ultSkill(Enemy target) {
        if (ult >= 50) {
            Scanner scanner = new Scanner(System.in);
            int damage = random.nextInt(35, 50) * multiplier;
            System.out.println(name + " casts Ultimate Skill: Accu-stab on " + target.getName());
            
            System.out.println("[" + name + "]: Finding your weak spot...");
            System.out.println();
            
            System.out.println("Press Enter to flip heads(x3 Damage) or tails(-3 Damage)");
            System.out.print("   Flip coin...");
            scanner.nextLine(); // Wait for user input
            System.out.println();
            int finalizedDamage = 0;
            int flip = random.nextInt(2); //0 for heads, 1 for tails
            if (flip == 0){
                finalizedDamage = damage*3;
                System.out.println("Heads!");
                System.out.print("   Press Enter to continue...");
                scanner.nextLine();
                System.out.println();
                int dialogue = random.nextInt(2);
                if (dialogue == 0){
                    System.out.println("[" + name + "]: I found it!");
                } else {
                    System.out.println("[" + name + "]: Assasinate!");
                }
            } else {
                finalizedDamage = damage-3;
                System.out.println("Tails!");
                System.out.print("   Press Enter to continue...");
                scanner.nextLine();
                System.out.println();
                int dialogue = random.nextInt(2);
                if (dialogue == 0){
                    System.out.println("[" + name + "]: I could not find it.");
                } else {
                    System.out.println("[" + name + "]: I failed.");
                }
            }
            System.out.println();
            System.out.println(name + " casts Ultimate Skill: Accu-stab on " + target.getName());
            System.out.println(name + " dealt " + finalizedDamage + " damage!");
            target.takeDamage(damage, DamageType.MELEE);
            ult -= 50;
            addUltPoints();
            System.out.println(name + " has " + ult + " Ult points left.");
        } else {
            basicAttack(target);
        }
    }
    
    @Override
    public String getClassName(){
        String className = "Assassin";
        return className;
    }
    
    @Override
    public String getBasicAtkDesc(){
        String firstLine = ("\u001B[33m[Dagger Slash]\u001B[0m");
        String secondLine = ("\n  Deals " + (8*multiplier) + "-" + (13*multiplier) + " melee damage.");
        String thirdline = "\n  Regains 5 mana while performing a dagger slash to a single enemy.";
        String info = firstLine + secondLine + thirdline;
        return info;
    }
    
    @Override
    public String getSkillDesc(){
        String firstLine = ("\u001B[33m[Evasive Backslash]\u001B[0m");
        String secondLine = ("\n  Deals " + (10*multiplier) + "-" + (18*multiplier) + " (additional x2 or -3) melee damage.");
        String thirdline = ("\n  Consumes 10 mana, then performs a toin coss. The side of the coin will perform the following:");
        String fourthLine = ("\n  Heads multiplies the damage by 2. Tails subtracts the damage by 3");
        String info = firstLine + secondLine + thirdline + fourthLine;
        return info;
    }
    
    @Override
    public String getUltSkillDesc(){
        String firstLine = ("\u001B[33m[Accu-stab]\u001B[0m");
        String secondLine = ("\n  Deals " + (35*multiplier) + "-" + (50*multiplier) + " (additional x3 or -3) melee damage.");
        String thirdline = ("\n  Consumes 50 ultimate points, then performs a toin coss. The side of the coin will perform the following:");
        String fourthLine = ("\n  Heads multiplies the ultimate damage by 3. Tails subtracts the ultimate damage by 3");
        String info = firstLine + secondLine + thirdline + fourthLine;
        return info;
    }
    
}