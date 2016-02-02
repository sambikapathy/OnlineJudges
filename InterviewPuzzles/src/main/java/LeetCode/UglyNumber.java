package LeetCode;

public class UglyNumber {

	public boolean isUgly(int num) {
        if(num == 1){
            return true;
        }
        
        int [] fact = {2,3,5};
        for(int i=0;i<fact.length && num > 1;){
            if(num%fact[i] == 0){
                num/=fact[i];
            }else{
                i++;
            }
        }
        if(num==1){
            return true;
        }else{
            return false;
        }
    }
  
  public int nthUglyNo(int n){
      int [] ugly = new int[n];
      ugly[0] = 1;
      int i = 2;
      int j = 3;
      int k = 5;
      int ii=1 , ji=1,ki=1;
      int current = 1;
      /*
      2 4 6 8 
      3 6 9 12
      5 10 15 20
      */
      int index = 1;
      while(index < n){
          int min = min(i , j , k);
          ugly[index] = min;
          if(min == i){
              ii++;
              i = ugly[ii]*2;
          }
          
          if(min == j){
              ji++;
              j = ugly[ji]*3;
          }
          
          if(min == k){
              ki++;
              k = ugly[ki]*5;
          }
          index++;
          current = min;
          System.out.println(current);
      }
      return current;
  }
  
  public int min(int i , int j , int k){
      // 6 , 3 , 12
      if(i < j){
          if(i < k){
              return i;
          }
          return k;
      }
      if(j < k){
          return j;
      }
      return k;
  }
    public int nthUglyNumber(int n) {
        return nthUglyNo(n);
        /*int count = 0;
        int no = 1;
        while(true){
            if(isUgly(no)){
                count++;
                if(count == n){
                    return no;
                }
            }
            no++;
        }
        */
    }
    
    public static void main(String[] args) {
    	int input = 250;
		System.out.println(new UglyNumber().nthUglyNumber(input));
	}
}
