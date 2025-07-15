package midterm;

public class Q10_ArrayToStringUtil {
    

    public static String arrayToString(int[] arr) {
        if (arr == null) {
            return "null";  
        }
        
        if (arr.length == 0) {
            return "[]";  
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");  

        
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");  
            }
        }

        sb.append("]");  
        return sb.toString();
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(arrayToString(arr)); 

        int[] emptyArr = {};
        System.out.println(arrayToString(emptyArr)); 

        int[] nullArr = null;
        System.out.println(arrayToString(nullArr)); 
    }
}
