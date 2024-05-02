import junit.framework.TestCase;

public class StudentTests extends TestCase {
	public void testHasPair() {
		Card[] myCard = new Card[5];
		myCard[0] = new Card(1, 1);
		myCard[1] = new Card(2, 3);
		myCard[2] = new Card(1, 3);
		myCard[3] = new Card(2, 1);
		myCard[4] = new Card(8, 1);
		assertTrue(PokerHandEvaluator.hasPair(myCard));
	}

	public void testHasTwoPair() {
		Card[] myCard = new Card[5];
		myCard[0] = new Card(1, 1);
		myCard[1] = new Card(2, 3);
		myCard[2] = new Card(1, 3);
		myCard[3] = new Card(2, 1);
		myCard[4] = new Card(8, 1);
		assertTrue(PokerHandEvaluator.hasTwoPair(myCard));
	}

	public void testThreeOfAKind() {
		Card[] myCard = new Card[5];
		myCard[0] = new Card(1, 1);
		myCard[1] = new Card(2, 3);
		myCard[2] = new Card(2, 0);
		myCard[3] = new Card(2, 1);
		myCard[4] = new Card(8, 1);
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(myCard));
	}

	public void testHasStraight() {
		Card[] myCard = new Card[5];
		myCard[0] = new Card(1, 1);
		myCard[1] = new Card(2, 3);
		myCard[2] = new Card(3, 0);
		myCard[3] = new Card(4, 1);
		myCard[4] = new Card(5, 1);
		assertTrue(PokerHandEvaluator.hasStraight(myCard));
	}

	public void testHasFlush() {
		Card[] myCard = new Card[5];
		myCard[0] = new Card(1, 1);
		myCard[1] = new Card(2, 1);
		myCard[2] = new Card(3, 1);
		myCard[3] = new Card(4, 1);
		myCard[4] = new Card(5, 1);
		assertTrue(PokerHandEvaluator.hasFlush(myCard));
	}

	public void testHasFullHouse() {
		Card[] myCard = new Card[5];
		myCard[0] = new Card(1, 1);
		myCard[1] = new Card(2, 1);
		myCard[2] = new Card(1, 3);
		myCard[3] = new Card(2, 1);
		myCard[4] = new Card(2, 2);
		assertTrue(PokerHandEvaluator.hasFullHouse(myCard));
	}

	public void testHasFourOfAKind() {
		Card[] myCard = new Card[5];
		myCard[0] = new Card(1, 0);
		myCard[1] = new Card(1, 1);
		myCard[2] = new Card(1, 3);
		myCard[3] = new Card(2, 1);
		myCard[4] = new Card(1, 2);
		assertTrue(PokerHandEvaluator.hasFourOfAKind(myCard));
	}

	public void testHasStraightFlush() {
		Card[] myCard = new Card[5];
		myCard[0] = new Card(1, 0);
		myCard[1] = new Card(2, 0);
		myCard[2] = new Card(3, 0);
		myCard[3] = new Card(4, 0);
		myCard[4] = new Card(5, 0);
		assertTrue(PokerHandEvaluator.hasStraightFlush(myCard));
	}
}
