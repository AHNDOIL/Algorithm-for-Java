package Sorting;

public class Counting {
    //K의 크기가 N과 비슷하다면 O(N)으로 정렬가능함
    //하지만 K=N^3 이라면 복잡도도 O(N^3)이 됨. N에 비해 K가 작을 때 사용하자

    public static int[] sort(int[] A, int K){

        int i, N = A.length;
        int[] C = new int[K]; //임시 배열
        int[] B = new int[N]; //결과 배열

        for(i=0; i<N; i++) C[A[i]]++; //원소의 빈도수 합산
        for(i=1; i<K; i++) C[i] += C[i-1]; //i값이 저장될 위치를 계산
        for(i=N-1; i>=0; i--) B[--C[A[i]]] = A[i]; //뒤에서 부터 저장해야 stable하다

        return B;
    }

    public static void main(String[] args){
        int[] A = {10, 4, 5, 8, 1, 8, 3, 6}, B;
        B = Counting.sort(A,11); //A 배열의 최댓값이 10이므로 K=11

        for(int i=0; i<B.length; i++)
            System.out.print(B[i] + " ");
        System.out.println();
    }
}
