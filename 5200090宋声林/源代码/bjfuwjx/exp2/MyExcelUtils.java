package bjfuwjx.exp2;

import com.alibaba.excel.EasyExcel;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/5/4 21:50
 * @description Excel处理工具
 */
public class MyExcelUtils {

    public static List<Stock> getStockList() {
        String path = MyFileUtils.getProjectPath() + MyPathUtils.SOURCE_TEXT_RELATIVE_PATH;

        path = URLDecoder.decode(path, StandardCharsets.UTF_8);

        StockListener stockListener = new StockListener();

        EasyExcel.read(path, Stock.class, stockListener).sheet().doRead();

        return stockListener.getStockList();
    }

    public static void writeResultXml(List<ResultPojo> data) {

        String path = MyFileUtils.getProjectPath() + MyPathUtils.RESULT_TEXT_RELATIVE_PATH;

        path = URLDecoder.decode(path, StandardCharsets.UTF_8);

        EasyExcel.write(path, ResultPojo.class).sheet("result").doWrite(data);
    }

}
