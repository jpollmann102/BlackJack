/*
 * This class runs the game
 * Josh Pollmann
 * 8/4/14
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Game {
	
	public static void main(String[] args){
		
		Stack<Cards> deck;
		deck = new Stack<Cards>();
		
		ArrayList<Cards> hand;
		hand = new ArrayList<Cards>();
		
		ArrayList<Cards> dealerHand;
		dealerHand = new ArrayList<Cards>();
		
		Cards c = new Cards();
		
		Scanner sc = new Scanner(System.in);

		String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
		String[] faces = {"Jack", "Queen", "King", "Ace"};
		
		int playerTotal = 0;
		int dealerTotal = 0;
		int index = 2;
		boolean playing = true;
		boolean dealer = true;
		boolean busted = false;
		boolean stay = false;
		String choice;
		
		c.populateStack(deck, suits, faces);
		c.shuffle(deck);	
		
		System.out.println("Welcome to Black Jack!");
		System.out.println();
		
		hand.add(c.drawCard(deck));
		hand.add(c.drawCard(deck));
		c.printFirstHand(hand);
		
		playerTotal += hand.get(0).getValue() + hand.get(1).getValue();
		
		if(playerTotal == 22){
			playerTotal -= 9;
		}
		
		if(playerTotal == 21){
			System.out.println();
			System.out.println("21!");
			playing = false;
		}else{
			System.out.println();
			System.out.println("Your total is " + playerTotal);
		}
		
		while(playing){
			if(playerTotal == 21){
				playing = false;
				dealer = false;
			}
			System.out.println();
			System.out.println("Would you like to hit, or stay?");
			choice = sc.nextLine();
			if(choice.equalsIgnoreCase("hit")){
				hand.add(c.drawCard(deck));
				playerTotal += hand.get(index).getValue();
				c.printCard(hand, index);
				c.printTotal(playerTotal);
			}else{
				playing = false;
			}
			if(playerTotal > 21 && hand.contains(c.getValue() == 11)){
				playerTotal -= 9;
			}else if(playerTotal == 21){
				System.out.println("21!");
				playing = false;
				dealer = false;
			}else if(playerTotal > 21){
				System.out.println("Bust! Better luck next time");
				playing = false;
				dealer = false;
			}
			else{
				index += 1;
			}
		}
		
		if(dealer){
			System.out.println("The dealer will draw until they either bust, or have at least 18");
			dealerHand.add(c.drawCard(deck));
			dealerHand.add(c.drawCard(deck));
			dealerTotal = dealerHand.get(0).getValue() + dealerHand.get(1).getValue();
			System.out.println("Dealer's initial total: " + dealerTotal);
			index = 2;
		}
		
		if(dealerTotal == 21){
			dealer = false;
			System.out.println("The dealer has gotten 21");
		}else if(dealerTotal > 21){
			dealerTotal -= 9;
		}else if(dealerTotal >= 18 && dealerTotal < 21){
			dealer = false;
			stay = true;
			System.out.println("The dealer stays at " + dealerTotal);
		}
		
		while(dealer){
			dealerHand.add(c.drawCard(deck));
			dealerTotal += dealerHand.get(index).getValue();
			System.out.println("Dealer's next total: " + dealerTotal);
			if(dealerTotal > 21 && dealerHand.contains(c.getValue() == 11)){
				dealerTotal -= 9;
			}else if(dealerTotal == 21){
				System.out.println("The dealer has gotten 21");
				dealer = false;
			}else if(dealerTotal > 21){
				System.out.println("The dealer has busted");
				dealer = false;
				busted = true;
			}else if(dealerTotal >= 18 && dealerTotal < 21){
				System.out.println("The dealer stays at " + dealerTotal);
				dealer = false;
				stay = true;
			}
		}
		
		if(busted){
			System.out.println("You have beaten the dealer because they have busted");
		}else if(stay){
			if(dealerTotal == playerTotal){
				System.out.println("You have tied with the dealer at " + playerTotal);
			}else if(dealerTotal > playerTotal){
				System.out.println("The dealer has beaten you with a total of " + dealerTotal);
			}else{
				System.out.println("You have beaten the dealer with a total of " + playerTotal);
			}
		}
	}
}
