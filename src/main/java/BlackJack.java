package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJack extends CardGame {
    public BlackJack() {
        super();
        deck.shuffleDeck();
    }

    private void dealInitialCards() {
        generateHands(2, 2);
    }

    private int getHandValue(Hand hand) {
        int value = 0;
        int aces = 0;
        List<Card> cards = hand.getCards();
        for (Card c : cards) {
            value += c.getValue();
            if (c.getFace() == "A") {
                aces += 1;
            }
         }

        while (value>21 && aces!=0) {
            value-=10;
            aces-=1;
        }
        if (value>21 && aces==0) {
            return 0;
        }
        return value;
    }

    private int getWinningHand() {
       /* Returns -1 for a draw
        *  Otherwise returns index of winning hand
        */
       int handOneValue = getHandValue(getHand(0));
       int handTwoValue = getHandValue(getHand(1));
       if (handOneValue > handTwoValue) return 0;
       else if (handTwoValue > handOneValue) return 1;
       else return -1;
    }

    private void printWinner(int winnerIndex) {
        if (winnerIndex == -1) {
            System.out.println("Game is a draw!");
        } else if (winnerIndex == 0) {
            System.out.println("Player 1 wins!");
        } else if (winnerIndex == 1) {
            System.out.println("Player 2 wins!");
        }
    }

    private void printHands() {
        for(int i = 0; i < hands.size(); i++) {
            System.out.println("Player " + (i+1) + " cards: " + hands.get(i));
        }
    }

    @Override
    public void run() {
        dealInitialCards();
        List<Integer> stillPlaying = new ArrayList<Integer>(){{add(0);add(1);}};
        Scanner scan = new Scanner(System.in);
        while (stillPlaying.size()>0) {
            for (int i = 0; i<stillPlaying.size(); i++) {
                Hand hand = hands.get(stillPlaying.get(i));
                System.out.println(hand);
                System.out.println("Would you like another card? Y/N");
                String input = scan.nextLine();
                if (input.equals("Y")) {
                    hand.addCard(deck.dealCard());
                } else {
                    stillPlaying.remove(i);
                }
            }
        }
        printHands();
        int winningHand = getWinningHand();
        printWinner(winningHand);
    }
}
