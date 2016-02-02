package LeetCode;

public class BulbSwitcher {

	public static void main(String[] args) {
		int count = 10;
		boolean[] array = new boolean[count+1];
		for (int i = 1; i <= count; i++) {
			for (int j = 1; j*i <= count; j++) {
				array[j*i] = !array[j*i];
			}
		}
		
		print(count , array);
	}

	 static  void print(int count , boolean []array){
		for (int i = 1; i <= count; i++) {
			if (array[i])
				System.out.print("on,");
			else {
				System.out.print("off,");
			}
		}
		System.out.println();
	}
}
