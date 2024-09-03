package abstract_class;

public class Army extends Unit {

	public Army(String name) {
		super(name);
	}

	@Override
	public void attack() {
		System.out.println(this.getName() + " >> 육상 공격");
	}

	@Override
	public void move() {
		System.out.println(this.getName() + " >> 육상 이동");
	}
}