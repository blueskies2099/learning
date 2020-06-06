package sort;

/**
 * 堆排序
 *
 * @author qing
 * @date 2020 04 25
 */
public class HeapSort {

    public static void main(String[] args) {
        new HeapSort().sort(new int[]{21, 2, 4565, 12, 4, 2, 6, 0});
    }

    /**
     * 堆排序方法
     * @param arr 堆的数组
     */
    public void sort(int[] arr) {
        // 构建大顶堆 第一个非叶子节点 从右至左 从下到上 依次调整
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        // 进行排序 每次将堆顶与最后一个交换 然后再进行调整
        for (int i = arr.length -1; i > 0; i--){
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }

        for (int i: arr
             ) {
            System.out.println(i);
        }
    }

    /**
     * 调整 堆
     * @param arr 堆的数组
     * @param i 节点索引
     * @param length 数组长度
     */
    public void adjustHeap(int[] arr, int i, int length) {
        int fatherVal, childIndex;
        for (fatherVal = arr[i]; 2 * i + 1 < length; i = childIndex) {
            childIndex = 2 * i + 1;
            if (childIndex != length - 1 && arr[childIndex] < arr[childIndex + 1]) {
                childIndex++; // 左子树小于右子树
            }
            // 比较
            if (fatherVal < arr[childIndex]) {
                arr[i] = arr[childIndex];
            }else {
                break; // 未破坏 返回
            }
        }
        // i 这时是子树index
        arr[i] = fatherVal;
    }

    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
