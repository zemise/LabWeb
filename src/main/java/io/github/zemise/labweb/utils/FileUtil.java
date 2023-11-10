package io.github.zemise.labweb.utils;

import java.io.File;
import java.io.InputStream;

/**
 * <p>
 *
 * </p>
 *
 * @author <a href= "https://github.com/zemise">Zemise</a>
 * @Date 2023/11/9
 * @since 1.0
 */
public class FileUtil {

    public static String getPath() {
        return FileUtil.class.getResource("/").getPath();
    }

    public static File createNewFile(String pathName) {
        File file = new File(getPath() + pathName);
        if (file.exists()) {
            file.delete();
        } else {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
        }
        return file;
    }

    public static InputStream getResourcesFileInputStream(String fileName) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream("" + fileName);
    }

    public static File readFile(String pathName) {
        return new File(getPath() + pathName);
    }

    public static File readUserHomeFile(String pathName) {
        return new File(System.getProperty("user.home") + File.separator + pathName);
    }

    public static void main(String[] args) {
        System.out.println(getPath());

        System.out.println(readFile("/data/initData.txt").getPath());
        System.out.println(readUserHomeFile("init").toPath());
    }
}
