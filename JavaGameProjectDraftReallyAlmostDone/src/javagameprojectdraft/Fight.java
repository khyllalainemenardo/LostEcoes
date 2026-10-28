package javagameprojectdraft;
import java.util.*;

public class Fight {
    private ArrayList<Character> characters; // I can use final instead of private
    private ArrayList<Enemy> enemies;
    private Random random; // Add Random instance for enemy actions
    

    public Fight(ArrayList<Character> characters, ArrayList<Enemy> enemies) {
        this.characters = characters;
        this.enemies = enemies;
        this.random = new Random(); // Initialize the Random instance
    }

    public int startFight() {
    ArrayList<Object> participants = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int roundCount = 0;
    participants.addAll(characters);
    participants.addAll(enemies);

    System.out.println("\u001B[33m=====================================\u001B[0m");
    System.out.println("\t\u001B[33m   [BATTLE BEGIN!]\u001B[0m");
    System.out.println("\u001B[33m=====================================\u001B[0m");
    System.out.println();
    
    // Fight loop
    while (true) {
        participants.sort(Comparator.comparingInt(p -> {
            if (p instanceof Character) return ((Character) p).getSpeed();
            else return ((Enemy) p).getSpeed();
        }));

        List<Object> toRemove = new ArrayList<>();
        
        roundCount++;
        System.out.println("\u001B[33m-------------------------------------\u001B[0m");
        System.out.println("\u001B[33m Round Cycle: " + roundCount + "\u001B[0m");
        System.out.println("\u001B[33m-------------------------------------\u001B[0m");
        System.out.println();

        for (int i = 0; i < participants.size(); i++) {
            Object participant = participants.get(i);
            if (participant instanceof Character) {
                Character character = (Character) participant;
                if (character.isAlive()) {
                    int maxHealth = character.getMaxHealth();
                    System.out.println("\u001B[32m=====================================\u001B[0m");
                    System.out.println("\u001B[32m " + character.getName() + "'s Turn!\u001B[0m");
                    System.out.println("\u001B[32m Class: " + character.getClassName() + "\u001B[0m");
                    System.out.println("\u001B[32m Current HP: " + character.getHealth() + "/" + maxHealth + "\u001B[0m");
                    System.out.println("\u001B[32m Current Mana: " + character.mana + "\u001B[0m");
                    System.out.println("\u001B[32m Current Ult: " + character.getUlt() + "\u001B[0m");
                    System.out.println("\u001B[32m=====================================\u001B[0m");
                    System.out.println();
                    
                    // Check kung naa pay mga buhi
                    boolean hasAliveEnemies = false;
                    for (Enemy enemy : enemies) {
                        if (enemy.isAlive()) {
                            hasAliveEnemies = true;
                            break; // Exit the loop as soon as we find an alive enemy
                        }
                    }

                    if (hasAliveEnemies) {
                        System.out.println("What will " + character.getName() + " do? ");
                        System.out.println("[1] Perform Basic Attack");
                        System.out.println(character.getBasicAtkDesc());
                        System.out.println();
                        System.out.println("[2] Use Skill");
                        System.out.println(character.getSkillDesc());
                        System.out.println();
                        System.out.println("[3] Use Ult");
                        System.out.println(character.getUltSkillDesc());
                        System.out.println();
                        System.out.print("Select a move: ");
                        int choice;
                        while (true){
                            try {
                                choice = scanner.nextInt();
                                if (choice < 1 || choice > 3) {
                                    System.out.print("Invalid Target Selection. Please select a valid skill: ");
                                } else {
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.print("Invalid Symbol. Please select a number: ");
                                scanner.next();
                            }
                        }
                        System.out.println();
                        
                        Enemy target = selectEnemyTarget(character);
                        if (target != null) {
                            // Check user choice and perform the action
                            if (choice == 1) {
                                character.basicAttack(target);
                            } else if (choice == 2) {
                                if (character.mana >= 10) {
                                    character.skill(target);
                                    System.out.println();
                                } else {
                                    System.out.println("Not enough mana! Performing Basic Attack instead.\n");
                                    character.basicAttack(target);
                                }
                            } else if (choice == 3) {
                                if (character.ult >= 50) {
                                    character.ultSkill(target);
                                    System.out.println();
                                } else {
                                    System.out.println("Not enough ultimate points! Performing Basic Attack instead.\n");
                                    character.basicAttack(target);
                                }
                            }

                            if (!target.isAlive()) {
                                System.out.println("\u001B[33m" + target.getName() + " is defeated!\u001B[0m");
                                System.out.println();
                                toRemove.add(target);
                            }
                        }
                    } else {
                        System.out.println("No more available enemies to attack. Cannot take action.");
                        System.out.println();
                    }
                }
            } else if (participant instanceof Enemy) {
                Enemy enemy = (Enemy) participant;
                int maxHealth = enemy.getMaxHealth();
                if (enemy.isAlive()) {
                    System.out.println("\u001B[31m=====================================\u001B[0m");
                    System.out.println("\u001B[31m " + enemy.getName() + "'s Turn!\u001B[0m");
                    System.out.println("\u001B[31m Current HP: " + enemy.getHealth() + "/" + maxHealth + "\u001B[0m");
                    System.out.println("\u001B[31m=====================================\u001B[0m");
                    
                    Character target = selectCharacterTarget();
                    if (target != null) {
                        // Enemy randomly chooses between Basic Attack (1) or Skill (2)
                        int enemyAction = random.nextInt(2) + 1; // Generates 1 or 2

                        if (enemyAction == 1) {
                            enemy.basicAttack(target);
                        } else {
                            enemy.skill(target);
                        }
                        System.out.println("\u001B[33m" + target.getName() + "'s Current HP: " + target.getHealth() + "\u001B[0m");
                        System.out.println();
                        if (!target.isAlive()) {
                            System.out.println();
                            System.out.println("\u001B[31m" + target.getName() + " is defeated!\u001B[0m");
                            toRemove.add(target);
                        } 
                    } else {
                        System.out.println("Enemy has no available characters to attack.");
                    }
                }
            }
            
            // Check if the fight is over after processing all participants
            if (enemies.isEmpty()) {
                scanner.nextLine();
                System.out.println("\u001B[32mAll enemies are defeated! You win!\u001B[0m");
                cleanupParticipants();
                waitForInput(scanner);
                System.out.println();
                System.out.println("\u001B[33m=====================================\u001B[0m");
                System.out.println("\t\u001B[33m   [BATTLE OVER!]\u001B[0m");
                System.out.println("\u001B[33m=====================================\u001B[0m");
                System.out.println();
                return 0; // returns 0 if all enemies are defeated
            }
            if (characters.isEmpty()) {
                scanner.nextLine();
                System.out.println("\u001B[31mAll characters are defeated! You lose!\u001B[0m");
                cleanupParticipants();
                waitForInput(scanner);
                System.out.println();
                System.out.println("\u001B[33m=====================================\u001B[0m");
                System.out.println("\t\u001B[33m   [BATTLE OVER!]\u001B[0m");
                System.out.println("\u001B[33m=====================================\u001B[0m");
                System.out.println();
                return 1; // returns 1 if all characters are defeated
            }
        }

        // Remove dead characters and enemies after the round
        participants.removeAll(toRemove);
        characters.removeIf(character -> !character.isAlive());
        enemies.removeIf(enemy -> !enemy.isAlive());
    }
}

    private Enemy selectEnemyTarget(Character  character) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Current Enemies:");
        int index = 1; // Start numbering from 1
        List<Enemy> aliveEnemies = new ArrayList<>();
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if (enemy.isAlive()) {
                System.out.println("[" + (index) + "] " + enemy.getName() + " (HP: " + enemy.health + ")");
                aliveEnemies.add(enemy); // Add alive enemy to the list
                index++;
            }
        }

        // Handle case when there are no enemies left
        if (aliveEnemies.isEmpty()) {
            System.out.println("No available enemies to attack.");
            return null; // Return null if no enemies are left
        }

        System.out.print("Select a target: ");
        int targetIndex;
        while (true){
            try {
                targetIndex = scanner.nextInt() - 1;
                if (targetIndex < 0 || targetIndex >= aliveEnemies.size()) {
                    System.out.print("Invalid Target Selection. Please select a valid enemy: ");
                } else {
                    break;
                }
            } catch (Exception e){
                System.out.print("Invalid Symbol. Please select a number: ");
                scanner.next();
            }
        }
        System.out.println();
        // Validate the target index
        return aliveEnemies.get(targetIndex);
    }

    private Character selectCharacterTarget() {
        for (Character character : characters) {
            if (character.isAlive()) {
                return character;
            }
        }
        return null;
    }
    
    private void cleanupParticipants() {
        characters.clear();
        enemies.clear();
    }
    
    private void waitForInput(Scanner scanner) {
        System.out.print("   Press Enter to continue...");
        String con = scanner.nextLine(); // Wait for user input
    }
}