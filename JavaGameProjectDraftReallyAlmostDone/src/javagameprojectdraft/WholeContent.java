package javagameprojectdraft;
import java.util.Scanner;

public class WholeContent {
    Scanner scanner = new Scanner(System.in);
    private int choice;
    private String cyanText = "\u001B[36m";
    private String blueText = "\u001B[34m";
    private String yellowText = "\u001B[33m";
    private String redText = "\u001B[31m";
    private String greenText = "\u001B[32m";
    private String resetText = "\u001B[0m";
    
    private String npc1Name;
    
    private boolean waitForInput(Scanner scanner) {
        System.out.print("   Press Enter or any key to continue or type " + yellowText + "\"skip\"" + resetText + " to skip the story: ");
        String input = scanner.nextLine(); // Read user input
        if (input.equalsIgnoreCase("skip")){
            System.out.println(yellowText + "   Skipped Story!"+ resetText);
        }
        System.out.println();
        return input.equalsIgnoreCase("skip"); // Return true if user wants to skip
    }
    
    private void waitForInputNoSkip(Scanner scanner) {
        System.out.print("   Press Enter or any key to continue...");
        scanner.nextLine(); // Read user input
        System.out.println();
    }
    
    public void showTitle(){
        System.out.println(blueText + "===========================================================================================" + resetText);
        System.out.println(blueText + "|    " + resetText + "    _                     _        _____          _                                " + blueText + "  |" + resetText);
        System.out.println(blueText + "|    " + resetText + "   | |                  _| |_     |  ___|        | |                               " + blueText + "  |" + resetText);
        System.out.println(blueText + "|    " + resetText + "   | |      ___    ___ (_   _)    | |___    ___  | |___     ___     ___   ___     " + blueText + "   |" + resetText);
        System.out.println(blueText + "|    " + resetText + "   | |     / _ \\  / __)  | |      |  ___|  /  _| |  __  \\  / _ \\   / _ \\ / __)    " + blueText + "   |" + resetText);
        System.out.println(blueText + "|    " + resetText + "   | |    | | | | \\_ \\   | |      | |     |  /   | |  \\ | | | | | | ___/ \\__ \\    " + blueText + "   |" + resetText);
        System.out.println(blueText + "|    " + resetText + "   | |___ | |_| | __/ |  | |      | |___  |  \\_  | |  | | | |_| | | \\_   __/ |    " + blueText + "   |" + resetText);
        System.out.println(blueText + "|    " + resetText + "   |_____| \\___/ (___/   |_|      |_____|  \\___| |_|  |_|  \\___/   \\__|  (___/    " + blueText + "   |" + resetText);
        System.out.println(blueText + "|    " + resetText + "                                                        ___                       " + blueText + "   |" + resetText);
        System.out.println(blueText + "|    " + resetText + "  _____________________________________________________|   |___________________   " + blueText + "   |" + resetText);
        System.out.println(blueText + "|    " + resetText + " /  _________________________________________________  |   | |  |  |  |  |  |  |  " + blueText + "   |" + resetText);
        System.out.println(blueText + "|    " + resetText + " \\_____________________________________________________|   |___________________|  " + blueText + "   |" + resetText);
        System.out.println(blueText + "|    " + resetText +  "                                                       |___|                      " + blueText + "   |" + resetText);
        System.out.println(blueText + "|    " + resetText + cyanText + " \" A  T U R N - B A S E D  S T O R Y  G A M E \"\t\t    [CSIT 227 - OOP1]  " + blueText + "   |" + resetText);
        System.out.println(blueText + "|\t\t\t\t\t\t\t\t\t\t\t  |" + resetText);
        System.out.println(blueText + "===========================================================================================" + resetText);
        System.out.println(blueText + "\t      |" + resetText + "    MEMBERS: Ballener, Menardo, Morales, Riambon, Unabia" + blueText + "    |" + resetText);
        System.out.println(blueText + "\t      ==============================================================" + resetText);
        System.out.println("\n\t\t\t Press \"Enter\" or any key to Go To Menu...");
        scanner.nextLine();
    }
    
    public void showMenu(){
        System.out.println("[MAIN MENU]");
        System.out.println("[1] Play Story Mode");
        System.out.println("[2] Play Debug Mode");
        System.out.println("[3] Tutorial");
        System.out.println("[4] Exit Game");
        System.out.print("Select Option: ");
    }
    
    public void showTutorial(){
        System.out.println(yellowText + "[TUTORIAL]" + resetText);
        System.out.println("Welcome to Lost Echoes! A Turn-Based story game in which you follow the journey of a hero in a Fantasy World.");
        waitForInputNoSkip(scanner);
        System.out.println("The game has several mechanics. But we will summarize it to the basics.");
        waitForInputNoSkip(scanner);
        System.out.println(yellowText + "[BASIC GUIDE 1: Damage Types]" + resetText);
        System.out.println("I will introduce you to one of the fundamentals in this game which are Damage Types.");
        waitForInputNoSkip(scanner);
        System.out.println("Currently, the fighting system has three damage types, and the enemies are weak against one of the three:");
        System.out.println(yellowText + "[MELEE]" + resetText + " = A type for the generalists. Anyone can wield this type");
        System.out.println(greenText + "[RANGED]" + resetText + " = A type for the rangers. Swift and sharp, fighting at a safe distance.");
        System.out.println(cyanText + "[MAGIC]" + resetText + " = A type for the arcanists. Wise and intelligent in understanding the workings of this world.");
        waitForInputNoSkip(scanner);
        System.out.println("The people in this game will tell you what enemies are weak against what type.");
        waitForInputNoSkip(scanner);
        System.out.println(yellowText + "[BASIC GUIDE 2: Turn Order]" + resetText);
        System.out.println("I will then explain the turn mechanic of the game.");
        waitForInputNoSkip(scanner);
        System.out.println("Since this is a turn-based game, each characters and enemies will take turns between one another.");
        waitForInputNoSkip(scanner);
        System.out.println("Each character will have a predefined speed value, which will determine their order in the cycle.");
        waitForInputNoSkip(scanner);
        System.out.println("Example:");
        System.out.println("Hero (Speed: 1) > Goblin (Speed: 2) ");
        System.out.println("Some characters will be faster than enemies, and some enemies will be faster than characters.");
        waitForInputNoSkip(scanner);
        System.out.println("Arranged in ascending order, the lower the speed value, the earlier their turn.");
        waitForInputNoSkip(scanner);
        System.out.println(yellowText + "[BASIC GUIDE 3: Combat]" + resetText);
        System.out.println("Then, we go over to the combat mechanic.");
        waitForInputNoSkip(scanner);
        System.out.println("During your turn, you will be asked which move you'd like to do.");
        waitForInputNoSkip(scanner);
        System.out.println("Afterwards, you will be asked on who to target.");
        waitForInputNoSkip(scanner);
        System.out.println("The Selection Screen would look something like this:");
        System.out.println();
        System.out.println("What will Player do?");
        System.out.println("[1] Perform Basic Attack");
        System.out.println("  *description of attack*");
        System.out.println();
        System.out.println("[2] Use Skill");
        System.out.println("  *description of attack*");
        System.out.println();
        System.out.println("[3] Use Ultimate");
        System.out.println("  *description of attack*");
        System.out.println();
        System.out.println("Current Enemies:");
        System.out.println("[1] Enemy");
        System.out.println("[2] Enemy");
        System.out.println("[3] Enemy");
        System.out.println();
        waitForInputNoSkip(scanner);
        System.out.println("The amount of enemies and characters as well would depend on how many is implemented in the story.");
        waitForInputNoSkip(scanner);
        System.out.println("The same goes for their stats. It is implemented in the story as well.");
        waitForInputNoSkip(scanner);
        System.out.println(yellowText + "[BASIC GUIDE 4: Dialogues]" + resetText);
        System.out.println("Lastly, we go to the dialogue system.");
        waitForInputNoSkip(scanner);
        System.out.println("You have the option to either listen to the whole story, or skip it.");
        waitForInputNoSkip(scanner);
        System.out.println("But sometimes, you are asked to select a dialogue within the story.");
        waitForInputNoSkip(scanner);
        System.out.println("It would look something like this:");
        System.out.println();
        System.out.println("You respond with:");
        System.out.println("[1: Emotion] Dialogue 1");
        System.out.println("[2: Emotion] Dialogue 2");
        System.out.println("Select Dialogue: ");
        System.out.println();
        waitForInputNoSkip(scanner);
        System.out.println("Well, that's about the gist of the whole game.");
        waitForInputNoSkip(scanner);
        System.out.println("I hope you'll enjoy the game!");
        waitForInputNoSkip(scanner);
    }
 
    public void chap1StoryPart1() {
        System.out.println(cyanText + "[CHAPTER 1: Introductory]" + resetText);
        npc1Name = "???";
        System.out.println();
        System.out.println("*You hear rumbling within your vicinity.*");
        if (waitForInput(scanner)) return; // Wait for user input
        
        System.out.println("*You can feel the rumble resonate in your body.*");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: Hey.");
        if (waitForInput(scanner)) return;
        
        System.out.println("*You try to look over to where the source of the sound is.*");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: Hey there. You good?");
        if (waitForInput(scanner)) return;
        
        System.out.println("*You try to respond, but you lack strength to do so.*");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: Hold on. Don't try to speak.");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: You're in a very rough shape buddy. You need to recover a tad bit.");
        if (waitForInput(scanner)) return;
        
        System.out.println("*You hear an ambience of conflict in the background.*");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: Ignore them. Consume this for me, will ya?");
        if (waitForInput(scanner)) return;
        
        System.out.println("*You were given some sort of medicine.*");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: So? How is it?");
        if (waitForInput(scanner)) return;
        
        System.out.println("You respond with:");
        System.out.println("[1: Eager] I feel quite refreshed.");
        System.out.println("[2: Reluctant] The medicine is suspicious.");
        System.out.print("Select Dialogue: ");
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice < 3 && choice > 0){
                    break;
                } else {
                    System.out.print("Invalid Choice! Select again: ");
                }
            } catch (Exception e){
                System.out.print("Invalid Symbol! Select again: ");
                scanner.nextLine();
            }
        }
        System.out.println();
        scanner.nextLine();
        
        if (choice == 1){
            System.out.println("*You take the medicine. You regained some of your strength afterwards.*");
            if (waitForInput(scanner)) return;
            
            System.out.println("[You]: Oh wow. I do feel quite refreshed after taking it.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: This recovery medicine is created by one of the most renowed medical healers in the field.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: Despite being a lower-tier version of the concution, it's still very effective.");
            if (waitForInput(scanner)) return;
        } else {
            System.out.println("[You]: This is kind of suspicious though.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[You]: Is this some sort of trick?");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: No need to get cautious.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: It's a recovery medicine is created by one of the most renowed medical healers in the field.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: Although what you're getting is a low-tier version of it though. Good for quick recoveries.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: Despite that, it's still very effective.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[You]: *Gulps* Well, if you say so.");
            if (waitForInput(scanner)) return;
            
            System.out.println("*You reluctantly take the medicine. You regained some of your strength afterwards.*");
            if (waitForInput(scanner)) return;
        }
        
        System.out.println("[" + npc1Name + "]: By the way, I haven't introduced myself yet.");
        if (waitForInput(scanner)) return;
        
        npc1Name = "Ingrid";
        System.out.println("[" + npc1Name + "]: I'm Ingrid. A Recovery Arcanist Agent.");
        if (waitForInput(scanner)) return;
        
        System.out.println("You respond with:");
        System.out.println("[1: Confusion] What's that?");
        System.out.println("[2: Condescend] What a stupid title.");
        System.out.print("Select Dialogue: ");
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice < 3 && choice > 0){
                    break;
                } else {
                    System.out.print("Invalid Choice! Select again: ");
                }
            } catch (Exception e){
                System.out.print("Invalid Symbol! Select again: ");
                scanner.nextLine();
            }  
        }
        System.out.println();
        scanner.nextLine();
        
        if (choice == 1){
            System.out.println("[You]: A Recovery Arcanist Agent? What's that?");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: It's basically given to those who's job is to recover and aid refugess during the war.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: That's just the official term though. You could however just call us a medic.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: They're about the same anyways, only we focus on refugees more.");
            if (waitForInput(scanner)) return;
        } else {
            System.out.println("[You]: That's such a stupid title! Who came up with that?");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: Hey! No need to diss the official title.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: I worked very hard to earn this just to help people like you.");
            if (waitForInput(scanner)) return;
        }
        
        System.out.println("[" + npc1Name + "]: Now that we got that out of the way, I need to confirm something.");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: You have a look that's screaming \"I can't remember anything\".");
        if (waitForInput(scanner)) return;
        
        System.out.println("[You]: You're right unfortunately. I just woke up without remembering anything.");
        if (waitForInput(scanner)) return;
            
        System.out.println("[" + npc1Name + "]: Huh. A hint of amnesia.");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: But that's strange. It doesn't look like you're hit in the head hard.");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: Moreover, you look quite unscathed.");
        if (waitForInput(scanner)) return;
        
        System.out.println("[You]: But I can't remember a thing.");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: Right. You can't remember a thing.");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: However, there is one thing that boggles me.");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: The fact that you're alive with minimal damage in this no-man's land is rather suspicious.");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: And your face bears resemblance to a certain figure.");
        if (waitForInput(scanner)) return;
        
        System.out.println("[You]: Strangely enough, the only thing I could remember now is just my name.");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: Is that so?");
        waitForInputNoSkip(scanner);
        //then after ana is katong enter your name chu chu
    }
    
    public void chap1StoryPart2(String heroName){
        npc1Name = "Ingrid";
        System.out.println();
        System.out.println("[" + npc1Name + "]: So your name is " + yellowText + heroName + resetText + "?");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: Strange. A familiar name, with a familiar face.");
        if (waitForInput(scanner)) return;
        
        System.out.println("[You]: Is there something about me?");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: Well, there is something. But I can't lay my finger on what.");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: Do you really not remember anything other than your name?");
        if (waitForInput(scanner)) return;
        
        System.out.println("You respond with:");
        System.out.println("[1: Assurance] No. I don't remember anything.");
        System.out.println("[2: Annoyed] You've been asking this a lot of times.");
        System.out.print("Select Dialogue: ");
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice < 3 && choice > 0){
                    break;
                } else {
                    System.out.print("Invalid Choice! Select again: ");
                }
            } catch (Exception e){
                System.out.print("Invalid Symbol! Select again: ");
                scanner.nextLine();
            }  
        }
        System.out.println();
        scanner.nextLine();
        
        if (choice == 1){
            System.out.println("[You]: As I have said before, I really don't.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[You]: I do apologize for that.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: No worries. I'm just making sure.");
            if (waitForInput(scanner)) return;
        } else {
            System.out.println("[You]: You've been repeating the same question over and over again.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[You]: It's annoying me, really.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: Well, I'm sorry monsieur.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: I just find it very hard to believe that you can't remember anything with that uncanny resemblance.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: No need to get worked up.");
            if (waitForInput(scanner)) return;
        }
        
        System.out.println("*You hear the sound of marching in the distance.*");
        if (waitForInput(scanner)) return;
        
        System.out.println("*As you try to look over to the source of the sound, you noticed that it was goblins marching to your location.*");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: Crud. They just keep coming, won't they?");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: You have regained some of your strength. Can you fight?");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: I can't exactly solo them all.");
        if (waitForInput(scanner)) return;
        
        System.out.println("[You]: I think I can?");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: Take this. It's a spare blade I have in my inventory.");
        if (waitForInput(scanner)) return;
        
        System.out.println("*Ingrid hands you his spare blade. It resonates with [MELEE] energy.*");
        if (waitForInput(scanner)) return;
        
        System.out.println("You respond with:");
        System.out.println("[1: Thanks] Thank you for this.");
        System.out.println("[2: Pettiness] Don't you have anything better?");
        System.out.print("Select Dialogue: ");
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice < 3 && choice > 0){
                    break;
                } else {
                    System.out.print("Invalid Choice! Select again: ");
                }
            } catch (Exception e){
                System.out.print("Invalid Symbol! Select again: ");
                scanner.nextLine();
            }  
        }
        System.out.println();
        scanner.nextLine();
        
        if (choice == 1){
            System.out.println("[You]: This should is enough. Thank you.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: You're welcome. I do apologize that it's the only spare blade I have.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[You]: No no, this is good.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: Glad to hear that.");
            if (waitForInput(scanner)) return;
        } else {
            System.out.println("[You]: This blade seems flimsy and weak.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[You]: Do you not have anything that's better?");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: I do have another option.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: I can just leave you to die alone with no weapon at hand.");
            if (waitForInput(scanner)) return;
            
            System.out.println("*You stay silent.*");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: I thought so.");
            if (waitForInput(scanner)) return;
            
        }
        
        System.out.println("[" + npc1Name + "]: Anyways, This sword should hurt them good.");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: This hurts them more than other ways of hurting them.");
        if (waitForInput(scanner)) return;
        
        System.out.println("*The goblins march closer.*");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: They're close now.");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: Take two of them. I'll handle the rest.");
        if (waitForInput(scanner)) return;
        
        System.out.println("[You]: Got it.");
        if (waitForInput(scanner)) return;
        
        System.out.println("*You engage by battling two goblins.*");
        if (waitForInput(scanner)) return;
        
        System.out.println("[You]: Have at thee!");
        waitForInputNoSkip(scanner);
    }
    
    public void chap1StoryPart3Lose(String heroName){
        System.out.println("*You twitch in pain.*");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: Oh no! That was stupid of me!");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: Why did I let a refugee fight!?");
        if (waitForInput(scanner)) return;
        
        System.out.println("*Your whole body is paralyzed from the pain.*");
        if (waitForInput(scanner)) return;
        
        System.out.println("*Your vision is slowly fading.*");
        if (waitForInput(scanner)) return;
        
        System.out.println("*And before you know it...*");
        if (waitForInput(scanner)) return;
        
        System.out.println(redText + "*You're dead.*" + resetText);
        waitForInputNoSkip(scanner);
    }
    
    public void chap1StoryPart3Win(String heroName){
        npc1Name = "Ingrid";
        System.out.println();
        System.out.println("*The remaining goblins get defeated by Ingrid.*");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: *Pant* Woah. You're a tough one.");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: I mean didn't have to expect much from your fighting style but....");
        if (waitForInput(scanner)) return;
        
        System.out.println("[" + npc1Name + "]: Your swordsmanship is quite cool.");
        if (waitForInput(scanner)) return;
        
        System.out.println("You respond with:");
        System.out.println("[1: Confusion] I know how to fight?");
        System.out.println("[2: Confidence] I can teach you.");
        System.out.print("Select Dialogue: ");
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice < 3 && choice > 0){
                    break;
                } else {
                    System.out.print("Invalid Choice! Select again: ");
                }
            } catch (Exception e){
                System.out.print("Invalid Symbol! Select again: ");
                scanner.nextLine();
            }  
        }
        System.out.println();
        scanner.nextLine();
        
        if (choice == 1){
            System.out.println("[You]: I didn't expect it as well.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[You]: It's came to me quite naturally.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: Huh.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: That's really strange. But still, quite neat.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[You]: It's not reassuring you, is it?");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: Nope.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: But hey, at least we're alive right?");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: Your unorthodox swordsmanship saved us. So I'll let it slide.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[You]: Thank you.");
            if (waitForInput(scanner)) return;
            
        } else {
            System.out.println("[You]: I think I can teach you a thing or two.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: *Laughs* Oh that's wonderful!");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: A new swordsmanship style that I could use for self-defense.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: You're willing to do that?");
            if (waitForInput(scanner)) return;
            
            System.out.println("[You]: Sure. I really don't mind.");
            if (waitForInput(scanner)) return;
            
            System.out.println("[" + npc1Name + "]: Sweet! You promised yourself to me now.");
            if (waitForInput(scanner)) return;
        }
    }
}
