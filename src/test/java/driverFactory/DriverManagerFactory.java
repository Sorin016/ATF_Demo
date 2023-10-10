package driverFactory;

import browserManager.ChromeManager;

public class DriverManagerFactory {

    public static DriverManager driverManager(DriverType type){
        DriverManager driverManager;

        switch (type){
            case CHROME:
                driverManager=new ChromeManager();
                break;
            default:
                driverManager=new ChromeManager();
        }
        return driverManager;
    }
}
