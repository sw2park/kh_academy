package interfaceClass;

public class Monster implements Fight, Move{
	private String name;

	public Monster(String name) {
		super();
		this.name = name;
	}

	@Override
	public void walk() {
		System.out.println(this.name + "(이)가 걷고있습니다.");
	}

	@Override
	public void run() {
		System.out.println(this.name + "(이)가 뛰고있습니다.");
	}

	@Override
	public void jump() {
		System.out.println(this.name + "(이)가 점프하고 있습니다.");
	}

	@Override
	public void attack() {
		System.out.println(this.name + "(이)가 공격하고 있습니다.");
	}

	@Override
	public void shield() {
		System.out.println(this.name + "(이)가 방어하고 있습니다.");
	}
}