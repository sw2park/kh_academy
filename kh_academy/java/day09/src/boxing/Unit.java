package boxing;

public class Unit {
	private String name;

	public Unit(String name) {
		super(); // 자바의 최상위 클래스 > Object의 생성자를 가르키고 있음
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void attack() {
		System.out.println(this.name + " >> 공격 준비");
	}
}