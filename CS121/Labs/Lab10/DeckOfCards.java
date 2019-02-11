import java.util.Random;
import org.omg.Messaging.SyncScopeHelper;



public class DeckOfCards implements DeckOfCardsInterface{

	private Card[] deck;
	private final int DECKSIZE = 52;
	private int nextCardIndex = 0;



	/**creates & stores a deck of cards into an array called deck.
	 * 
	 */
	public DeckOfCards()
	{
		deck = new Card[DECKSIZE];
		int index = 0;
		for(Suit s : Suit.values()) {
			for(FaceValue v : FaceValue.values())
			{
				deck[index] = new Card(s,v);
				index++;
			}
		}
	}
	public void shuffle() {

		Random generator = new Random();

		//Attempt to swap each card with a random card in the deck.
		//This isn't a perfect random shuffle but it is a simple one.
		//A better shuffle requires a more complex algorithm.

		for (int i=0; i< deck.length; i++) {
			int j = generator.nextInt(deck.length);
			Card temp = deck[i];
			deck[i] = deck[j];
			deck[j] = temp;
		}

		//Reset instance variable that keeps track of dealt and remaining cards.
		nextCardIndex = 0;

	}

	@Override
	public Card draw() {
		if (nextCardIndex <= 52)
		{
			Card dC = deck[nextCardIndex];
			nextCardIndex++;
			return dC;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void restoreDeck() {
		{
			deck = new Card[DECKSIZE];
			int index = 0;
			for(Suit s : Suit.values()) {
				for(FaceValue v : FaceValue.values())
				{
					deck[index] = new Card(s,v);
					index++;
				}
			}
		}
		nextCardIndex = 0;
	}

	@Override
	public int numCardsRemaining() {
		int NumCR = DECKSIZE - (nextCardIndex);
		return NumCR;
	}

	@Override
	public int numCardsDealt() {
		int NumCD = nextCardIndex;
		return NumCD;
	}

	@Override
	public Card[] dealtCards() 
	{
		Card[] temp = new Card[nextCardIndex];
		for (int i = 0; i < nextCardIndex; i++) 
		{
			temp[i] = deck[i];
		}
		return temp;
	}

	@Override
	public Card[] remainingCards() {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString()
	{
		String bunchOfCards = "";
		for (int i = 0; i < DECKSIZE; i++)
		{
			bunchOfCards += (" " + deck[i] + " ");
			if ((i + 1) % 4 == 0 )
			{
				bunchOfCards += "\n";
			}
		}
		return bunchOfCards;
	}
}
