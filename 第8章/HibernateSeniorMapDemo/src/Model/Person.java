package Model;

import java.util.Map;

public class Person {

    private String ID;
    private String Name;
    private String Phone;
    
    private Map <String,Card> cardMap;
    
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
	public Map<String, Card> getCardMap() {
		return cardMap;
	}
	public void setCardMap(Map<String, Card> cardMap) {
		this.cardMap = cardMap;
	}
	
        
	
}
