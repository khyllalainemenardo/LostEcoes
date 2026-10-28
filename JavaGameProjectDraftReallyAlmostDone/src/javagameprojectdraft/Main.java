package javagameprojectdraft;
import java.util.ArrayList;
import java.util.Scanner;

/*
Small notes to understand my code:
- In the fight sequence, 0 is win, and 1 is lose.
*/

public class Main {
    
    //===============ang unsay ma modify ra nimo=====================
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WholeContent mainContent = new WholeContent();
        ArrayList<Character> characters = new ArrayList<>();
        ArrayList<Enemy> enemies = new ArrayList<>();
        
        boolean debugMode = false, repeatWholeGame = true, loop1 = true;
        String debugModePass = "sirkhaidemo";
        
        String heroName;
        
        mainContent.showTitle();
        while (repeatWholeGame){
            System.out.println();
            
            //=======================MENU SCREEN============================
            mainContent.showMenu();
            int menuChoice;
            while (true) {
                try {
                    menuChoice = scanner.nextInt();
                    if (menuChoice < 5 && menuChoice > 0){
                        break;
                    } else {
                        System.out.print("Invalid Choice. Please select again: ");
                    }
                } catch (Exception e) {
                    System.out.print("Invalid Symbol. Please select again: ");
                    scanner.nextLine();
                }
            }
            System.out.println();
            scanner.nextLine();
            //==============================================================
            
            
            //=========================CHOICE 4=============================
            if (menuChoice == 4) {
                System.out.println("Game Exited. Thank you for playing!");
                waitForInput(scanner);
                System.out.println();
                break;
            }
            //==============================================================
            
            
            //=========================CHOICE 3=============================
            else if (menuChoice == 3) {
                mainContent.showTutorial();
            }
            //==============================================================
            
            
            //=========================CHOICE 2=============================
            else if (menuChoice == 2) {
                debugProtocol(debugModePass);
            }
            //==============================================================
            
            
            //=========================CHOICE 1=============================
            else if (menuChoice == 1){
                System.out.println("You have selected Story Mode. Playing the game normally.");
                waitForInput(scanner);
                System.out.println();
                
                mainContent.chap1StoryPart1();
        
                System.out.println("Then, what might your name be, refugee?");
                do {
                    System.out.print("   Enter the name you desire to use: ");
                    heroName = scanner.nextLine().trim(); //I put trim here para mu work gihapon bisag puros space ra gibutang
                    if (heroName.isEmpty()) {
                        System.out.println("Well? I need your name so we know what your name is.");
                    }
                } while (heroName.isEmpty());
                int heroHP = 120, heroMana = 20, heroSpeed = 5, heroMultiplier = 1;
                characters.add(new Hero(heroName, heroHP, heroMana, heroSpeed, heroMultiplier));
        
                mainContent.chap1StoryPart2(heroName);
                enemies.add(new MeleeWeakEnemy("Weak Goblin #1", 20, 4, "Club Swing", 5, 9, "Sneak Stab", 10, 13));
                enemies.add(new MeleeWeakEnemy("Weak Goblin #2", 20, 4, "Club Swing", 5, 9, "Sneak Stab", 10, 13));
        
                // sugod fight 1
                Fight fight = new Fight(characters, enemies);
                System.out.println();
                    
            int fightStatus = fight.startFight();
            System.out.println();
        
            if (fightStatus == 0){
                mainContent.chap1StoryPart3Win(heroName);
            } else {
                mainContent.chap1StoryPart3Lose(heroName);
                }
            }
            //==============================================================
            
            //====================End of Game thing=========================
            loop1 = true;
            System.out.println();
            System.out.println("[REACHED THE END]");
            System.out.println("Return to Menu?");
            System.out.println("[Y] Yes: Return to Main Menu");
            System.out.println("[N] No: Exit Game");
            while (loop1){
                System.out.print("Enter choice: ");
                char returnChoice = scanner.next().charAt(0);
                System.out.println();
                
                scanner.nextLine();
                switch (returnChoice){
                    case 'Y':
                    case 'y':
                        System.out.println("Returning to Main Menu...");
                        waitForInput(scanner);
                        loop1 = false;
                        break;
                        
                    case 'N':
                    case 'n':
                        System.out.println("Exiting Game...");
                        waitForInput(scanner);
                        System.out.println("\nGame Exited. Thank you for playing!");
                        waitForInput(scanner);
                        System.out.println();
                        loop1 = false;
                        repeatWholeGame = false;
                        break;
                        
                    default:
                        System.out.println("Invalid Choice!");
                        break;
                }
            }
            //==============================================================
        }
    }
    //===============================================================
    
    
    //========================DO NOT TOUCH===========================
    private static void waitForInput(Scanner scanner) {
        System.out.print("   Press Enter to continue...");
        scanner.nextLine(); // Wait for user input
    }
    
    private static void debugProtocol(String debugModePass){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> characters = new ArrayList<>();
        ArrayList<Enemy> enemies = new ArrayList<>();
        
        System.out.println("You have selected Debug Mode. This protocol is used to test the game quickly.");
        
        System.out.print("Please input password for authentication: ");
        String passInp = scanner.nextLine();
                
        if (passInp.equals(debugModePass)){
            System.out.println();
            System.out.println("\u001B[32mDebug Mode Authentication Complete.\nBeginning Object Oriented Programming Game Demo for Sir Khai.\u001B[0m");
            waitForInput(scanner);
                    
            //Create Hero
            System.out.println("\n\u001B[33mLoading Characters:\u001B[0m\n");
            System.out.println("[Character 1]\nName: Arthur McDouglas\nType: Hero\nHP: 120\nMana: 20\nSpeed: 5");
            characters.add(new Hero("Arthur McDouglas", 120, 20, 5, 1));
                    
            //Create Mage
            System.out.println("\n[Character 2]\nName: Liora Gladius\nType: Mage\nHP: 70\nMana: 30\nSpeed: 7");
            characters.add(new Mage("Liora Gladius", 80, 30, 7, 1));
                    
            //Create Archer
            System.out.println("\n[Character 3]\nName: Archer Queen\nType: Archer\nHP: 80\nMana: 25\nSpeed: 6");
            characters.add(new Archer("Archer Queen", 80, 25, 6, 1));
                
            System.out.println("\n[Character 4]\nName: Ezio Auditore\nType: Assasin\nHP: 70\nMana: 30\nSpeed: 2");
            characters.add(new Assassin("Ezio Auditore", 70, 30, 2, 1));
            System.out.println();
            
            waitForInput(scanner);
            
            System.out.println("\n\u001B[33mLoading Enemies:\u001B[0m\n");
            System.out.println("[Enemy 1]\nName: Melee Weak Enemy\nWeakness: Melee\n\n[Enemy 2]\nName: Magic Weak Enemy\nWeakness: Magic\n\n[Enemy 3]\nName: Range Weak Enemy\nWeakness: Range");
            enemies.add(new MeleeWeakEnemy("Melee Weak Enemy", 20, 5, "Melee Basic Attack", 5, 9, "Melee Skill", 10, 13));
            enemies.add(new MagicWeakEnemy("Magic Weak Enemy", 20, 6, "Basic Magic Attack", 6, 10, "Magic Skill", 20, 23));
            enemies.add(new RangedWeakEnemy("Range Weak Enemy", 20, 4, "Basic Range Attack", 6, 10, "Range Skill", 12, 15));
            System.out.println();
            waitForInput(scanner);
                    
            Fight fight = new Fight(characters, enemies);
            System.out.println("\n\u001B[32mScenario 1: Regular Battle\u001B[0m");
            waitForInput(scanner);
            fight.startFight();
                    
            System.out.println("\n\u001B[32mScenario 2: Guaranteed Win\nCreated demo Character and Enemy.\u001B[0m");
            characters.add(new Hero("One Punch Man", 120, 20, 5, 100));
            enemies.add(new MeleeWeakEnemy("Very Weak Enemy", 5, 1, "Weak Basic Attack", 2, 3, "Weak Skill", 2, 3));
            waitForInput(scanner);
            fight.startFight();
                    
            System.out.println("\n\u001B[32mScenario 3: Guaranteed Lose\nCreated demo Character and Enemy.\u001B[0m");
            characters.add(new Hero("Weak Hero", 1, 5, 1, 1));
            enemies.add(new MeleeWeakEnemy("Very Strong Enemy", 100, 5, "Very Strong Basic Attack", 95, 100, "Very Strong Skill", 95, 100));
            waitForInput(scanner);
            fight.startFight();
                    
            System.out.println("\n\u001B[32mCombat Demo Complete. Debugging Mode Complete.\u001B[0m");
            waitForInput(scanner);
        } else {
            System.out.println();
            System.out.println("\u001B[31mAuthentication Failed: Aborting Debug Mode.\u001B[0m");
        }
    }
    //===============================================================
}
