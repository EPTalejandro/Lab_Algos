import java.util.Arrays;

public class Main{

    public static void main(String[] args) {
        int[] a = new int[] {1,2,5,6,7,8,3,15,11};
        Utilidades.particionMenoresMayores(a,5);
        System.out.println(Arrays.toString(a));
    }

}