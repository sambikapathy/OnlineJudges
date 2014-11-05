package div2Level500;



public class NotTwo
{
	public int maxStones(int width, int height)
	{
		int [][] input = new int[height][width];
		int count = 0;
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				if(input[i][j] != -1){
					input[i][j] = 1;
					count++;
					if(i+2 < height){
						input[i+2][j] = -1;
					}
					if(j+2 < width){
						input[i][j+2] = -1;
					}
				}
			}
		}
		return count;
	}
	
	

	public static void main(String[] args) {
		int width = 3 ;
		int height = 2;
		System.out.println(new NotTwo().maxStones(width, height));
	}
}