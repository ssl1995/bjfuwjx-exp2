package bjfuwjx.exp2;

import com.google.common.base.Joiner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author SongShengLin
 * @date 2022/5/4 18:39
 * @description 实验2-词频统计
 */
public class TermFrequency {
    /**
     * 小数位数
     */
    public static final Integer SCALE = 4;


    public static void main(String[] args) {
        List<Stock> stockList = MyExcelUtils.getStockList();
        Map<String, List<Stock>> groupCodeList = stockList.stream().collect(Collectors.groupingBy(Stock::getCode));
        Map<String, String> stockMap = new HashMap<>(groupCodeList.size());

        groupCodeList.forEach((code, stocks) -> {
            StringBuilder sb = new StringBuilder();
            stocks.forEach(stock -> {
                sb.append(stock.getEventType());
                sb.append(stock.getEventContent());
                sb.append(stock.getMethods());
            });
            String content = sb.toString();
            // 去掉回车、换行
            content = content.replaceAll("\r", "");
            content = content.replaceAll("\n", "");
            content = content.replaceAll("\r\n", "");
            stockMap.put(code, content);
        });

        Set<String> keywords = MyFileUtils.getKeywords();
        List<ResultPojo> resultList = new ArrayList<>();

        stockMap.forEach((code, content) -> {
            List<String> keywordList = new ArrayList<>();

            keywords.forEach(keyword -> {
                if (content.contains(keyword)) {
                    keywordList.add(keyword);
                }
            });
            StringBuilder keywordStr = new StringBuilder();
            keywordList.forEach(keywordStr::append);

            int contentLen = content.length();
            int keywordLen = keywordStr.length();
            BigDecimal contentLenBg = new BigDecimal(contentLen);
            BigDecimal keywordLenBg = new BigDecimal(keywordLen);
            BigDecimal keywordDensity = keywordLenBg.divide(contentLenBg, SCALE, RoundingMode.HALF_UP);


            ResultPojo resultPojo = new ResultPojo();
            // 股票代码
            resultPojo.setCode(code);
            // 文本长度
            resultPojo.setContentLength(contentLen);
            // 关键词个数
            resultPojo.setKeywordCount(keywordList.size());
            // 关键词长度
            resultPojo.setKeywordLength(keywordLen);
            // 关键词密度
            resultPojo.setKeywordDensity(keywordDensity.doubleValue());
            // 关键词列表
            resultPojo.setKeywordList(Joiner.on(",").join(keywordList));

            resultList.add(resultPojo);
        });

        // 根据股票代码升序排序
        List<ResultPojo> sortedResult = resultList.stream().sorted(Comparator.comparing(pojo -> Integer.valueOf(pojo.getCode()))).collect(Collectors.toList());


        MyExcelUtils.writeResultXml(sortedResult);

        System.out.println("词频统计结束");

    }
}
