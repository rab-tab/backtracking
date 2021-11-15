import java.util.ArrayList;
import java.util.List;

public class NQueens {
    static int n=4;
    public static void main(String[] args) {
        nQueens(n);
    }

    public static List<List<Integer>> nQueens(int n)
    {
        List<List<Integer>> result=new ArrayList<>();
        solveNQueens(n,0,new ArrayList<Integer>(),result);
        return result;
    }


    public static boolean isValid(List<Integer> cellPlacements)
    {

        int rowId=cellPlacements.size()-1;
        for(int i=0;i<rowId;i++)
        {
            int diff=Math.abs(cellPlacements.get(i)-cellPlacements.get(rowId));
            if(diff == 0 || diff==rowId-i) return false;
        }
        return true;
    }

    public static void solveNQueens(int n,int row,List<Integer> cellPlacements,List<List<Integer>> result)
    {
        if(row==n)
            result.add(new ArrayList<>(cellPlacements));
        else
        {
            for(int col=0;col<n;col++)
            {
                if(isValid(cellPlacements))
                {
                    solveNQueens(n,row+1,cellPlacements,result);
                }
                cellPlacements.remove(cellPlacements.size()-1);
            }
        }

    }
}
