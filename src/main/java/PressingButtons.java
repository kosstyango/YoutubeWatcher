import java.awt.*;
import java.awt.event.InputEvent;

public class PressingButtons {
    public static synchronized void pressingButtons() throws AWTException, InterruptedException {
        Robot robot1 = new Robot(); //создаём робота

        robot1.mouseMove(240, 660);
        Thread.sleep(1000);
        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //выключаем звук
        System.out.println("Выключаем звук");
        Thread.sleep(400);
        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


        robot1.mouseMove(800, 670);
        Thread.sleep(1000);
        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //переходим в настройки
        System.out.println("переходим в настройки");
        Thread.sleep(400);
        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


        robot1.mouseMove(800, 560);
        Thread.sleep(1000);
        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //переходим к выбору скорости
        System.out.println("переходим к выбору скорости");
        Thread.sleep(400);
        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


        robot1.mouseMove(965, 600);
        Thread.sleep(1000);
        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //двигаем ползунок вниз
        System.out.println("двигаем ползунок вниз");
        Thread.sleep(400);
        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


        robot1.mouseMove(900, 600);
        Thread.sleep(1000);
        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //выбираем двойную скорость
        System.out.println("выбираем двойную скорость");
        Thread.sleep(400);
        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
