package javagameprojectdraft;
import java.util.Random;

public class MeleeWeakEnemy extends Enemy {
    private Random random;
    
    private String basicAttackName;
    private String skillName;
    private int basRandMin;
    private int basRandMax;
    private int skillRandMin;
    private int skillRandMax;
    
    public MeleeWeakEnemy(String name, int health, int speed, String basicAttackName, int basRandMin, int basRandMax, String skillName, int skillRandMin, int skillRandMax) {
        super(name, health, speed, DamageType.MELEE);
        this.basicAttackName = basicAttackName;
        this.basRandMin = basRandMin;
        this.basRandMax = basRandMax;
        this.skillName = skillName;
        this.skillRandMin = skillRandMin;
        this.skillRandMax = skillRandMax;
        this.random = new Random();
        
    }
    
    // Setters
    public void setRandom(Random random) {
        this.random = random;
    }

    public void setBasicAttackName(String basicAttackName) {
        this.basicAttackName = basicAttackName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public void setBasRandMin(int basRandMin) {
        this.basRandMin = basRandMin;
    }

    public void setBasRandMax(int basRandMax) {
        this.basRandMax = basRandMax;
    }

    public void setSkillRandMin(int skillRandMin) {
        this.skillRandMin = skillRandMin;
    }

    public void setSkillRandMax(int skillRandMax) {
        this.skillRandMax = skillRandMax;
    }

    @Override
    public void basicAttack(Character target) {
        int damage = random.nextInt(basRandMin, basRandMax);
        System.out.println(name + " uses Basic Attack: " + basicAttackName + " on " + target.getName());
        System.out.println(name + " dealt " + damage + " damage! ");
        target.takeDamage(damage);
    }

    @Override
    public void skill(Character target) {
        int damage = random.nextInt(skillRandMin, skillRandMax);
        System.out.println(name + " uses Skill: " + skillName + " on " + target.getName());
        System.out.println(name + " dealt " + damage + " damage! ");
        target.takeDamage(damage);
    }
}

