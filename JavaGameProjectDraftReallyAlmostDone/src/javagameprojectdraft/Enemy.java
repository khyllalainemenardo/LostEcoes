package javagameprojectdraft;

public abstract class Enemy {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int speed;
    protected DamageType weakTo;
    
    public abstract void basicAttack(Character target);
    public abstract void skill(Character target);

    public Enemy(String name, int health, int speed, DamageType weakTo) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.speed = speed;
        this.weakTo = weakTo;
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

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setWeakTo(DamageType weakTo) {
        this.weakTo = weakTo;
    }

    //Mga Getter sad
    public boolean isAlive() {
        return health > 0;
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
    
    public void takeDamage(int damage, DamageType type) {
        if (type == weakTo) {
            damage *= 1.2;//adjust based on scaling pero ganahan ko 1.2 sa for now
        }
        health -= damage;
        if (health < 0) health = 0;
    }
}

