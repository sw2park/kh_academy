package interfaceClass;

public class Main01 {
	public static void main(String[] args) {
		Character player = new Character("플레이어");
		Monster monster = new Monster("몬스터");
		
		player.attack();
		player.walk();
		player.run();
		player.jump();
		player.attack();
		player.shield();
		player.pickup();
		
		monster.walk();
		monster.run();
		monster.jump();
		monster.attack();
		monster.shield();
	}
}