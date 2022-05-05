package bjfuwjx.exp2;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/5/4 20:18
 * @description
 */
public class StockListener extends AnalysisEventListener<Stock> {

    private List<Stock> stockList = new ArrayList<>();

    @Override
    public void invoke(Stock stock, AnalysisContext analysisContext) {
//        System.out.println("解析到一条数据:" + stock);
        stockList.add(stock);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//        System.out.println("解析完成,数据总数:" + stockList.size());
    }

    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }
}
