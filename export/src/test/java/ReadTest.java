import com.alibaba.excel.EasyExcel;
import java.io.File;
import java.util.List;
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
@Ignore
public class ReadTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReadTest.class);

  //基础读取
  @Test
  public void read() {
    String fileName = TestFileUtil.getPath() + File.separator + "demo.xlsx";
    // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//    EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
    List<DemoData> a = EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet()
        .doReadSync();
    System.out.println(1);
  }

  //基础写入

}
