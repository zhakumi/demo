import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import java.util.Date;
import lombok.Data;

/**
 * @Author: wangcan
 * @Date: 2020/9/28 10:11
 */
@Data
public class DemoData {
  @ExcelProperty(value="字符串标题",index=0)
  private String string;
  //index 指定列的顺序
  @ExcelProperty(value="日期标题",index=3)
  // 时间格式转换
  @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
  private Date date;
  // 数据类型转化为百分比
  @NumberFormat("#.##%")
  @ExcelProperty("数字标题")
  private Double doubleData;

  /**
   * 忽略这个字段
   */
  @ExcelIgnore
  private String ignore;
}
