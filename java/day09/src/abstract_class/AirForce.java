package abstract_class;

public class AirForce extends Unit{

	public AirForce(String name) {
		super(name);
	}

	@Override
	public void attack() {
		System.out.println(this.getName() + " >> 공군 공격");
	}

	@Override
	public void move() {
		System.out.println(this.getName() + " >> 공군 이동");
	}
}