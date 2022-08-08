import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.JsonToWebElementConverter;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.ArrayList;

public class Liker {
    public static void main(String[] args) throws InterruptedException, AWTException {
        ArrayList<String> address = new ArrayList<>();
        address.add("https://www.youtube.com/watch?v=yMZozCGKo7A");// Пранаямы (47);
        address.add("https://www.youtube.com/watch?v=ykjToGfSzOk");// Слим марафон 3 (52);
        address.add("https://www.youtube.com/watch?v=R0T_a5p7Rps");// Слим марафон 5 (52)
        address.add("https://www.youtube.com/watch?v=oDhpQr4J-wY");// Слим марафон 6 (60);
        address.add("https://www.youtube.com/watch?v=1ljV4dqaSPA");// Гимнастика для глаз (72);
        address.add("https://www.youtube.com/watch?v=Kde1-uKhhBU");// Утренняя разминка (46);
        address.add("https://www.youtube.com/watch?v=5ssF3AM4Kd4");// Силовой комплекс на ноги и ягодицы;
        address.add("https://www.youtube.com/watch?v=XKiXtOOhBQ4");// Слим марафон 8 (52);
        address.add("https://www.youtube.com/watch?v=J3P_thgvzvI");// Слим марафон 3 (53);
        address.add("https://www.youtube.com/watch?v=thmBZFe-XTU");// Сурья намаскар (36);
        address.add("https://www.youtube.com/watch?v=oNAMGepDjqk");// Слим марафон (53);
        address.add("https://www.youtube.com/watch?v=ffXjSOJDXKU");// Работа со стопой (78);
        address.add("https://www.youtube.com/watch?v=xt5TpDD7VO8");// Пресс (44);
        address.add("https://www.youtube.com/watch?v=Sezu8ZSULfM");// Пранаямы д/реабилитации (42);
        address.add("https://www.youtube.com/watch?v=pmLHLeZ5Mm8");// Слим марафон 2 (45);
        address.add("https://www.youtube.com/watch?v=U94P_QV8sek");// Комплекс раскрытия ТЗБ (41);
        address.add("https://www.youtube.com/watch?v=qZj854lwJYU");// Пранаямы (51);
        address.add("https://www.youtube.com/watch?v=D3t5bbUIoBg");// Зарядка 3 (52);
        address.add("https://www.youtube.com/watch?v=s1wNLmQHpZE");// Сбалансированная практика (57);
        address.add("https://www.youtube.com/watch?v=r9fcijBHgoM");// Йога для шеи (45);
        address.add("https://www.youtube.com/watch?v=YtDcSCsy9Yg");// Йога на спину (57);
        address.add("https://www.youtube.com/watch?v=xhpr5Qs1_ZA");// Миофасциальный релиз (64);
        address.add("https://www.youtube.com/watch?v=PReP97oAjfo");// Приветствие луне (65);
        address.add("https://www.youtube.com/watch?v=ufAeUNZWgW4");// Йога для спины (66);
        address.add("https://www.youtube.com/watch?v=oDhpQr4J-wYh");// Слим марафон 6 (60);
        address.add("https://www.youtube.com/watch?v=81r6eGhtf5M");// Пранаямы для восстановления после болезни.
        address.add("https://www.youtube.com/watch?v=sDEFWTcMj2E");// Раскрытие грудного отдела (54);
        address.add("https://www.youtube.com/watch?v=jB5s5Z9Kxxc");// Самаконасана (65);
        address.add("https://www.youtube.com/watch?v=wr21pXdJ2KE");// Массаж лица (68);
        address.add("https://www.youtube.com/watch?v=IAxpyRVSSFs");// Утренняя зарядка (68);
        address.add("https://www.youtube.com/watch?v=aeX7ibapPfY");// Суставная гимнастика (55);
        address.add("https://www.youtube.com/watch?v=ZVwHbA4_GuA");// Slim marathon (69);
        address.add("https://www.youtube.com/watch?v=NMX6vigpZfc");// Утренняя зарядка 2 (99);
        address.add("https://www.youtube.com/watch?v=thmBZFe-XTU");// Сурья намаскар (36);
        address.add("https://www.youtube.com/watch?v=xt5TpDD7VO8");// Пресс (44);
        address.add("https://www.youtube.com/watch?v=Sezu8ZSULfM");// Пранаямы для реабилитации после вирусных заболеваний (42)
        address.add("https://www.youtube.com/watch?v=U94P_QV8sek");// Комплекс для раскрытия тазобедренного сустава (41);
        address.add("https://www.youtube.com/watch?v=Kde1-uKhhBU");// Утренняя разминка (46);

        //System.setProperty("webDriver.chrome.driver", "Selenium\\chromedriver.exe"); //системная настройка
        Thread threads[] = new Thread[10]; //создаём массив на 10 элементов

        for (int i = 0; i < threads.length; i++) { //создаём потоки
            Thread thread = new Watcher(address);
            threads[i] = thread; //и складываем потоки в массив threads
            thread.start();
            Thread.sleep(15000); //с интервалом 15 секунд
        }
        System.out.println("Потоки созданы и запущены");

        while (true){ //запускаем бесконечный цикл
            Thread.sleep(100000); //с интервалом 100 секунд
            System.out.println("Самосканирование запущено:");
                        for (int j=0; j<threads.length; j++) {
                            System.out.print("\r" + (j+1)*10 + "%");
                if (!threads[j].isAlive()) //проверяем поток на живость
                {
                    System.out.println("Поток " + threads[j].getName() + " мёртв");
                    threads[j].interrupt(); //прерываем поток
                    Thread thread = new Watcher(address); //создаём новый поток
                    threads[j] = thread; // кладём новый поток в массив
                    System.out.println("Запускаем новый поток " + thread.getName());
                    thread.start();//запускаем новый поток
                }
            }
                System.out.println("все потоки живы");
        }
    }

    public static class Watcher extends Thread {
        ArrayList<String> addressMap;
        public Watcher(ArrayList<String> address) {
            this.addressMap = address;
        }

        public void run() {
            super.run();

            WebDriver driver = new ChromeDriver();
            driver.get("https://www.youtube.com/watch?v=yMZozCGKo7A"); //открываем первый ролик
            driver.manage().window().maximize();
            try {
                Liker.pressingButtons(); // Нажимаем нужные кнопки для старта
            } catch (AWTException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int index;
            while (true) { //запускаем бесконечный цикл
                index = (int) (Math.random()* addressMap.size());
                driver.get(addressMap.get(index)); //запускаем видео
                driver.manage().window().minimize(); //прячем окно
                System.out.println(Thread.currentThread().getName() + " смотрит ролик "+ index);
                try {
                    Thread.sleep(180000); //смотрим ролик 180 секунд
                } catch (InterruptedException e) {
                    continue;
                }
            }
        }
    }

    public static synchronized void pressingButtons() throws AWTException, InterruptedException {
        Robot robot1 = new Robot(); //создаём робота

        robot1.mouseMove(1085, 720);
        Thread.sleep(1000);
        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //сползаем вниз
        //System.out.println("скролим вниз");
        Thread.sleep(500);
        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        robot1.mouseMove(1040, 740); //принять все
        Thread.sleep(1000);
        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(400);
        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);

        robot1.mouseMove(235, 670);
        Thread.sleep(1000);
        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //выключаем звук
        //System.out.println("Выключаем звук");
        Thread.sleep(500);
        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

//        robot1.mouseMove(755, 670);
//        Thread.sleep(1000);
//        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //переходим в настройки
//        //System.out.println("переходим в настройки");
//        Thread.sleep(500);
//        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//
//        robot1.mouseMove(755, 520);
//        Thread.sleep(1000);
//        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //переходим к выбору скорости
//        Thread.sleep(500);
//        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

//        robot1.mouseMove(965, 600);
//        Thread.sleep(1000);
//        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //двигаем ползунок вниз
//        Thread.sleep(500);
//        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//
//        robot1.mouseMove(900, 600);
//        Thread.sleep(1000);
//        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //выбираем двойную скорость
//        Thread.sleep(500);
//        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}

