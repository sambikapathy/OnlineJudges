public class FrogJump {

	public int solution(int X, int Y, int D) {
		return (int) Math.ceil(((double)Y-X)/D);
	}

	public static void main(String[] args) {
		System.out.println(new FrogJump().solution(10,10,30));
	}
}
