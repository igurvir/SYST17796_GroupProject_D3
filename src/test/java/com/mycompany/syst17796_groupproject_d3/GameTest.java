/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.syst17796_groupproject_d3;


import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.syst17796_groupproject_d3.Card;
import com.mycompany.syst17796_groupproject_d3.GroupOfCards;
import com.mycompany.syst17796_groupproject_d3.Player;

/**
 *
 * @author gurvir
 */
public class GameTest {

    // Test if a card is successfully created with the provided suit and rank
    @Test
    public void testCardCreation() {
        Card card = new Card("Hearts", "Ace");
        assertEquals("Hearts", card.getSuit());
        assertEquals("Ace", card.getRank());
    }

    // Test if adding a card to a group of cards increases its size
    @Test
    public void testAddCardToGroup() {
        GroupOfCards group = new GroupOfCards();
        Card card = new Card("Spades", "King");
        group.addCard(card);
        assertEquals(1, group.size());
    }

    // Test if shuffling a group of cards results in a different order
    @Test
    public void testShuffleCards() {
        GroupOfCards group1 = new GroupOfCards();
        GroupOfCards group2 = new GroupOfCards();

        // Add cards to both groups in the same order
        for (int i = 2; i <= 10; i++) {
            group1.addCard(new Card("Hearts", String.valueOf(i)));
            group2.addCard(new Card("Hearts", String.valueOf(i)));
        }

        // Shuffle one group
        group2.shuffle();

        // Check if the order is different
        assertNotEquals(group1.toString(), group2.toString());
    }

    // Test if drawing a card from an empty group of cards returns null
    @Test
    public void testDrawCardFromEmptyGroup() {
        GroupOfCards emptyGroup = new GroupOfCards();
        assertNull(emptyGroup.drawCard());
    }

    // Test if playing a card from a player's hand removes it from the hand
    @Test
    public void testPlayCard() {
        Player player = new Player("Player 1");
        GroupOfCards hand = player.getHand();
        Card card = new Card("Clubs", "Jack");
        hand.addCard(card);
        Card playedCard = player.playCard();
        assertNull(hand.drawCard()); // Hand should be empty after playing the card
        assertEquals(card, playedCard); // Played card should be the same as the one added to the hand
    }

    // Test if the game can be played without errors
    @Test
    public void testGamePlay() {
        SYST17796_GroupProject_D3 warGame = new SYST17796_GroupProject_D3("Player 1", "Player 2");
        warGame.start(); // Simply test if the game can start without throwing exceptions
    }
}