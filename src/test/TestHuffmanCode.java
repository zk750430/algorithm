package test;

import learn3.HuffermanCode;

import java.util.Arrays;

public class TestHuffmanCode {
    public static void main(String[] args) {
        String msg = "can you can a can as a can canner can a can.";
        byte[] bytes = msg.getBytes();
        //创建赫夫曼编码
        byte[] b = HuffermanCode.huffmanZip(bytes);
        byte[] newBytes = HuffermanCode.decode(b);
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(newBytes));
        System.out.println(new String(newBytes));
    }
}
