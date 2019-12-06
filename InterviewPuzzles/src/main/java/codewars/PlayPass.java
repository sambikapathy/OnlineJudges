package codewars;

public class PlayPass {
    public static String playPass(String s, int n) {
        // your code
        char[] inp = s.toCharArray();
        for(int i=0;i<inp.length;i++){
            if(inp[i] >='A' && inp[i] <='Z'){
                int val = inp[i]+n-'A';
                if(val > 25){
                    val -=26;
                }
                inp[i] = (char) ('A'+ val);
            } else if(inp[i] >='0' && inp[i] <='9'){
                int val = '9'-inp[i];
                inp[i] = (char)('0'+val);
            }
        }

        for(int i=0;i<inp.length;i++){
            if(i%2==0){

            }else{
                if(inp[i] >='A' && inp[i] <='Z') {
                    inp[i] = (char) ((inp[i] - 'A') + 'a');
                }
            }
        }

        StringBuilder two = new StringBuilder(new String(inp));
        return two.reverse().toString();

    }

    public static void main(String[] args) {
//        System.out.println( playPass("MY GRANMA CAME FROM NY ON THE 23RD OF APRIL 2015",2));
        //!!!vPz fWpM J
        System.out.println(longestCommonPrefix(new String[]{"f","flowe"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(prefix) != 0 && prefix.length() > 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}