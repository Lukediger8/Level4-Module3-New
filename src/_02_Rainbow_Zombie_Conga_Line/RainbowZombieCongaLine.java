package _02_Rainbow_Zombie_Conga_Line;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {
    
    /*
     * You are hosting a rainbow zombie conga dance party! Zombies are not very
     * smart(maybe that's why they crave brains) and need your help to direct
     * them through the choreography.
     * 
     * Each method is a dance move you will need to implement.
     * 
     * When you think you've gotten your zombies trained well enough you can
     * start the party by running the main method in RainbowZombieDanceParty and
     * typing how many rounds you want in the console to see if they followed
     * your choreography correctly.
     * 
     * Note: The party will always start with a rainbow brains and every 5
     * rounds the head and tail of the dance line will be removed.
     */

    private LinkedList<Zombie> congaLine;
    private ZombieHatColor[] zombieHats;
    Node<Zombie> newHead;
    Node<Zombie> hatZomb;
    public RainbowZombieCongaLine() {

        congaLine = new LinkedList<Zombie>();
        zombieHats = ZombieHatColor.values();

    }

    // Make the passed in zombie the first Zombie in the conga line!
    public void engine(Zombie dancer) {
    	newHead = new Node<Zombie>(dancer);
    	Node<Zombie> oldHead = congaLine.getHead();
    	if(oldHead != null) {
    	newHead.setNext(oldHead);
    	oldHead.setPrev(newHead);
    	congaLine.setHead(newHead);
    	}
    	else {
    		congaLine.add(dancer);
    	}
    }

    // Make the passed in zombie the last Zombie in the conga line!
    public void caboose(Zombie dancer) {
    	Node<Zombie> newTail = new Node<Zombie>(dancer);
    	Node<Zombie> oldTail = congaLine.getTail();
    	if(oldTail != null) {
    	congaLine.setTail(newTail);
    	newTail.setPrev(oldTail);
    	oldTail.setNext(newTail);
    	}
    	else {
    		congaLine.add(dancer);
    	}
    	
    }

    // Place the zombie at the designated position in the conga line!
    public void jumpInTheLine(Zombie dancer, int position) {
    	Node<Zombie> newNode = new Node<Zombie>(dancer);
    	int num = 0;
    	Node<Zombie> current = congaLine.getHead();
    	while(num < position) {
    		current = current.getNext();
    		num++;
    		}
    	
    	newNode.setNext(current);
    	current.getPrev().setNext(newNode);
    	if(position > 0) {
    		newNode.setPrev(current.getPrev());
        	current.setPrev(newNode);

    	}
    	
    }

    /*
     * Remove all zombies with the same hat color as the passed in zombie from
     * the conga line!
     */
    public void everyoneOut(Zombie dancer) {
    	Node<Zombie> current = congaLine.getHead();
    	int position = 0;
    	while(current != null) {
    		if(current.getValue().getZombieHatColor() == dancer.getZombieHatColor()) {
    			congaLine.remove(position);
    			current = congaLine.getHead();
    			position = 0;
                
    			
    		}
    		else {
    			current = current.getNext();
    			position++;
    		}
	    	
    	}
    	
    }
    

    	
    

    /*
     * Remove the first zombie with the same hat color as the passed in zombie
     * from the conga line!
     */
    public void youAreDone(Zombie dancer) {
    	Node<Zombie> current = congaLine.getHead();
    	int position = 0;
    	while(current != null) {
    		if(current.getValue().getZombieHatColor() == dancer.getZombieHatColor()) {
    			congaLine.remove(position);
    			current = congaLine.getHead();
    			position = 0;
                return;
    			
    		}
    		else {
    			current = current.getNext();
    			position++;
    		}
	    	
    	}
    	
    }

    /*
     * Make two more zombies with the same hat color as the passed in zombie and
     * add one to the front, one to the end and one in the middle.
     */
    public void brains(Zombie dancer) {
    	Node<Zombie> front
    }

    /*
     * Add the passed in zombie to the front and then add one zombie of each hat
     * color to the end of the line.
     */
    public void rainbowBrains(Zombie dancer) {

    }

    public LinkedList<Zombie> getCongaLine() {
        return congaLine;
    }
}
