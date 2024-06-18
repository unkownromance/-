package cn.tycoding.utils;

import cn.tycoding.entity.Message;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 */
public class CoreUtil {

    /**
     * 按照时间顺序向List中push数据
     *
     * @param list
     */
    public static void push(List<Message> list) {
        list.sort(new Comparator<Message>() {
            @Override
            public int compare(Message m1, Message m2) {
                return m1.getTime().compareTo(m2.getTime());
            }
        });
        //list.sort(Comparator.comparing(Message::getTime));
    }

    /**
     * format date
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
