package Model;

public class Person {

    private String ID;
    private String Name;
    private String Phone;
    //体现一对一的关系。保存映射类的实例对象。
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
