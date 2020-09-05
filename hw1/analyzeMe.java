import java.util.Random;

public class analyzeMe{
   
   public void insSort(int[] A, int t){ //t is a flag to tell it not to print the # of swaps
    int n = A.length;
    int s = 0; //# of swaps
    for(int i = 1; i < n; i++){         //Start of the actual algortihm
        int key = A[i];                 
        int j = i-1;                    
        while(j >= 0 && A[j] > key){    //loop checks to see if its in the correct position and swaps until it is
            A[j+1] = A[j];
            j = j-1;
            s++;
        }
    A[j+1] = key;
    
    }
    if(t == 1)                          //allows this to be reused without printing out # of swaps (only comes up so that the generated lists are in order initially)
        System.out.println("# of swaps: " + s);
   }

   public static boolean linSearch(int[] A, int key, int t){ //t is a flag to tell it not to print the # of checks
       int i = 0;
       int s = 0; //# of entries searched
       int n = A.length;
       while( i < n && A[i] != key){
           i++;
           s++;
       }
        if(t == 1)
            System.out.println("# of entries searched: " + s);
        if( i < n){
            if(t == 1)
                System.out.println("Search term: " + key + " has been found");  
            return true;
        }
        else{
            if(t == 1)
                System.out.println("Search term: " + key + " has NOT been found"); 
            return false;
        }
       
   }

    public static int[] makeArray(int n){
        Random ran = new Random();
        int[] A = new int[n];

        for(int i = 0; i < n; i++){
            A[i] = ran.nextInt(n*5);
        }

        analyzeMe sort = new analyzeMe();
        sort.insSort(A,0);                      //sorts the list to make it eaiser to get the initial precentage sorted
        return A;
    }
    public static int[] percentSorted(int[] A, int n, int p){   //n is array length, p is percentage sorted
        if(p == 0){             //handles edge cases

            for(int i = 0; i < n/2; i++){
                int tmp = A[i];
                A[i] = A[n - i -1];
                A[n - i - 1] = tmp;
            }
            return A;
        }
        if(p == 100){
             return A; 
        }
        Random ran = new Random();
        float pF = (float)p;                        //these 4 lines are for getting the number elements that need to be changed based on p
        float sortPerc = 1 - (pF/((float)100));
        float numChngf = n*sortPerc;
        int numChng = (int)numChngf;
        int[] protec = new int[numChng];    //used to make sure the random element isn't repeated
        int max = A[n-1];

        for(int i = 0; i < numChng; i++){
            int tmp = ran.nextInt(numChng);
            
            while(linSearch(protec, tmp, 0)){
                tmp = ran.nextInt(numChng);
            }
            A[tmp] = (ran.nextInt(5*n)) + max;    //changes the selected element to max plus a random number
        }
        return A;
    }
    static void printArray(int A[]){            //just an array printer, note it only prints out for 20 or less elements
        int n = A.length;
        if(n > 20)
            return;
        for (int i = 0; i < n; ++i) 
            System.out.print(A[i] + " "); 
  
        System.out.println(); 
    } 
    
    
   public static void main(String args[]){ 
        analyzeMe test = new analyzeMe();

        String FA = args[0]; //first argument for LS or IS check
        int SA = Integer.parseInt(args[1]); //lenth of array generated
        int TA = Integer.parseInt(args[2]); //percent sorted of that array

        int[] A = makeArray(SA);
        A = percentSorted(A, SA, TA); 

        if( FA.contains("IS") ){ 
            System.out.print("A initial: ");
            printArray(A);
            test.insSort(A,1); 
            System.out.print("A final: ");
            printArray(A);
        }
        else if( FA.contains("LS") ){
            System.out.print("A: ");
            printArray(A);
            FA = FA.replace("LS=", "");
            int N = Integer.parseInt(FA);
            linSearch(A, N, 1);
        }

   
    } 
}