
public class CardDealer {

	public static void main(String[] args){

		DeckOfCards LV = new DeckOfCards();

		System.out.println(LV.toString());

		LV.shuffle();

		System.out.println(LV.toString());

		while (LV.numCardsRemaining() > 0)
		{
			System.out.println("Drawing cards...");
			Card player1 = LV.draw();
			Card player2 = LV.draw();
			
			System.out.println("Player 1: " + player1);
			System.out.println("Player 2: " + player2);
			if (player1.compareTo(player2) > 0) 
			{
				System.out.println("Player 1 wins!");
			}
			else if (player2.compareTo(player1) > 0) 
			{
				System.out.println("Player 2 wins!");
			}
			else 
			{
				System.out.println("It's a draw!");
			}
			System.out.println();
		}

		
		LV.restoreDeck();
		
		System.out.println(LV.toString());
		
		

	}
}
