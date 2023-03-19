package Sorting;

public class Selection extends AbstractSort{
    //제자리 정렬이므로 부가적인 저장공간 필요 없음
    //실행시간이 입력 데이터의 배치와 무관함
    //데이터 이동 최소화

    public static void sort(Comparable[] a){

        int N = a.length;

        for(int i=0; i<N-1; i++){

            int min = i;

            for(int j=i+1; j<N; j++){
                if(less(a[j], a[min])) min=j;
            }
            exch(a, i, min);
        }

        assert isSorted(a); //assert는 특정 조건이 참(true)이 아닐 경우 프로그램 실행을 중지하고 AssertionError를 발생.
    }

    public static void main(String[] args) {
        Integer[] a = {10, 4, 5, 2, 1, 8, 3, 6};
        Selection.sort(a);
        Selection.show(a);
    }
}
