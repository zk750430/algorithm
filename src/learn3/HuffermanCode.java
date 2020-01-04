package learn3;

import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class HuffermanCode {

    /**
     * 进行赫夫曼编码压缩
     *
     * @param bytes
     * @return
     */
    public static byte[] huffmanZip(byte[] bytes) {
        //先统计每一个byte出现的次数，并放入一个集合中
        List<Node> nodes = getNodes(bytes);
        //创建一颗赫夫曼树
        Node tree = createHuffmanTree(nodes);
        //创建一个赫夫曼编码表
        Map<Byte, String> huffCode = getCodes(tree);
        //编码
        byte[] b = zip(bytes, huffCode);
        return b;
    }

    /**
     * 进行huffmanb编码
     *
     * @param bytes
     * @param huffCode
     * @return
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffCode) {
        StringBuilder sb = new StringBuilder();
        //把需要压缩的byte数组处理成一个二进制的字符串
        for (byte b : bytes) {
            sb.append(huffCode.get(b));
        }
        //定义长度
        int len = 0;
        if (sb.length() % 8 == 0) {
            len = sb.length() / 8;
        } else {
            len = sb.length() / 8 + 1;
        }
        //用于存储压缩后的byte
        byte[] by = new byte[len];
        //记录新的byte位置
        int index = 0;
        for (int i = 0; i < sb.length(); i += 8) {

            String substring = "";
            if (i + 8 > sb.length()) {
                substring = sb.substring(i);
            } else {
                substring = sb.substring(i, i + 8);
            }
            byte byt = (byte) Integer.parseInt(substring, 2);
            by[index] = byt;
            index++;
        }
        return by;
    }

    //用于临时存储路径
    static StringBuilder sb = new StringBuilder();
    static Map<Byte, String> huffCodes = new HashMap<>();

    /**
     * 创建赫夫曼编码
     *
     * @param tree
     * @return
     */

    private static Map<Byte, String> getCodes(Node tree) {
        if (tree == null) {
            return null;
        }
        getCodes(tree.leftNode, "0", sb);
        getCodes(tree.rightNode, "1", sb);
        return huffCodes;
    }

    private static void getCodes(Node node, String code, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if (node.data == null) {
            getCodes(node.leftNode, "0", sb2);
            getCodes(node.rightNode, "1", sb2);
        } else {
            huffCodes.put(node.data, sb2.toString());
        }

    }

    /**
     * 创建赫夫曼树
     *
     * @param nodes
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);
            //取出权值最低的两个二叉树
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);
            //创建一个新的二叉树
            Node parent = new Node(null, left.weight + right.weight);
            //把之前取出来的两颗二叉树设置为新的二叉树得子树
            parent.leftNode = left;
            parent.rightNode = right;
            //把前面取出来的两颗二叉树删除
            nodes.remove(left);
            nodes.remove(right);
            //把新创建的二叉树放入集合中
            nodes.add(parent);

        }
        return nodes.get(0);
    }

    /**
     * 把byte数组转为Node集合
     *
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> map = new HashMap<>();
        //统计每一个byte出现的次数
        for (byte b : bytes) {
            Integer count = map.get(b);
            if (count == null) {
                map.put(b, 1);
            } else {
                map.put(b, count + 1);
            }
        }
        //把每一个键值对转为Node对象
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    /**
     * 进行制定的赫夫曼编码边进行解码
     *
     * @param bytes
     * @return
     */
    public static byte[] decode(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        //把byte转为一个二进制的字符串
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            boolean flag = !(i == bytes.length - 1);
            sb.append(byteToBitStr(flag, b));
        }
        //把字符串按照制定的赫夫曼编码进行解码
        //把赫夫曼编码的键值进行调换
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        //创建一个集合，用来存byte;
        List<Byte> list = new ArrayList<>();
        //处理字符串
        for (int i = 0; i < sb.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                String key = sb.substring(i, i + count);
                b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        //把集合转为数组
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    private static String byteToBitStr(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    /**
     * 压缩文件
     *
     * @param src
     * @param dst
     */
    public static void zipFile(String src, String dst) {
        try {
            //创建一个输入流
            InputStream is = new FileInputStream(src);
            //创建一个和输入流指向的文件大小一样的byte数组
            byte[] by = new byte[is.available()];
            is.read(by);
            is.close();

            //使用huffman编码进行编码
            byte[] byteZip = huffmanZip(by);
            System.out.println(by.length);
            System.out.println(byteZip.length);
            OutputStream os = new FileOutputStream(dst);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.write(byteZip);
            oos.writeObject(huffCodes);
            oos.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件的解压
     *
     * @param src
     * @param dst
     */
    public static void unZip(String src, String dst) {
        try {
            InputStream is = new FileInputStream(src);
            //读取byte数组
            ObjectInputStream ois = new ObjectInputStream(is);
            byte[] b = (byte[]) ois.readObject();
            //读取huffman编码表
            Map<Byte, String> hufferCode = (Map<Byte, String>) ois.readObject();
            ois.close();
            is.close();
            //解码
            byte[] newByte = decode(b);
            OutputStream os = new FileOutputStream(dst);
            os.write(newByte);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
