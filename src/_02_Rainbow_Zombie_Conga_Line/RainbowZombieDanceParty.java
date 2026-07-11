package _02_Rainbow_Zombie_Conga_Line;

import java.util.Random;
import java.util.Scanner;
import _00_Intro_to_Linked_Lists.LinkedList;

public class RainbowZombieDanceParty {
    public static void main(String[] args) {
        RainbowZombieCongaLine danceParty = new RainbowZombieCongaLine();
        LinkedList<Zombie> congaLine = danceParty.getCongaLine();
        ZombieHatColor[] hatColors = ZombieHatColor.values();
        ZombieAction[] zombieActions = ZombieAction.values();
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("How many rounds would you like?");
        int rounds = 0;
        int currentRound = 1;

        try {
            rounds = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ERROR - Please enter a whole number. Defaulting to 5 rounds.");
            rounds = 5;
        } catch (Exception e) {
            System.out.println("ERROR - Illegal input. Defaulting to 5 rounds.");
            rounds = 5;
        }

        while (currentRound <= rounds) {
            System.out.println("\n--- Round " + currentRound + " ---");
            
            // 1. Fully randomized hat color chosen here
            int randomColor = rand.nextInt(hatColors.length);
            Zombie dancer = new Zombie(hatColors[randomColor]);
            System.out.println("A new zombie arrives wearing a " + hatColors[randomColor] + " hat!");

            // 2. Ask user for manual action input
            System.out.println("Available Actions: ENGINE, CABOOSE, JUMP_IN_THE_LINE, EVERYONE_OUT, YOU_ARE_DONE, BRAINS, RAINBOW_BRAINS");
            System.out.print("Type your action choice: ");
            String userInput = sc.nextLine().toUpperCase().trim();

            // 3. Match user string input to your ZombieAction enum
            ZombieAction actionToPerform = null;
            for (ZombieAction za : zombieActions) {
                if (za.name().equals(userInput)) {
                    actionToPerform = za;
                    break;
                }
            }

            // Fallback safety if typo occurs
            if (actionToPerform == null) {
                System.out.println("Action not recognized! Defaulting to ENGINE.");
                actionToPerform = ZombieAction.ENGINE;
            }

            // 4. Process the action safely based on current line size
            System.out.println("Executing Action: " + actionToPerform);
            switch (actionToPerform) {
                case ENGINE:
                    danceParty.engine(dancer);
                    break;
                case CABOOSE:
                    danceParty.caboose(dancer);
                    break;
                case JUMP_IN_THE_LINE:
                    int position = 0;
                    if (congaLine.size() > 0) {
                        position = rand.nextInt(congaLine.size());
                    }
                    System.out.println("Inserting at random position: " + position);
                    danceParty.jumpInTheLine(dancer, position);
                    break;
                case EVERYONE_OUT:
                    danceParty.everyoneOut(dancer);
                    break;
                case YOU_ARE_DONE:
                    danceParty.youAreDone(dancer);
                    break;
                case BRAINS:
                    danceParty.brains(dancer);
                    break;
                case RAINBOW_BRAINS:
                    danceParty.rainbowBrains(dancer);
                    break;
            }

            // 5. Output current state
            System.out.println("\nCurrent Conga Line:");
            congaLine.print();
            System.out.println();

            // 6. Periodic head and tail removal rules
            if (currentRound % 5 == 0) {
                System.out.println("!!! Every 5th round rule triggered: Removing head and tail !!!");
                if (congaLine.size() > 0) {
                    congaLine.remove(0);
                }
                if (congaLine.size() > 0) {
                    congaLine.remove(congaLine.size() - 1);
                }
                congaLine.print();
                System.out.println();
            }

            currentRound++;
        }

        sc.close();
        System.out.println("Dance party finished!");
    }
}
