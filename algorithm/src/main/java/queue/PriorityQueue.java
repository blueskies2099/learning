package queue;

/**
 * 优先队列
 * @author qing
 * @date 2020 04 25
 */
public class PriorityQueue {
    private int[] arr;
    private int size;

    public PriorityQueue(){
        this(64);
    }

    public PriorityQueue(int initSize){
        if (initSize <= 0){
            initSize = 64;
        }
        this.arr = new int[initSize];
        this.size = 0;
    }




    private void swap(int a, int b){
        int t = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = t;
    }


}
