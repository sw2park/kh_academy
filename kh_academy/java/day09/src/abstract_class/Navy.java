package abstract_class;

public class Navy extends Unit {

	public Navy(String name) {
		super(name);
	}

	@Override
	public void attack() {
		System.out.println(this.getName() + " >> 해군 공격");
	}

	@Override
	public void move() {
		System.out.println(this.getName() + " >> 해군 이동");
	}
}