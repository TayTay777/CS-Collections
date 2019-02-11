/**
 * Demo of the ordinal values for an eanum type.
 * @author amit
 */

public class SuitTest {

	public enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES};

	public static void main (String[] args) {
		Suit card = Suit.CLUBS;
		System.out.println("ordinal value = " + card.ordinal() + " " + card);

		card = Suit.DIAMONDS;
		System.out.println("ordinal value = " + card.ordinal() + " " + card);

		card = Suit.HEARTS;
		System.out.println("ordinal value = " + card.ordinal() + " " + card);

		card = Suit.SPADES;
		System.out.println("ordinal value = " + card.ordinal() + " " + card);
	}
}
