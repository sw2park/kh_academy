package boxing;

public class AirForce extends Unit{

	public AirForce(String name) {
		super(name);
	}
	
	@Override
	public void attack() {
		super.attack();
		System.out.println(super.getName() + " >> AirForce 공격 실행!");
	}
	
	public void bombing() {
		System.out.println(super.getName() + " >> 폭격 실행!");
	}
}