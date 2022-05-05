package bjfuwjx.exp2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author SongShengLin
 * @date 2022/5/4 18:46
 * @description 文件工具类
 */
public class MyFileUtils {

    public static String getProjectPath() {
        return new File("").getAbsolutePath();
    }

    public static Set<String> getKeywords() {
        String projectPath = getProjectPath();
        String path = projectPath + MyPathUtils.KEYWORDS_RELATIVE_PATH;

        path = URLDecoder.decode(path, StandardCharsets.UTF_8);

        return new HashSet<>(getContentByPath(path));
    }

    public static List<String> getContentByPath(String path) {

        path = URLDecoder.decode(path, StandardCharsets.UTF_8);

        List<String> res = new ArrayList<>();
        try {

            FileInputStream fileInputStream = new FileInputStream(path);
            InputStreamReader reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(reader);

            StringBuilder sb = new StringBuilder();


            char[] cs = new char[1024];
            while (bufferedReader.read(cs) != -1) {
                for (char c : cs) {
                    sb.append(c);
                }
            }

            String keywords = sb.toString();
            String[] split;

            // 取消换行
            if (keywords.contains("\r\n")) {
                split = keywords.split("\r\n");
            } else if (keywords.contains("\r")) {
                split = keywords.split("\r");
            } else {
                split = keywords.split("\n");
            }

            res.addAll(Arrays.asList(split));

            fileInputStream.close();
            reader.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

}
