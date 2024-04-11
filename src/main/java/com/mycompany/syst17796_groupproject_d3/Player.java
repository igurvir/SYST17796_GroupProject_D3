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
    private String name;
    private GroupOfCards hand;

    public Player(String name) {
        this.name = name;
        this.hand = new GroupOfCards();
    }

    public String getName() {
        return name;
    }

    public GroupOfCards getHand() {
        return hand;
    }

    public void drawCard(Card card) {
        hand.addCard(card);
    }

    public Card playCard() {
        return hand.drawCard();
    }
}
