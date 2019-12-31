public class AccountImpl implements Account {
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void add(int money) {
		
		System.out.println("给" +name+ "账户加钱 " + money + "元");
	}

	public void minus(int money) {
		System.out.println("从"+name+"账户扣钱: " + money + "元");
	}
}
