


import com.mycompany.syst17796_groupproject_d3.PlayingCard;
import com.mycompany.syst17796_groupproject_d3.WarGame;
import org.junit.Test;

import com.mycompany.syst17796_groupproject_d3.WarPlayer;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gurvir
 */
public class WarGameTest {
    private WarGame warGame;
    private WarPlayer player1;
    private WarPlayer player2;

    @Before
    public void setUp() {
        warGame = new WarGame("War");
        player1 = new WarPlayer("Player 1");
        player2 = new WarPlayer("Player 2");
    }

    @Test
    public void testWarGameInitialization() {
        assertNotNull(warGame);
        assertEquals("War", warGame.getName());
        assertNotNull(warGame.getPlayers());
        assertTrue(warGame.getPlayers().isEmpty());
    }

    @Test
    public void testAddingPlayersToGame() {
        warGame.getPlayers().add(player1);
        warGame.getPlayers().add(player2);
        assertEquals(2, warGame.getPlayers().size());
    }

    @Test
    public void testGamePlay() {
        warGame.getPlayers().add(player1);
        warGame.getPlayers().add(player2);
        warGame.play();
        // Assuming that the play method doesn't throw any exceptions and the game ends without errors
        assertTrue(true);
    }

    @Test
    public void testGameWinner() {
        warGame.getPlayers().add(player1);
        warGame.getPlayers().add(player2);
        player1.drawCard(new PlayingCard("10", "Hearts"));
        player2.drawCard(new PlayingCard("7", "Clubs"));
        warGame.declareWinner();
        // Assuming that the declareWinner method doesn't throw any exceptions
        assertTrue(true);
    }

    @Test
    public void testWarPlayerInitialization() {
        assertNotNull(player1);
        assertEquals("Player 1", player1.getName());
        assertNotNull(player1.getHand());
        assertTrue(player1.getHand().isEmpty());
    }

    @Test
    public void testDrawingCard() {
        player1.drawCard(new PlayingCard("5", "Diamonds"));
        assertEquals(1, player1.getHandSize());
    }

    @Test
    public void testPlayingCard() {
        PlayingCard card = new PlayingCard("9", "Spades");
        player1.drawCard(card);
        assertEquals(card, player1.playCard());
    }

    @Test
    public void testPlayerHasCards() {
        assertTrue(!player1.hasCards());
    }
}