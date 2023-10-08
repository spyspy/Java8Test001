package java8Time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Java8LocalDateTime {
    public static void main(String[] args) {

        // 時間轉字串
        LocalDateTime lodt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("_yyyyMMddHHmmssSSS");
        String format = lodt.format(formatter);

        System.out.println("format: "+format);

        // 時間月份減少操作
        LocalDateTime lodt_6month = lodt.minusMonths(6);
        String format_6 = lodt_6month.format(DateTimeFormatter.ofPattern("_yyyyMMdd"));
        System.out.println("format_6: "+format_6);

        // 列出日期清單，如下
        // 20221105
        // 20221104
        // 20221103
        // 20221102
        LocalDate currentDate = LocalDate.now().minusMonths(1); // 今日算起六個月前

        for (int i = 0; i < 10; i++) {
            String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("_yyyyMMdd"));
            System.out.println("formattedDate: "+formattedDate);
            currentDate = currentDate.minusDays(1);
        }


        // OLD: new Date()
        // https://kucw.github.io/blog/2020/6/java-date/
        // https://stackoverflow.com/questions/32437550/whats-the-difference-between-instant-and-localdatetime
        System.out.println("================");
        System.out.println(new Date());
        System.out.println(LocalDateTime.now()); // 會依據使用者位置改變內容的，建議是由使用者自行輸入的時候使用
        System.out.println(Instant.now());       // 沒有時區問題的絕對時間
    }
}
