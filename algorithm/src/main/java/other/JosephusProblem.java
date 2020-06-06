package other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qing
 */
public class JosephusProblem {
    /**
     * 1、数组 2、循环链表 3、公式
     * @param args 入参
     */
    public static void main(String[] args) {
        List<Integer> list = liveOne(6, 5);
        for (Integer i: list
             ) {
            System.out.println(i);
        }
    }
    public static List<Integer> liveOne(int n, int m) {
        int[] persons = new int[n];
        for (int i = 0; i < n; i++) {
            persons[i] = 1;
        }
        int index = 0;
        List<Integer> list = new ArrayList<>();
        while (true) {
            for (int i = 0; i < n; i++) {
                if (persons[i] == 1){
                    index ++;
                    if (index%m == 0){
                        persons[i] = 0;
                        list.add(i);
                        if (list.size() == n){
                            return list;
                        }
                    }
                }
            }
        }
    }
}
