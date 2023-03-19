package Sorting;

public class MergeTD extends AbstractSort{

    private static final int CUTOFF = 7;

    public static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high){
        //a[low..mid] 와 a[mid+1..high]는 이미 정렬되어있음

        for(int k=low; k<=high; k++)
            aux[k] = a[k]; //aux[] 배열에 a[]의 내용을 복사

        int i = low;
        int j = mid+1;

        for(int k=low; k<=high; k++){ //aux[]와 배열을 비교하여 병합된 결과를 a[]에 저장
            if(i>mid)                        a[k] = aux[j++];
            else if (j>high)                 a[k] = aux[i++];
            else if (less(aux[j], aux[i]))   a[k] = aux[j++];
            else                             a[k] = aux[i++];
        }
    }

    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
    }

    public static void sort(Comparable[] a, Comparable[] aux, int low, int high){

        if(high <= low + CUTOFF-1) { //성능 개선: 배열의 크기가 CUTOFF보다 작을 경우 삽입 정렬을 사용 -> Recursion 부담 완화
            Insertion.sort(a);
            return;
        }
        int mid = low + (high-low)/2;
        sort(a, aux, low, mid); //아랫부분 정렬
        sort(a, aux, mid+1, high); //윗부분 정렬

        if(less(a[mid], a[mid+1])) return; //성능 개선: 이미 두 배열이 정렬되어 있다면 merg하지 말자

        merge(a, aux, low, mid, high); //두 부분 병합
    }

    public static void main(String[] args){
        Integer[] a = {10, 4, 5, 2, 1, 8, 3, 6};
        MergeTD.sort(a);
        MergeTD.show(a);
    }
}
