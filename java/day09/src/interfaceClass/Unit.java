package interfaceClass;

// 인터페이스를 정의하는 형식
public interface Unit {
	/*
	 * 기본적으로 인터페이스에 추사되는 모든 메서드는
	 * 추상 메서드이기 때문에, 'abstract' 키워드를 명시할 필요가 없다.
	 */
	public void attack();
	public void shield();
}