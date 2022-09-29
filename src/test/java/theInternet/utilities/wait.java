package theInternet.utilities;

public class wait {
    public static void wait(int sec){
        try {
            java.lang.Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
