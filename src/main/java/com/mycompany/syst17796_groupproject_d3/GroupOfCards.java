/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.syst17796_groupproject_d3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author gurvir
 */
public class GroupOfCards {
    // Declare a private instance variable to store the list of cards in the group
    private List<Card> cards;
    
    // Constructor method to initialize a GroupOfCards object
    public GroupOfCards() {
        this.cards = new ArrayList<>(); // Initialize the cards as an empty ArrayList
    }

    // Method to add a card to the group
    public void addCard(Card card) {
        cards.add(card);
    }

    // Method to shuffle the cards in the group
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Method to draw a card from the group
    public Card drawCard() {
        // Check if there are no cards left in the group
        if (cards.isEmpty()) {
            return null; // No cards left in the group
        }
        return cards.remove(0);
    }
    // Method to get the number of cards in the group
    public int size() {
        return cards.size();
    }
    // Method to check if the group is empty
    public boolean isEmpty() {
        return cards.isEmpty(); //since boolean it will return true or false
    }
}
