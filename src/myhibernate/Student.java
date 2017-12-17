package myhibernate;



public class Student {
	private String Studentname;
	private String StudentID;
	private String Birthday;
	private String Address;

	public String getStudentID() {
		return StudentID;
	}

	public void setStudentID(String id) {
		this.StudentID = id;
	}

	public String getStudentname() {
		return Studentname;
	}

	public void setStudentname(String name) {
		this.Studentname = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address= address;
	}

	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String date) {
		this.Birthday = date;
	}

}