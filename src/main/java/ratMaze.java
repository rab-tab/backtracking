public class ratMaze {
    static int size=3;
    static int[][] solArr;
    static int rows=3;
    static int cols=3;
    public static void main(String[] args) {
        int arr[][]=new int[3][3];
        solArr=new int[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                solArr[i][j]=0;
            }
        }
        System.out.println(ratInMaze(arr,0,0,solArr));
    }

    public static boolean ratInMaze(int arr[][],int row ,int col,int[][] solArr)
    {
        if(row==size-1 && col==size-1) {
            solArr[row][col]=1;
            return true;
        }
        if(isSafe(arr,row,col,size)){
            solArr[row][col]=1;
            //move in right direction
            if(ratInMaze(arr,row+1,col,solArr)) return true;
            //move in down direction
            if(ratInMaze(arr,row,col+1,solArr)) return true;
            // if moving in both right and down direction didnt yield any result we backtrack
            solArr[row][col]=0;
            return false;
        }
        return false;

    }
    public static boolean isSafe(int[][] arr,int row,int col,int size)
    {
        if(arr[row][col]==1 && row<size && col<size)
            return true;
        return false;
    }


}
