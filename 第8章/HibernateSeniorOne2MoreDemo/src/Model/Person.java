package Model;

import java.util.List;

public class Person {

    private String ID;
    private String Name;
    private String Phone;
    //通过List来实现一对多
    private List<Card> cardList;
    
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
	public List<Card> getCardList() {
		return cardList;
	}
	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}
	
    
        
	
}
