import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.*;
import java.awt.event.InputEvent;

public class Liker {
    public static void main(String[] args) throws InterruptedException, AWTException {

        System.setProperty("webdriver.chrome.driver", "Selenium\\chromedriver.exe");
        for (int i = 0; i < 20; i++) {
        WebDriver driver1 = new ChromeDriver();
        driver1.navigate().to("https://www.youtube.com/channel/UCMOYFUwyTHCggfXitcD7ciA");//Канал Yoga_FreshBar
        Thread.sleep(3000);
            pressingButtons();
            System.out.println("запустили цикл "+(i+1));

            Robot robot = new Robot(); //создаём робота управления мышкой
            for (int j = 0; j < 41; j++) { //цикл на 41 видео
                System.out.println("Смотрим ролик № "+j);
                Thread.sleep(50000); //смотрим ролик 50 секунд
                robot.mouseMove(160, 645); //Следующее видео
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                Thread.sleep(500);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            }

    driver1.quit(); //закончили просмотр всех роликов на канале

        }
    }

    private static void pressingButtons() throws AWTException, InterruptedException {
        Robot robot1 = new Robot(); //создаём робота
        //System.out.println("робот создан");
        robot1.mouseMove(1045, 700);
        Thread.sleep(500);
        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //сползаем вниз
        //System.out.println("скролим вниз");
        Thread.sleep(500);
        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);

        robot1.mouseMove(850, 720); //принять все
        //System.out.println("Принять всё");
        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(500);
        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1500);

        robot1.mouseMove(370, 370);
        Thread.sleep(3000);
        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //воспроизвести всё
        //System.out.println("Воспроизвести всё");
        Thread.sleep(500);
        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        robot1.mouseMove(220, 645);
        Thread.sleep(1500);
        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //выключаем звук
        //System.out.println("Выключаем звук");
        Thread.sleep(500);
        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

//        robot1.mouseMove(280, 30);
//        Thread.sleep(1500);
//        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //открываем новую вкладку
//        System.out.println("открываем новую вкладку");
//        Thread.sleep(500);
//        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//
//        robot1.mouseMove(500, 640);
//        Thread.sleep(1500);
//        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //переходим в настройки
//        System.out.println("переходим в настройки");
//        Thread.sleep(500);
//        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

//        robot1.mouseMove(500, 510);
//        Thread.sleep(1000);
//        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //переходим к выбору скорости
//        Thread.sleep(500);
//        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//
//        robot1.mouseMove(660, 600);
//        Thread.sleep(1000);
//        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //двигаем ползунок вниз
//        Thread.sleep(500);
//        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//
//        robot1.mouseMove(630, 580);
//        Thread.sleep(1000);
//        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //выбираем двойную скорость
//        Thread.sleep(500);
//        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
