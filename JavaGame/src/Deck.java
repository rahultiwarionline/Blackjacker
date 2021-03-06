/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joe Parkhill
 */
import java.util.ArrayList;
public class Deck 
{
    private ArrayList<CardObject> deck = new ArrayList<>();
    private int cards;
    
    public Deck()
    {
        //Keeps track of the cards in the deck
        cards = 52;

        
        //The deck is instantiated with two nested for loops
        //The first for loop is to run through each of the suits
        //The second for loop is to run through each of the face values
        for(int i = 1; i < 5; i++)
        {
            for(int j = 1; j < 14; j++)
            {
                deck.add(new CardObject(j,i));
            }
            
            
        }
    }
    
    public void Shuffle()
    {
        
        //A copy of the deck is created to transfer cards
        ArrayList<CardObject> DummyDeck = new ArrayList<>();
        
        
        //Here every card of the array list is removed
        //it will then have CardObjects from the DummyDeck added to it
        int i = 0;
        while(deck.size() > 0)
        {
            //A random card is selected from the original deck and added to the
            //the new DummyDeck while being removed from the old deck, this
            //randomizes the order in the DummyDeck.
            int Random = (int) (Math.random() * (deck.size()));
            DummyDeck.add(deck.remove(Random));   
        }
        //Now the original deck is equal to the DummyDeck
        deck = DummyDeck;
    }

    public CardObject Draw()
    {
        ArrayList<CardObject> DummyDeck = new ArrayList<>();
        for (CardObject deck1 : deck) {
            //The DummyDeck now has all of the same card values as the original
            //deck.
            DummyDeck.add(deck1);
        }
        //The card drawn is removed.
        deck.remove(0);
        
        cards = deck.size();
        //The card drawn is returned.
        return DummyDeck.get(0);
    }
    
    
    public void Repopulate()
    {
        //The deck is remade the way it's made in the constructor
        //it is not preshuffled.
        for(int i = 1; i < 5; i++)
        {
            for(int j = 1; j < 14; j++)
            {
                deck.add(new CardObject(j,i));
            }
            
            
        }
        
        cards = deck.size();
    }
    
    public ArrayList<CardObject> mergeDecks(ArrayList<Deck> d)
    {
        //You create an ArrayList of the extra decks, which are then added to
        //this deck
        ArrayList<CardObject> DummyDeck = new ArrayList<>();
        for (CardObject deck1 : deck) {
            //The DummyDeck now has all of the same card values as the original
            //deck.
            DummyDeck.add(deck1);
        }
        
        for (Deck d1 : d) {
            //The second for loop cycles through the cards in each deck in the ArrayList of decks
            for (int j = 0; j < d1.returnCard(); j++) {
                DummyDeck.add(d1.getCard(j));
            }
        }
        
        return deck = DummyDeck;
    }
    
    public int returnCard()
    {
        //returns the amount of cards in the deck
        return cards;
    }
    
    public CardObject getCard(int i)
    {
        //returns the card at index i
        return deck.get(i);
    }
}
