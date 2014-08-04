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
		
		ArrayList<Cards> cards;
		cards = new ArrayList<Cards>();
		
		Cards c = new Cards();

		String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
		String[] faces = {"Jack", "Queen", "King", "Ace"};
		
		c.populateStack(deck, suits, faces);
		c.shuffle(deck);
		//c.printDeck(deck);	
		
		System.out.println("Welcome to Black Jack!");
	}
}
