package learn6;

public class ArrayQueueDemo {
    public static void main(String[] args) {

    }
}

/**
 * 使用数组模拟队列
 */
class ArrayQueue {
    //数组最大容量
    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //该数组用户存放数据，模拟队列
    private int[] arr;


    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        //执向队列头部，分析出front是指向队列头的前一个位置
        front = -1;
        //指向队列的尾部
        rear = -1;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }


    /**
     * 判断队列是否满
     *
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void addQueue(int n) {
        if (isEmpty()) {
            System.out.println("队列满，不能加入数据");
        }
        rear++;
        arr[rear] = n;
    }


    /**
     * 取数据
     *
     * @return
     */
    public int getQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空！");
        }
        front++;
        return arr[front];
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }


    public int headQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空");
        }
        return arr[front + 1];
    }

}
