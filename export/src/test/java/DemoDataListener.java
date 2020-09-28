import cn.hutool.json.JSON;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: wangcan
 * @Date: 2020/9/28 10:39
 */
public class DemoDataListener extends AnalysisEventListener<DemoData> {
  private static final Logger LOGGER = LoggerFactory.getLogger(DemoDataListener.class);
  // 批次保存数量
  private static final int BATCH_COUNT = 5;
  List<DemoData> list = new ArrayList<DemoData>();
  @Override
  public void invoke(DemoData data, AnalysisContext analysisContext) {
    LOGGER.info("解析到一条数据:{}", data.toString());
    list.add(data);
    // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
    if (list.size() >= BATCH_COUNT) {
      saveData();
      // 存储完成清理 list
      list.clear();
    }
  }

  @Override
  public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    saveData();
    LOGGER.info("所有数据解析完成！");
  }

  private void saveData() {
    LOGGER.info("{}条数据，开始存储数据库！", list.size());
    LOGGER.info("存储数据库成功！");
  }
}
