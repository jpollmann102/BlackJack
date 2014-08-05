/*
 * This class contains the constructors and methods for shuffling, populating, and drawing cards
 * Josh Pollmann
 * 8/4/14
 */

import java.util.ArrayList;
import java.util.Stack;

public class Cards {

	private int myValue;
	private String mySuit;
	private String myFace;
	
	// this constructor makes the numbered cards
	public Cards(int value, String suit) {
		myValue = value;
		mySuit = suit;
	}
	
	// this constructor makes the face cards
	public Cards(int value, String face, String suit){
		myValue = value;
		mySuit = suit;
		myFace = face;
	}
	
	// generic constructor
	public Cards(){
		
	}
	
	// gets the value of the card
	public int getValue(){
		return myValue;
	}
	
	// gets the suit
	public String getSuit(){
		return mySuit;
	}
	
	// gets the face (if there is one)
	public String getFace(){
		return myFace;
	}
	
	//creates a deck of cards in an ArrayList
	public void populateArrayList(ArrayList<Cards> cards, String[] suits, String[] faces){
		for(int suit = 0; suit < 4; suit ++){
			for(int value = 2; value <= 10; value++){
				cards.add(new Cards(value, suits[suit]));
			}
		}
		for(int suit = 0; suit < 4; suit++){
			for(int face = 0; face < 3; face++){
				cards.add(new Cards(10, faces[face], suits[suit]));
			}
		}
	}
	
	// populates the stack of cards
	public void populateStack(Stack<Cards>deck, String[] suits, String[] faces){
		for(int suit = 0; suit < 4; suit ++){
			for(int value = 2; value <= 10; value++){
				deck.push(new Cards(value, suits[suit]));
			}
		}
		
		for(int suit = 0; suit < 4; suit++){
			for(int face = 0; face <= 2; face++){
				deck.push(new Cards(10, faces[face], suits[suit]));
			}
		}
		
		for(int suit = 0; suit < 4; suit++){
			deck.push(new Cards(11, "Ace", suits[suit]));
		}
	}
	
	public void shuffle(Stack<Cards> deck){
		int n = deck.size();
		for(int index = 0; index < n; index++){
			int r = index + (int) (Math.random() * (n - index));
			Cards swap = deck.get(r);
			Cards swap1 = deck.get(index);
			deck.set(index, swap);
			deck.set(r, swap1);
		}
	}
	
	// draws a card from the stack of cards
	public Cards drawCard(Stack<Cards> deck){
		return deck.pop();
	}
	
	// prints out the deck from the ArrayList for testing purposes
	public void printDeck(ArrayList<Cards> cards){
		for(int index = 0; index < cards.size(); index ++){
			if(cards.get(index).getValue() == 11){
				System.out.println(cards.get(index).getFace() + " of " + cards.get(index).getSuit());
			} else{
			System.out.println(cards.get(index).getValue() + " of " + cards.get(index).getSuit());
			}
		}
	}
	
	// prints out the deck from the Stack for testing purposes
	public void printDeck(Stack<Cards> deck){
		for(int index = 0; index < deck.size(); index++){
			if(deck.get(index).getValue() == 11){
				System.out.println(deck.get(index).getFace() + " of " + deck.get(index).getSuit());
			} else if(deck.get(index).getValue() == 10 && !(deck.get(index).getFace() == null)){
				System.out.println(deck.get(index).getFace() + " of " + deck.get(index).getSuit());
			} else{
				System.out.println(deck.get(index).getValue() + " of " + deck.get(index).getSuit());
			}
		}
	}
	
	// prints the first hand that is drawn
	public void printFirstHand(ArrayList<Cards> hand){
		if(hand.get(0).getValue() >= 10 && hand.get(1).getValue() >= 10 && hand.get(0).getFace() != null && hand.get(1).getFace() != null){
			System.out.println(hand.get(0).getFace() + " of " + hand.get(0).getSuit() + " and a " + hand.get(1).getFace() + " of " + hand.get(1).getSuit());
		}else if(hand.get(0).getValue() == 10 && hand.get(1).getValue() == 10 && hand.get(0).getFace() == null && hand.get(1).getFace() == null){
			System.out.println(hand.get(0).getValue() + " of " + hand.get(0).getSuit() + " and a " + hand.get(1).getValue() + " of " + hand.get(1).getSuit());
		}else if(hand.get(0).getValue() == 10 && hand.get(1).getValue() >= 10 && hand.get(0).getFace() == null){
			System.out.println(hand.get(0).getValue() + " of " + hand.get(0).getSuit() + " and a " + hand.get(1).getFace() + " of " + hand.get(1).getSuit());
		}else if(hand.get(0).getValue() >= 10 && hand.get(1).getValue() == 10 && hand.get(1).getFace() == null){
			System.out.println(hand.get(0).getFace() + " of " + hand.get(0).getSuit() + " and a " + hand.get(1).getValue() + " of " + hand.get(1).getSuit());
		}else if(hand.get(0).getValue() >=10 && hand.get(1).getFace() == null){
			System.out.println(hand.get(0).getFace() + " of " + hand.get(0).getSuit() + " and a " + hand.get(1).getValue() + " of " + hand.get(1).getSuit());
		}else if(hand.get(0).getFace() == null && hand.get(1).getValue() >= 10 && hand.get(1).getFace() == null){
			System.out.println(hand.get(0).getValue() + " of " + hand.get(0).getSuit() + " and a " + hand.get(1).getValue() + " of " + hand.get(1).getSuit());
		}else if(hand.get(1).getValue() == 10 && hand.get(1).getFace() == null && hand.get(0).getFace() == null){
			System.out.println(hand.get(0).getValue() + " of " + hand.get(0).getSuit() + " and a " + hand.get(1).getValue() + " of " + hand.get(1).getSuit());
		}else if(hand.get(0).getValue() == 10 && hand.get(0).getFace() == null && hand.get(1).getFace() == null){
			System.out.println(hand.get(0).getValue() + " of " + hand.get(0).getSuit() + " and a " + hand.get(1).getValue() + " of " + hand.get(1).getSuit());
		}else if(hand.get(1).getFace() == null && hand.get(0).getValue() > 10){
			System.out.println(hand.get(0).getValue() + " of " + hand.get(0).getSuit() + " and a " + hand.get(1).getFace() + " of " + hand.get(1).getSuit());
		}else if(hand.get(0).getFace() == null && hand.get(1).getFace() == null && hand.get(0).getValue() == 10){
			System.out.println(hand.get(0).getValue() + " of " + hand.get(0).getSuit() + " and a " + hand.get(1).getValue() + " of " + hand.get(1).getSuit());
		}else if(hand.get(0).getFace() == null && hand.get(1).getValue() == 11){
			System.out.println(hand.get(0).getValue() + " of " + hand.get(0).getSuit() + " and a " + hand.get(1).getFace() + " of " + hand.get(1).getSuit());
		}
		else{
			System.out.println(hand.get(0).getValue() + " of " + hand.get(0).getSuit() + " and a " + hand.get(1).getValue() + " of " + hand.get(1).getSuit());
		}
	}
	
	// prints each card after the first hand
	public void printCard(ArrayList<Cards> hand, int index){
		if(hand.get(index).getValue() >=10 && hand.get(index).getFace() != null){
			System.out.println(hand.get(index).getFace() + " of " + hand.get(index).getSuit());
		}else{
			System.out.println(hand.get(index).getValue() + " of " + hand.get(index).getSuit());
		}
	}
	
	public void printTotal(int total){
		System.out.println();
		System.out.println("Your total is " + total);
	}
}
