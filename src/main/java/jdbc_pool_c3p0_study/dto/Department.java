package jdbc_pool_c3p0_study.dto;

public class Department {
	//DB명과 크게 상관없지만 type은 반드시!
	private int deptNo;	//부서번호
	private String deptName;	//부서명
	private int floor;	//층
	
	//생성자 만들기(generate Constructors using superclass)
	public Department() {
		// TODO Auto-generated constructor stub
	}

	//using field
	public Department(int deptNo) {
		this.deptNo = deptNo;
	}

	public Department(int deptNo, String deptName, int floor) {
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.floor = floor;
	}
	
	

	//getter, setter
	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	
	//toString
	@Override
	public String toString() {
		return String.format("Department [deptNo=%s, deptName=%s, floor=%s]", deptNo, deptName, floor);
	}
	
}
