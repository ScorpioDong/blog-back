package cn.scorpiodong.blog.util;

import java.io.*;
import java.util.List;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/7/6 7:40 下午
 */
public class ListUtils {
    public static <T> List<T> deepCopy(List<T> src) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream byteOut = new ObjectOutputStream(outputStream);
            byteOut.writeObject(src);

            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            ObjectInputStream byteIn = new ObjectInputStream(inputStream);
            Object object = byteIn.readObject();
            return (List<T>) object;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
