package edu.sapi.mestint;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NQueen {

    private int n;

    public NQueen(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        new NQueen(8).solve();
    }

    public void solve() {
        List<Integer> list = generateListOfRandomInteger(n);
        System.out.println("Initial");
        printBoard(list);
        int collisionCount = getCollisionsCount(list);
        int swapCount = 0;
        do {
            do {
                swapCount = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int attackCountQ1 = isAttacked(i, list);
                        int attackCountQ2 = isAttacked(j, list);
                        if (attackCountQ1 != 0 || attackCountQ2 != 0) {
                            List<Integer> temp = list.stream().map(v -> new Integer(v)).collect(Collectors.toList());
                            temp = swap(temp, i, j);
                            int tempCollCount = getCollisionsCount(temp);
                            if (tempCollCount <= collisionCount) {
                                list = temp;
                                swapCount++;
                                collisionCount = tempCollCount;
                            }
                        }

                    }
                }
            } while (swapCount != 0);
        } while (collisionCount != 0);
        System.out.println("Solution:");
        printBoard(list);
    }

    public List<Integer> swap(List<Integer> list, int i, int j) {
//        List<Integer> newList = list.stream().map(v -> new Integer(v)).collect(Collectors.toList());
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);

        return list;
    }


    private int isAttacked(int pos, List<Integer> list) {
        int collisionCount = 0;
        int q1 = pos;
        int q2 = list.get(pos);
        int i = 1;
        while (q1 - i >= 0 && q2 - i >= 0) {
            if (list.get(q1 - i) == q2 - i) {
                collisionCount++;
            }
            i++;
        }
        i = 1;
        while (q1 + i <= n - 1 && q2 + i <= n - 1) {
            if (list.get(q1 + i) == q2 + i) {
                collisionCount++;
            }
            i++;
        }
        i = 1;
        while (q1 - i >= 0 && q2 + i <= n - 1) {
            if (list.get(q1 - i) == q2 + i) {
                collisionCount++;
            }
            i++;
        }
        i = 1;
        while (q1 + i <= n - 1 && q2 - i >= 0) {
            if (list.get(q1 + i) == q2 - i) {
                collisionCount++;
            }
            i++;
        }
        return collisionCount;
    }

    private int getCollisionsCount(List<Integer> list) {
        int collisionCount = 0;
        for (int i = 0; i < list.size(); i++) {
            int temp = isAttacked(i, list);
//            System.out.println((list.get(i) + 1) + " - " + temp);
            collisionCount += temp;
        }
        return collisionCount;
    }

    private void printBoard(List<Integer> list) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (list.get(i) != j) {
                    System.out.print("_\t");
                    continue;
                }
                System.out.print(list.get(i) + 1 + "\t");
            }
            System.out.println();
        }

    }

    private List<Integer> generateListOfRandomInteger(int n) {
        List<Integer> list = IntStream.range(0, n).mapToObj(Integer::new).collect(Collectors.toList());
        Collections.shuffle(list);
        return list;

    }
}
