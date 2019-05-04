package LeetCode;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int [][] cost = new int[n][m];
        cost[0][0] = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0&&j==0){
                    continue;
                }
                int temp = 0;
                if(j-1>=0){
                    temp+=cost[i][j-1];
                }

                if(i-1>=0){
                    temp+=cost[i-1][j];
                }
                cost[i][j] = temp;
            }
            print(cost,m,n);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(cost[i][j]+" ");
            }
            System.out.println();
        }
        return cost[n-1][m-1];
    }

    private void print(int [][]cost,int m, int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(cost[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new UniquePaths().uniquePaths(3,2);
    }
}
