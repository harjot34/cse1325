import java.util.Stack;
import java.util.Collections;
import java.util.EmptyStackException;

public class Deck {

    // private Deck that return stack of cards;
    private Stack<Card> deck = new Stack<>();

    public Deck() {

        Card card = null;

        // String[] deckArray;
        // String[] deckArrayStrings = new String[30];

        String[] suit = { "U", "T", "A" };
        int[] rank = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                Rank rankObj = new Rank(rank[j]);
                card = new Card(Suit.valueOf(suit[i]), rankObj);
                deck.push(card);
            }
        }

    }

    public void shuffle() {
        Collections.shuffle(deck);
        System.out.print(" ");
        while (!deck.isEmpty()) {
            Card c = deal();
            System.out.print(c.toString() + " ");
        }

    }

    public Card deal() {
        Card card = null;
        if (isEmpty()) {
            throw new DeckEmptyException();
        } else {
            card = deck.pop();
        }

        return card;
    }

    public boolean isEmpty() {
        return deck.isEmpty() ? Boolean.TRUE : Boolean.FALSE;
    }

}
