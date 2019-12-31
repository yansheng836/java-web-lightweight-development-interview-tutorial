package Model;

public class Card {
	
	private String CardID;
	private String PersonID;
	private String Bank;
	private float Balance;
	
	private Person person;
	
	public String getCardID() {
		return CardID;
	}
	public void setCardID(String cardID) {
		CardID = cardID;
	}
	public String getPersonID() {
		return PersonID;
	}
	public void setPersonID(String personID) {
		PersonID = personID;
	}
	public String getBank() {
		return Bank;
	}
	public void setBank(String bank) {
		Bank = bank;
	}
	public float getBalance() {
		return Balance;
	}
	public void setBalance(float balance) {
		Balance = balance;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	

	
}
