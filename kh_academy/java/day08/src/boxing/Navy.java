package boxing;

public class Navy extends Unit {

	public Navy(String name) {
		super(name);
	}
	
	@Override
	public void attack() {
		super.attack();
		System.out.println(super.getName() + " >> Navy 공격 실행!");
	}
	
	public void nucleus() {
		System.out.println(super.getName() + " >> 핵미사일 공격!");
	}
}
