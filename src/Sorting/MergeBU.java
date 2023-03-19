package Sorting;

public class MergeBU extends AbstractSort{

    public static void merge(Comparable[] in, Comparable[] out, int low, int mid, int high){

        int i = low;
        int j = mid+1;

        for(int k=low; k<=high; k++){
            if(i>mid)                        out[k] = in[j++];
            else if (j>high)                 out[k] = in[i++];
            else if (less(in[j], in[i]))     out[k] = in[j++];
            else                             out[k] = in[i++];
        }
    }

    public static void sort(Comparable[] a){
        Comparable[] src = a, tmp;
        Comparable[] dst = new Comparable[a.length];
        int N = a.length;

        for(int n=1; n<N; n*=2){ // n: 병합할 부분 배열의 크기
            for(int i=0; i<N; i+=2*n) // i: 병합할 부분 배열의 위치

                merge(src, dst, i, i+n-1, Math.min(i+2*n-1, N-1));
            tmp = src; src = dst; dst = tmp;
            // merge 메소드를 호출할 때 입력으로 사용되는 배열과 출력으로 나오는 배열의 역할을 서로 바꿈
            // 처음에는 src에 입력 배열, dst는 결과 배열임. 이걸 서로 번갈아 가면서 수행
        }
        if(src != a) System.arraycopy(src, 0, a, 0, N);
        // 만약 맨 마지막에 정렬되어 있는 배열이 src라면 a 배열에 복사
    }


    public static void main(String[] args){
        Integer[] a = {10, 4, 5, 2, 1, 8, 3, 6};
        MergeBU.sort(a);
        MergeBU.show(a);
    }
}
