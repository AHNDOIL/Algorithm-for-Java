package Sorting;

public class Shell extends AbstractSort{
    /*  Insertion sort의 문제 : 바로 앞의 원소와 비교함 -> 가장 작은 원소가 마지막에 저장될 경우, n-1 번의 교환 연산 발생
     *  h개 만큼 떨어진 원소들과 비교 후 자리 바꿈  (Shell sort에서 h=1인게 Insertion sort임)
     *  일반적으로 h = 3*h +1 수열 사용
     */

    public static void sort(Comparable[] a){

        int N = a.length;
        int h = 1;
        while(h<N/3) h = 3*h+1; //1, 4, 13 ,40 ,121, ...

        while(h >= 1){
            for(int i=h; i <N; i++)
                for(int j=i; j>=h && less(a[j], a[j-h]); j -=h) //h만큼 떨어진 원소들과 Insertion sort
                    exch(a, j, j-h);
            h/=3;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {10, 4, 5, 2, 1, 8, 3, 6};
        Shell.sort(a);
        Shell.show(a);
    }

}
