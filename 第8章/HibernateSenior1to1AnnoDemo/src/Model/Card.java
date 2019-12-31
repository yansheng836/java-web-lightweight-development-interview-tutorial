package Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Card")
public class Card {
	
	@Id
	@Column(name = "CardID")
	private String CardID;
	@Column(name = "Bank")
	private String Bank;
	@Column(name = "Balance")
	private float Balance;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "PersonID")
	private Person person;
	
	public String getCardID() {
		return CardID;
	}
	public void setCardID(String cardID) {
		CardID = cardID;
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
