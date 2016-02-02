package LeetCode;

public class FirstBadVersion {

//	2126753390 versions
//	1702766719 is the first bad version.
	 public static int firstBadVersion(int n) {
	        int s = 1 , e = n;
	        int prev = -1;
	        while(s <= e){
	            int mid = s+(e-s)/2;
	            System.out.println(mid);
	            if(isBadVersion(mid)){
	                prev = mid;
	                e = mid-1;
	            }else{
	                s = mid+1;
	            }
	        }
	        return prev;
	    }
	 
	 
	 private static boolean isBadVersion(int mid) {
		if(mid == 1702766719)
			return true;
		return false;
	}


	public static void main(String[] args) {
//		System.out.println(firstBadVersion(2126753390));
		for(int i=1;i<=100;i++){
			if(i%3==0 && i%5==0){
				System.out.println("fizz buzz");
			}else if(i%3==0){
				System.out.println("fizz");
			}else if(i%5 == 0){
				System.out.println("buzz");
			}else{
				System.out.println(i);
			}
		}
		
	}
}
