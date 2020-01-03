package learn2;

import utils.MyQueue;

import java.util.Arrays;

/**
 * @author： Administrator
 * @create： 2020-01-02 16:36
 * 说明：各类排序算法
 */
public class Sort {

    /**
     * 快速排序：
     * 通过一趟排序将待排记录按照一个基准值分隔成独立的两部分，其中一部分记录的值均比另一部分的值小
     * 对这两部分记录继续进行快速排序，以达到整个序列有序。
     *
     * @param arr
     * @param start 开始位置
     * @param end   结束位置
     */
    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            //把数组中的第0个数字作为标准数
            int stard = arr[start];
            //记录需要排序的下标
            int low = start;
            int high = end;
            //循环找比标准数大的数，和比标准数小的数
            while (low < high) {
                //右边的数字比标准数大
                while (low < high && stard <= arr[high]) {
                    high--;
                }
                //使用右边的数字替换左边的数字
                arr[low] = arr[high];
                //如果左边的数字比标准数小
                while (low < high && arr[low] <= stard) {
                    low++;
                }
                arr[high] = arr[low];
            }
            //把标准数赋给低所在的数
            arr[low] = stard;
            //递归执行
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);
        }
    }

    /**
     * 插入排序
     * 插入排序是一种简单直观的排序算法。
     * 它是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入,
     * 在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     *
     * @param arr
     */
    public void insertSort(int[] arr) {
        //便利所有的数字
        for (int i = 1; i < arr.length; i++) {
            //如果当前数字比前一个数字小
            if (arr[i] < arr[i - 1]) {
                //把当前遍历数字存起来
                int temp = arr[i];
                int j;
                //遍历当前数字前面所有的数字
                for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                    arr[j + 1] = arr[j];
                }
                //把临时变量(外层for循环的当前元素)赋值给不满足条件的后一个元素
                arr[j + 1] = temp;
            }
        }
    }

    /**
     * 冒泡排序:
     * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列;
     * 一次比较两个元素,如果它们的顺序错误就把它们交换过来;
     * 走访数列的工作是重复的进行,直到没有再需要交换的元素，也就是说该数列已经排序完成。
     *
     * @param arr
     */
    public void bubbleSort(int[] arr) {
        //控制共比较多少轮
        for (int i = 0; i < arr.length - 1; i++) {
            //控制比较的次数
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }

    /**
     * 希尔排序：
     * 希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序。
     * 希尔排序是把记录按一定增量分组（例如：增量为5，那么索引为0,5,10，15....的这些元素为一组），对每组使用直接插入排序算法排序；
     * 随着增量逐渐减少，每组包含的元素越来越多，当增量减至1时，所有元素被分成一组，算法便终止。
     *
     * @param arr
     */
    public void shellSort(int[] arr) {
        int n = 2;
        //步长
        for (int i = arr.length / n; i > 0; i /= n) {
            //遍历所有的元素
            for (int j = i; j < arr.length; j++) {
                //遍历本组中所有的元素
                for (int k = j - i; k >= 0; k -= i) {
                    //如果当前元素大于加上步长后的那个元素
                    if (arr[k] > arr[k + i]) {
                        int temp = arr[k];
                        arr[k] = arr[k + i];
                        arr[k + i] = temp;
                    }
                }

            }
            System.out.println("第一次排列结果：" + Arrays.toString(arr));
        }
    }

    /**
     * 简单选择排序：
     * 选择排序是一种简单直观的排序算法。
     * 首先在未排序序列中找到最小（大）元素，存放到已排序序列的起始位置;
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕。
     *
     * @param arr
     */
    public void selectSimpleSort(int[] arr) {
        //需要选择的次数
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            //把当前遍历的数和后面所有的数一次进行比较，并记录下最小的数的下标
            for (int j = i + 1; j < arr.length - 1; j++) {
                //如果后面比较的数比记录的最小的数小
                if (arr[minIndex] > arr[j]) {
                    //记录下最小的那个数的下标
                    minIndex = j;
                }
            }
            //如果最小元素的索引不是i则交换索引为minIndex和i的两个元素
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }


        }

    }

    /**
     * 归并排序
     * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序;
     * 对于子序列递归采用归并排序，直到子序列元素个数为1
     *
     * @param arr
     * @param low
     * @param high
     */
    public void mergeSort(int[] arr, int low, int high) {
        int middle = (low + high) / 2;
        if (low < high) {
            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, high);
            merge(arr, low, middle, high);
        }
    }

    private void merge(int[] arr, int low, int middle, int high) {
        //用于存储归并后的临时数组
        int[] temp = new int[high - low + 1];

        //记录第一个数组中需要遍历的下标
        int i = low;
        //记录第二个数组中需要遍历的下标
        int j = middle + 1;

        //用于记录在临时数组中存放的下标
        int index = 0;
        //循环遍历两个数组取出小的元素，放入临时数组中
        while (i <= middle && j <= high) {
            //第一个数组的数据更小，把小的数据放入临时数组中
            if (arr[i] <= arr[j]) {
                temp[index] = arr[i];
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        //处理多余的数据
        while (j <= high) {
            temp[index] = arr[j];
            j++;
            index++;
        }
        while (i <= middle) {
            temp[index] = arr[i];
            i++;
            index++;
        }
        //把临时数组中的元素重新放入原数组
        for (int k = 0; k < temp.length; k++) {
            arr[k + low] = temp[k];
        }

    }


    /**
     * 基数排序
     *
     * @param arr
     */
    public void radixSort(int[] arr) {
        //找出数组中的最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //计算最大数字是几位数
        int maxLength = (max + "").length();


        //用于临时存储数据的二维数组
        int[][] temp = new int[10][arr.length - 1];

        //用于记录在temp相应的数组中的存放的数字的数量
        int[] counts = new int[10];
        int num = 10;
        for (int i = 0, n = 1; i < maxLength; i++, n *= num) {
            for (int j = 0; j < arr.length; j++) {
                //把每个数字分别计算余数
                int ys = (arr[j] / n) % 10;
                //把当前遍历的数据放入指定数组中
                temp[ys][counts[ys]] = arr[j];
                counts[ys]++;
            }
            //记录取得数字需要放的位置
            int index = 0;
            //把数字取出来
            for (int k = 0; k < counts.length; k++) {
                //记录数量的数组中当前余数记录的数量不为0
                if (counts[k] != 0) {
                    for (int l = 0; l < counts[k]; l++) {
                        arr[index] = temp[k][l];
                        index++;
                    }
                    //把数量置为0
                    counts[k] = 0;
                }

            }

        }

    }


    /**
     * 基数排序
     * 基于队列实现
     *
     * @param arr
     */
    public void radixQueueSort(int[] arr) {
        //找出数组中的最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //计算最大数字是几位数
        int maxLength = (max + "").length();


        //用于临时存储数据的队列数组
        MyQueue[] temp = new MyQueue[10];
        //为队列数组赋值
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new MyQueue();
        }
        int num = 10;
        for (int i = 0, n = 1; i < maxLength; i++, n *= num) {
            for (int j = 0; j < arr.length; j++) {
                //把每个数字分别计算余数
                int ys = (arr[j] / n) % 10;
                //把当前遍历的数据放入指定队列中
                temp[ys].add(arr[j]);
            }
            //记录取得数字需要放的位置
            int index = 0;
            //把数字取出来
            for (int k = 0; k < temp.length; k++) {
                //记录数量的数组中当前余数记录的数量不为0
                while (!temp[k].isEmpty()) {
                    arr[index] = temp[k].poll();
                    index++;
                }
            }

        }

    }

    /**
     * @param arr
     */
    public void heapSort(int[] arr) {
        int start = (arr.length - 1) / 2;
        //调整为大顶堆
        for (int i = start; i >= 0; i--) {
            maxHeap(arr, arr.length, i);
        }
        //先把数组中的第0个和堆中的最后一个数交换位置，再把前面的处理为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeap(arr, i, 0);
        }
    }

    private void maxHeap(int[] arr, int size, int index) {
        //左子节点
        int leftNode = 2 * index + 1;
        //右子节点
        int rightNode = 2 * index + 2;
        int max = index;
        //和两个子节点分别进行对比，找出最大的节点
        if (leftNode < size && arr[leftNode] > arr[max]) {
            max = leftNode;
        }
        if (rightNode < size && arr[rightNode] > arr[max]) {
            max = rightNode;
        }
        //交换位置
        if (max != index) {
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;

            //交换位置后可能会破坏之间排好的堆，所以之前排好的堆需要重新调整
            maxHeap(arr, size, max);

        }


    }

}
