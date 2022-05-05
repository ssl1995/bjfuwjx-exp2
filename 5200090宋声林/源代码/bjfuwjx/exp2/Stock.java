package bjfuwjx.exp2;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SongShengLin
 * @date 2022/5/4 20:05
 * @description 股票类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    /**
     * 股票代码
     */
    @ExcelProperty(value = "股票代码", index = 0)
    private String code;

    /**
     * 会计年度
     */
    @ExcelProperty(value = "会计年度", index = 1)
    private String year;

    /**
     * 关键审计事项类型
     */
    @ExcelProperty(value = "关键审计事项类型", index = 2)
    private String eventType;

    /**
     * 关键审计事项内容
     */
    @ExcelProperty(value = "关键审计事项内容", index = 3)
    private String eventContent;

    /**
     * 应对方法
     */
    @ExcelProperty(value = "应对方法", index = 4)
    private String methods;

}
