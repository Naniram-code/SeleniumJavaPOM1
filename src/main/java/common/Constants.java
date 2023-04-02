package common;




import utils.PropertyReaderOptimized;

public class Constants {


    public static String URL;//Class PropertyReaderOptimized use for reading key and value

    static {//Static block coz its should run first
        try {
            URL = PropertyReaderOptimized.readKey("url", "data.properties");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String UserName;//Class PropertyReaderOptimized use for reading key and value

    static {//Static block coz its should run first
        try {
            UserName = PropertyReaderOptimized.readKey("username","data.properties");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }}
        public static String Password;

        static {
            try {
                Password = PropertyReaderOptimized.readKey("password", "data.properties");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }}





        }

