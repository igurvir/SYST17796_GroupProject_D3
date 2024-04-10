/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.syst17796_groupproject_d3;

/**
 *
 * @author gurvir
 */
//Player class
public class Player {
    //private variables
    //ENCAPSULATION is done
    private String name;
    private GroupOfCards hand;

    public Player(String name) {
        //constructor for initializing the player object
        this.name = name;
        this.hand = new GroupOfCards(); //Initializing the player's hand as a new GroupOfCards object
    }
    //getter for name
    public String getName() {
        return name;
    }
//getter for hand 
    public GroupOfCards getHand() {
        return hand;
    }
    //Method to draw a card and add it to the player's hand
    public void drawCard(Card card) {
        hand.addCard(card); //Add the specified card to the player's hand
    }
    // Method to play a card from the player's hand
    public Card playCard() {
        return hand.drawCard(); // Draw and return a card from the player's hand
    }
}
