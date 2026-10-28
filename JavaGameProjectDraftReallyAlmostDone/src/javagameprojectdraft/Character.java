package javagameprojectdraft;

public abstract class Character {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int mana;
    protected int speed;
    protected int ult;
    protected DamageType damageType;

    public abstract void basicAttack(Enemy target);
    public abstract void skill(Enemy target);
    public abstract void ultSkill(Enemy target);
    public abstract String getBasicAtkDesc();
    public abstract String getSkillDesc();
    public abstract String getUltSkillDesc();
    public abstract String getClassName();
    

    public Character(String name, int health, int mana, int speed, DamageType damageType) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.mana = mana;
        this.speed = speed;
        this.damageType = damageType;
        this.ult = 0;
    }
    
    // Mga Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
    
    public void setUlt(int ult) {
        this.ult = ult;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    // Mga Getter
    public int getUlt() {
        return ult;
    }
    
    public int getSpeed() {
        return this.speed;
    }

    public String getName() {
        return this.name;
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public int getMaxHealth() {
        return this.maxHealth;
    }
    
    public boolean isAlive() {
        return health > 0;
    }
    
    public void addUltPoints() {
        int points = (int) (Math.random() * (20 - 10 + 1)) + 10;  // Random between 5 and 8
        ult += points;
        System.out.println("Gained " + points + " ultimate points!");
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }
}

