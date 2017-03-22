package novel.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hou on 12/20/16.
 */
public class ChangeType {
    //byte 与 int 的相互转换
    public static byte intToByte(int x) {
        return (byte) x;
    }

    public static int byteToInt(byte b) {
        //Java 总是把 byte 当做有符处理；我们可以通过将其和 0xFF 进行二进制与得到它的无符值
        return b & 0xFF;
    }
    public static Date getCurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return new Date();
//        return df.format(new Date());
//        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
    }
    public static String getCurrentTimeStr(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());
    }
    /*
     * format date format
     */
    public static String getCurrentTimeStr(String format){
        SimpleDateFormat df = new SimpleDateFormat(format);//设置日期格式
        return df.format(new Date());
    }
    public static Date getDate(String dateStr){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date time=null;
        try {
            time= sdf.parse(sdf.format(new Date()));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }
}
