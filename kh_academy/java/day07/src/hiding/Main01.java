package hiding;


class User{
	public String name = "홍길동";
	private int weight = 100;
}
public class Main01 {
	public static void main(String[] args) {
		User u = new User();
		// public 이므로 접근 가능
		System.out.println(u.name);
		// private 이므로 접근 불가능
		//System.out.println(u.weight);
	}
}






