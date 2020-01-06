package learn6;

/**
 * @author： Administrator
 * @create： 2020-01-06 15:47
 * 说明：稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组
        //0 代表没有旗子，1 表示 黑子 2 表示蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //原始的二维数组
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //1、先遍历，得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        //2、根据sum创建一个对应的稀疏数组
        int[][] spareArr = new int[sum + 1][3];
        //3、给稀疏数组赋值
        spareArr[0][0] = 11;
        spareArr[0][1] = 11;
        spareArr[0][2] = sum;
        //4、遍历二维数组，将非0的数组放入稀疏数组
        int index = 1;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    spareArr[index][0] = i;
                    spareArr[index][1] = j;
                    spareArr[index][2] = chessArr1[i][j];
                    index++;
                }
            }
        }

        System.out.println("+++++++++++++++++++++++++++++++");

        for (int i = 0; i < spareArr.length; i++) {
            for (int j = 0; j < spareArr.length; j++) {
                System.out.printf("%d\t", spareArr[i][j]);
            }
            System.out.println();
        }


        System.out.println("====================");
        //将稀释数组---->恢复成原始的二维数组
        //1、先读稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int[][] chessArr2 = new int[spareArr[0][0]][spareArr[0][1]];
        //2、再读取稀疏数组的后几行的数据，并付费原始的二维数组
        for (int i = 1; i < spareArr.length; i++) {
            chessArr2[spareArr[i][0]][spareArr[i][1]] = spareArr[i][2];
        }
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
