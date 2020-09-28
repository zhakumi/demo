import com.alibaba.excel.EasyExcel;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Author: wangcan
 * @Date: 2020/9/28 10:04
 */

public class WriteTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(WriteTest.class);
  List<DemoData> list = null;

  @Before
  public void befor() {
    list = new ArrayList<DemoData>();
    for (int i = 0; i < 10; i++) {
      DemoData data = new DemoData();
      data.setString("字符串" + i);
      data.setDate(new Date());
      data.setDoubleData(0.56);
      list.add(data);
    }
  }

  //基础写入
  @Test
  public void write() {
    // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
    String fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
    // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
    // 如果这里想使用03 则 传入excelType参数即可
    EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(list);
  }

  //基础写入  排除部分字段
  @Test
  public void writeAndExclude() {
    String fileName = TestFileUtil.getPath() + "excludeOrIncludeWrite" + System.currentTimeMillis() + ".xlsx";
    // 排除data 写入
    Set<String> excludeColumnFiledNames = new HashSet<String>();
    excludeColumnFiledNames.add("date");
    EasyExcel.write(fileName, DemoData.class).excludeColumnFiledNames(excludeColumnFiledNames).sheet("模板")
        .doWrite(list);
  }

  //基础写入  只包含部分字段
  @Test
  public void writeAndInclude() {
    String fileName = TestFileUtil.getPath() + "ixcludeOrIncludeWrite" + System.currentTimeMillis() + ".xlsx";
    // 只把data 写入
    Set<String> includeColumnFiledNames = new HashSet<String>();
    includeColumnFiledNames.add("date");
    EasyExcel.write(fileName, DemoData.class).includeColumnFiledNames(includeColumnFiledNames).sheet("模板")
        .doWrite(list);
  }
}
