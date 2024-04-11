/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.syst17796_groupproject_d3;

import java.util.ArrayList;

/**
 *
 * @author gurvir
 */


public class WarGame extends Game {
    private final Deck deck;

    public WarGame(String name) {
        super(name);
        deck = new Deck();
    }

    @Override
    public void play() {
        // Shuffle the deck before starting the game
        deck.shuffle();

        // Distribute cards among players
        ArrayList<Player> players = getPlayers();
        int numPlayers = players.size();
        int cardsPerPlayer = deck.size() / numPlayers;

        for (Player player : players) {
            WarPlayer warPlayer = (WarPlayer) player;
            for (int i = 0; i < cardsPerPlayer; i++) {
                Card card = deck.drawCard();
                if (card != null)
                    warPlayer.drawCard(card);
            }
        }

        // Play 10 rounds
        for (int round = 1; round <= 10; round++) {
            System.out.println("Round " + round + " begins!");

            // Each player plays a card
            Card[] playedCards = new Card[numPlayers];
            for (int i = 0; i < numPlayers; i++) {
                WarPlayer warPlayer = (WarPlayer) players.get(i);
                if (warPlayer.hasCards())
                    playedCards[i] = warPlayer.playCard();
                else
                    playedCards[i] = null;
            }

            // Display cards played by each player
            for (int i = 0; i < numPlayers; i++) {
                System.out.println(players.get(i).getName() + " plays: " + (playedCards[i] != null ? playedCards[i] : "No card"));
            }

            // Determine round winner
            int highestRank = -1;
            int winnerIndex = -1;
            for (int i = 0; i < numPlayers; i++) {
                if (playedCards[i] != null) {
                    PlayingCard playedCard = (PlayingCard) playedCards[i];
                    int rank = getCardRank(playedCard);
                    if (rank > highestRank) {
                        highestRank = rank;
                        winnerIndex = i;
                    }
                }
            }

            // Award the round winner all played cards
            if (winnerIndex != -1) {
                for (int i = 0; i < numPlayers; i++) {
                    if (playedCards[i] != null) {
                        WarPlayer warPlayer = (WarPlayer) players.get(winnerIndex);
                        warPlayer.drawCard(playedCards[i]);
                    }
                }
                System.out.println(players.get(winnerIndex).getName() + " wins the round!");
            } else {
                System.out.println("Round ends in a tie!");
            }
        }

        // Declare the winner
        declareWinner();
    }

    @Override
    public void declareWinner() {
        ArrayList<Player> players = getPlayers();
        int maxCards = 0;
        Player winner = null;

        for (Player player : players) {
            WarPlayer warPlayer = (WarPlayer) player;
            if (warPlayer.getHandSize() > maxCards) {
                maxCards = warPlayer.getHandSize();
                winner = warPlayer;
            }
        }

        if (winner != null) {
            System.out.println("The winner is: " + winner.getName());
        } else {
            System.out.println("The game ends in a tie!");
        }
    }

    private int getCardRank(PlayingCard card) {
        String rank = card.toString().split(" ")[0];
        switch (rank) {
            case "Ace":
                return 14;
            case "King":
                return 13;
            case "Queen":
                return 12;
            case "Jack":
                return 11;
            default:
                return Integer.parseInt(rank);
        }
    }
      public static void main(String[] args) {
        WarGame warGame = new WarGame("War");
        warGame.getPlayers().add(new WarPlayer("Player 1"));
        warGame.getPlayers().add(new WarPlayer("Player 2"));
        warGame.play();
    }
}