package LeetCode;

public class BuddyString {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length() || A.length() < 2){
            return false;
        }
        int []a = new int[26];
        int []b = new int[26];
        int count =0;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i) != B.charAt(i)){
                count++;
            }
            a[A.charAt(i)-'a']++;
            b[B.charAt(i)-'a']++;
            if(count > 2){
                return false;
            }
        }
        if(count ==0){
            for(int i=0;i<26;i++){
                if(a[i] > 0 && a[i]%2==0){
                    return true;
                }
            }
            return false;
        }else if(count==1){
            return false;
        }

        for(int i=0;i<26;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        BuddyString buddyString = new BuddyString();
        String []input={"ab","ab"};
        System.out.println(buddyString.buddyStrings(input[0],input[1]));

    }
    //ab ab
}
