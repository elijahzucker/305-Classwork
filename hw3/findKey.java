import java.lang.Math;
import java.util.Arrays;

public class findKey{
    public static String findKey(String[][] A, int n, int key){ //n will be A[].length
        String S = "";
        int row = 0;
        int col = n-1;
        int count = 0;
        while(row <= n-1){
            count++;
            if(A[row][col].equals("I")){    //handles i
                A[row][col] = Integer.toString(key + 1);        //This is not the most efficient way to do these specific operations with the constant swapping between int and string
            }                                                   //however this dosn't change our big O and as these little things wern't what this class is about I left it as is
            if(Integer.parseInt(A[row][col]) == key){
                S = "("+(row+1)+")("+(col+1)+") "+", Entries Searched: "+count;
                return S;
            }
            if(Integer.parseInt(A[row][col]) < key){    //key is larger
                row++;
            }
            else{                                       //key is smaller
                col--;
            }

        }
        S = "Not Found, Entries Searched: "+count;
        return S;
    }

    public static String[][] arrayForm(String[] args){
        int count = 0;
        double sqrtN = Math.sqrt((double)args.length);
        int n = (int)Math.floor(sqrtN);    //this is the length of each row
        String[][] S = new String[n][n];
        for(int row = 0; row < n; row++){
            for(int column = 0; column < n; column++){
                if(args[count].contains(",")){
                    args[count] = args[count].substring(0,args[count].length()-1);
                }
                S[row][column] = args[count];
                count++;
            }
        }
        return S;
    }
   public static void main(String args[]){ 
        if(args[1].equals("I")){    //handles i
            System.out.println("Not Found");
        }
        else{
            int key = Integer.parseInt(args[0]);
            String[] argsNoKey = Arrays.copyOfRange(args, 1, args.length);
            String[][] A = arrayForm(argsNoKey);
            int n = A.length;
            System.out.println(findKey(A, n, key));
        }
    } 
}