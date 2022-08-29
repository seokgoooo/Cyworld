package visitor.model;

public class Writer {
	private Integer user_num;
	private String name;
	

	public Writer(Integer user_num, String name) {
		this.user_num = user_num;
		this.name = name;
	}

	
	public Integer getUser_num() {
		return user_num;
	}


	public String getName() {
		return name;
	}
		
	
}
