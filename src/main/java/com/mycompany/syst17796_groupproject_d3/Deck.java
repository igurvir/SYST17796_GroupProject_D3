/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.syst17796_groupproject_d3;

/**
 *
 * @author gurvir
 */
public class Deck extends GroupOfCards {
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public Deck() {
        generateDeck();
    }

    private void generateDeck() {
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                getCards().add(new PlayingCard(rank, suit));
            }
        }
    }
}
