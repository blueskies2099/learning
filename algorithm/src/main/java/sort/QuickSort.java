package sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 34, 2, 45, 23, 67, 89, 5423, 1, 234};
        sort(a, 0, a.length - 1);
        for (int i= 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    private static void sort(int[] array, int head, int tail){
        if (head >= tail || array == null || array.length <= 1){
            return ;
        }

        int i = head, j = tail;
        int pivot = array[(head+tail)/2];

        while (i <= j){

            while (array[i] < pivot){
                i++;
            }
            while (array[j] > pivot){
                j--;
            }

            if (i < j){
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }else if (i == j){
                i++;
            }
        }


        sort(array, head, j);
        sort(array, i, tail);


    }
}
