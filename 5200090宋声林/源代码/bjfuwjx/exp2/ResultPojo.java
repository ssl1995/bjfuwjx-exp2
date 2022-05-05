package bjfuwjx.exp2;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SongShengLin
 * @date 2022/5/4 22:11
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultPojo {

    /**
     * 股票代码
     */
    @ExcelProperty(value = "股票代码", index = 0)
    private String code;

    /**
     * 文本长度
     */
    @ExcelProperty(value = "文本长度", index = 1)
    private Integer contentLength;

    /**
     * 关键词个数
     */
    @ExcelProperty(value = "关键词个数", index = 2)
    private Integer keywordCount;

    /**
     * 关键词长度
     */
    @ExcelProperty(value = "关键词长度", index = 3)
    private Integer keywordLength;

    /**
     * 关键词密度
     */
    @ExcelProperty(value = "关键词密度", index = 4)
    private Double keywordDensity;

    /**
     * 关键词列表
     */
    @ExcelProperty(value = "关键词列表", index = 5)
    private String keywordList;

}
