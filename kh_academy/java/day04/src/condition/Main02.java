package condition;

public class Main02 {

	public static void main(String[] args) {
		int age = 26;
		// 만약 age가 21살 이상이면, "Beer"를 반환하고
		// 그렇지 않다면 "Juice"를 반환해라
		String beverage = (age>=21) ? "Beer": "Juice";
		System.out.println(beverage);
	}
}
