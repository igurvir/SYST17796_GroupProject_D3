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


class WarPlayer extends Player {
    private final ArrayList<Card> hand;

    public WarPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
    }

    public void drawCard(Card card) {
        hand.add(card);
    }

    public Card playCard() {
        if (!hand.isEmpty()) {
            return hand.remove(0);
        }
        return null;
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }

    public int getHandSize() {
        return hand.size();
    }
}
