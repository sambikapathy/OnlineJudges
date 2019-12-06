package LeetCode;

public class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        int x=0;
        int o=0;
        boolean xv = false;
        boolean ov = false;
        for(String word : board){
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(c=='X'){
                    x++;
                }else if(c=='O'){
                    o++;
                }
            }
            if("XXX".equals(word)){
                xv=true;
            }else if("OOO".equals(word)){
                ov=true;
            }
        }

        for(int i=0;i<3;i++){
            StringBuilder temp = new StringBuilder();
            for(int j=0;j<3;j++){
                temp.append(board[j].charAt(i));
            }
            String t = temp.toString();
            if("XXX".equals(t)){
                xv=true;
            }else if("OOO".equals(t)){
                ov=true;
            }
        }

        String t = ""+board[0].charAt(0)+board[1].charAt(1)+board[2].charAt(2);
        if("XXX".equals(t)){
            xv=true;
        }else if("OOO".equals(t)){
            ov=true;
        }

        t = ""+board[0].charAt(2)+board[1].charAt(1)+board[2].charAt(0);
        if("XXX".equals(t)){
            xv=true;
        }else if("OOO".equals(t)){
            ov=true;
        }

        if(o > x || x-1>o || (ov && xv)){
            return false;
        }
        if(xv && !ov && o==x){
            return false;
        }
        if(x>o && ov){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String []input = {"XXX","OOX","OOX"};
        System.out.println(new ValidTicTacToeState().validTicTacToe(input));
    }
}
