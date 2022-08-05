import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.*;
import java.awt.event.InputEvent;

public class Liker {
    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webDriver.chrome.driver", "Selenium\\chromedriver.exe"); //системная настройка
        for (int i = 0; i < 10; i++) { //запускаем 10 потоков с интервалом 25 секунд - более 10 не тянет местный интернет
            new Watcher().start();
            Thread.sleep(25000);
        }
    }

    public static class Watcher extends Thread {

        public void run() {
            //super.run();
            //System.setProperty("webdriver.chrome.driver", "Selenium\\chromedriver.exe");
            //for (int i = 0; i < 20; i++) {
            WebDriver driver = new ChromeDriver();
            driver.navigate().to("https://www.youtube.com/watch?v=oAYOzRwtDg4&list=UUMOYFUwyTHCggfXitcD7ciA&index=1");//Канал Yoga_FreshBar
            driver.manage().window().maximize();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                synchronized (Watcher.class) {
                    pressingButtons();
                }
            } catch (AWTException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //System.out.println(Thread.currentThread() + "запустил цикл " + (i + 1));

            Robot robot = null; //создаём робота управления мышкой
            try {
                robot = new Robot();
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
            String address = "https://www.youtube.com/watch?v=Q0PLP8qyLEU&list=UUMOYFUwyTHCggfXitcD7ciA&index=";
            for (int j = 0; j < 41; j++) { //цикл на 41 видео
                System.out.println(Thread.currentThread().getName() + " смотрит ролик № " + (j + 1));
                driver.manage().window().minimize(); //прячем экран
                try {
                    Thread.sleep(60000); //смотрим ролик 60 секунд
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                driver.manage().window().maximize(); //возвращаем экран
                driver.navigate().to(address + (j + 1)); //включаем следующее видео на канале
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    synchronized (Watcher.class) {
//                        robot.mouseMove(240, 660); //Следующее видео
//                        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//                        try {
//                            Thread.sleep(500);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            }

            System.out.println(Thread.currentThread().getName() + "насмотрелся");
            driver.quit(); //закончили просмотр всех роликов на канале
            this.interrupt();
        }
    }
    //}

    public static synchronized void pressingButtons() throws AWTException, InterruptedException {
        Robot robot1 = new Robot(); //создаём робота
        //System.out.println("робот создан");
        robot1.mouseMove(1080, 720);
        Thread.sleep(400);
        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //сползаем вниз
        //System.out.println("скролим вниз");
        Thread.sleep(400);
        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(400);

        robot1.mouseMove(990, 740); //принять все
        //System.out.println("Принять всё");
        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(400);
        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);

//        robot1.mouseMove(370, 370);
//        Thread.sleep(3000);
//        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //воспроизвести всё
//        //System.out.println("Воспроизвести всё");
//        Thread.sleep(400);
//        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

//        robot1.mouseMove(190, 600);
//        Thread.sleep(1500);
//        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //переходим по рекламе
//        //System.out.println("Выключаем звук");
//        Thread.sleep(400);
//        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


        robot1.mouseMove(280, 660);
        Thread.sleep(2000);
        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //выключаем звук
        //System.out.println("Выключаем звук");
        Thread.sleep(400);
        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        //Thread.sleep(30000); //пауза на рекламу 30 секунд

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

