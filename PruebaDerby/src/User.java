
public class User 
{
	private int id, phone, routineId;
	private String name, lastName, mail;
	
	public User() {}
	
	public User(int id, String name, String lastName, int phone, String mail, int routineId)
	{
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.mail = mail;
		this.routineId=routineId;						
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getRoutineId() {
		return routineId;
	}

	public void setRoutineId(int routineId) {
		this.routineId = routineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
		
}
