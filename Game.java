/*
 * This class runs the game
 * Josh Pollmann
 * 8/4/14
 */

import java.util.ArrayList;
import java.util.Stack;

public class Game {
	
	public static void main(String[] args){
		
		Stack<Cards> deck;
		deck = new Stack<Cards>();
		
		ArrayList<Cards> hand;
		hand = new ArrayList<Cards>();
		
		Cards c = new Cards();

		String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
		String[] faces = {"Jack", "Queen", "King", "Ace"};
		
		int total = 0;
		boolean hasAce = false;
		
		c.populateStack(deck, suits, faces);
		c.shuffle(deck);
		//c.printDeck(deck);	
		
		System.out.println("Welcome to Black Jack!");
		System.out.println();
		
		hand.add(c.drawCard(deck));
		hand.add(c.drawCard(deck));
		c.printFirstHand(hand);
		
		total += hand.get(0).getValue() + hand.get(1).getValue();
		
		if(total == 22){
			total -= 9;
		}
		
		if(hand.get(0).getValue() == 11 && hand.get(1).getValue() == 10 || hand.get(1).getValue() == 11 && hand.get(0).getValue() == 10){
			total = 21;
			System.out.println();
			System.out.println("21!");
		}else{
			System.out.println();
			System.out.println("Your total is " + total);
		}
	}
}
