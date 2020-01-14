package abc;

public class StudentModel {
	private String usn;
	private String name;
	private String dept;
	private String colg;
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getColg() {
		return colg;
	}
	public void setColg(String colg) {
		this.colg = colg;
	}
	@Override
	public String toString() {
		return "StudentModel [usn=" + usn + ", name=" + name + ", dept=" + dept + ", colg=" + colg + "]";
	}
		
}
