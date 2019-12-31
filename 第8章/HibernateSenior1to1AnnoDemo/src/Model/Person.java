package Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Person")
public class Person {

	@Id
	@Column(name = "ID")
	private String ID;
	
	@Column(name = "Name")
    private String Name;
	@Column(name = "Phone")
    private String Phone;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CardID")
    private Card card;
    
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	  
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
    
        
	
}
