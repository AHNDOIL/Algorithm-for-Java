package Sorting;

public abstract class AbstractSort {

    public static void sort(Comparable[] a){
        //하위 클래스가 sort 구현
    }

    protected static boolean less(Comparable v, Comparable w){ //v가 w 보다 작으면 true
        return v.compareTo(w) < 0;
    }

    protected static void exch(Comparable[] a, int i, int j){ //원소 값 교환
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected static void show(Comparable[] a){ //배열 출력
        for(int i=0; i< a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    protected static boolean isSorted(Comparable[] a){ //정렬되어있는지 확인
        for(int i=1; i< a.length; i++)
            if(less(a[i], a[i-1])) return false;
        return true;
    }

}
