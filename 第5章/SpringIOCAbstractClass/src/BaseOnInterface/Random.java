package BaseOnInterface;

public class Random {
	private int randomNum = (int) (50 * Math.random());

	public void printRandom() {
		System.out.println(randomNum);
	}
}
