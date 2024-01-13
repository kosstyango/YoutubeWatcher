import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class Watcher extends Thread {
    String[] addressMap;

    public Watcher(String[] addressMap) {
        this.addressMap = Constants.addr;
    }

    public void run() {
        super.run();
        System.out.println("Поток стартовал");
        WebDriver driver = new ChromeDriver();
        System.out.println("ChromeDriver создан");
        driver.get(Constants.addr[0]); //открываем первый ролик
        System.out.println("первый ролик открыт");
        driver.manage().window().maximize();
        System.out.println("открываем Chrome в полный размер");
        try {
            Thread.sleep(1000); //ждём 1 секунду
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            PressingButtons.pressingButtons(); // Нажимаем нужные кнопки для старта
        } catch (AWTException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        int index;
        while (true) { //запускаем бесконечный цикл
            //System.out.println("Дошли до бесконечного цикла");
            index = (int) (Math.random() * addressMap.length); //выбираем случайное число
            driver.get(addressMap[index]); //запускаем случайное видео
            driver.manage().window().minimize(); //прячем окно
            System.out.println(Thread.currentThread().getName() + " смотрит ролик " + index);
            try {
                Thread.sleep(Constants.VIDEO_LONG); //смотрим ролик 60(?) секунд
            } catch (InterruptedException e) {
                continue;
            }
        }
    }
}
