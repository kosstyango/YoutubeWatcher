import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.JsonToWebElementConverter;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.ArrayList;

public class Liker {
    public static void main(String[] args) throws InterruptedException, AWTException {
        ArrayList<String> address = new ArrayList<>();

        address.add("https://www.youtube.com/watch?v=1ljV4dqaSPA");// Гимнастика для глаз (226 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=Kde1-uKhhBU");// Утренняя разминка (236 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=5ssF3AM4Kd4");// Силовой комплекс на ноги и ягодицы (223 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=XKiXtOOhBQ4");// Слим марафон 8 (193 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=J3P_thgvzvI");// Слим марафон 3 (182 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=thmBZFe-XTU");// Сурья намаскар (246 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=oNAMGepDjqk");// Слим марафон (218 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=ffXjSOJDXKU");// Работа со стопой (235 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=xt5TpDD7VO8");// Пресс (252 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=Sezu8ZSULfM");// Пранаямы д/реабилитации (211 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=pmLHLeZ5Mm8");// Слим марафон 2 (160 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=U94P_QV8sek");// Комплекс раскрытия ТЗБ (285 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=qZj854lwJYU");// Пранаямы (209 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=D3t5bbUIoBg");// Зарядка 3 (207 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=s1wNLmQHpZE");// Сбалансированная практика (162 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=r9fcijBHgoM");// Йога для шеи (193 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=YtDcSCsy9Yg");// Йога на спину (220 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=xhpr5Qs1_ZA");// Миофасциальный релиз (180 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=PReP97oAjfo");// Приветствие луне (165 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=ufAeUNZWgW4");// Йога для спины (216 на 10.12.23)
        address.add("https://www.youtube.com/watch?v=oDhpQr4J-wYh");// Слим марафон 6 (318 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=81r6eGhtf5M");// Пранаямы для восстановления после болезни (178 на 10.12.23)
        address.add("https://www.youtube.com/watch?v=sDEFWTcMj2E");// Раскрытие грудного отдела (213 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=jB5s5Z9Kxxc");// Самаконасана (187 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=wr21pXdJ2KE");// Массаж лица (194 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=IAxpyRVSSFs");// Утренняя зарядка (182 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=aeX7ibapPfY");// Суставная гимнастика (166 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=ZVwHbA4_GuA");// Slim marathon (172 на 10.12.23);
        address.add("https://www.youtube.com/watch?v=NMX6vigpZfc");// Утренняя зарядка 2 (201 на 10.12.23);
        address.add("https://www.instagram.com/p/C1AIRwjoAZr/");// Рислс на прокачку (195 на 11.01.24);
        address.add("https://www.youtube.com/watch?v=thmBZFe-XTU");// Сурья намаскар (246 на 10.12.23);

        System.setProperty("webDriver.chrome.driver", "Selenium\\chromedriver.exe"); //системная настройка
        System.out.println("Системная настройка проведена успешно");
        Thread threads[] = new Thread[20]; //создаём массив на 20 элементов
        System.out.println("Массив создан успешно");
        for (int i = 0; i < threads.length; i++) { //создаём потоки
            Thread thread = new Watcher(address);
            System.out.println("Поток "+i+" успешно создан");
            threads[i] = thread; //и складываем потоки в массив threads
            thread.start(); // запускаем созданный поток
            Thread.sleep(15000); //с интервалом 15 секунд
        }
        System.out.println("Все потоки созданы и запущены");

        while (true){ //запускаем бесконечный цикл
            Thread.sleep(300000); //с интервалом 300 секунд
            System.out.println("Самосканирование запущено:");
                        for (int j=0; j<threads.length; j++) {
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
            System.out.println("Поток стартовал");
            WebDriver driver = new ChromeDriver();
            System.out.println("ChromeDriver создан");
            driver.get("https://www.youtube.com/watch?v=tETVj030swo&t=140s"); //открываем первый ролик 58 просмотров на 11.01.24
            System.out.println("первый ролик открыт");
            driver.manage().window().maximize();
            System.out.println("открываем Chrome в полный размер");
            try {
                Thread.sleep(1000); //ждём 1 секунду
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Liker.pressingButtons(); // Нажимаем нужные кнопки для старта
            } catch (AWTException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            int index;
            while (true) { //запускаем бесконечный цикл
                //System.out.println("Дошли до бесконечного цикла");
                index = (int) (Math.random()* addressMap.size());
                driver.get(addressMap.get(index)); //запускаем видео
                driver.manage().window().minimize(); //прячем окно
                System.out.println(Thread.currentThread().getName() + " смотрит ролик "+ index);
                try {
                    Thread.sleep(30000); //смотрим ролик 30 секунд
                } catch (InterruptedException e) {
                    continue;
                }
            }
        }
    }

    public static synchronized void pressingButtons() throws AWTException, InterruptedException {
        Robot robot1 = new Robot(); //создаём робота
        System.out.println(Thread.currentThread().getName() + " работает робот");
//        robot1.mouseMove(1085, 720);
//        Thread.sleep(2000);
//        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //сползаем вниз
//        System.out.println("скролим вниз");
//        Thread.sleep(500);
//        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        Thread.sleep(2000);

//        robot1.mouseMove(1040, 740); //принять все???
//        Thread.sleep(2000);
//        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        Thread.sleep(500);
//        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        Thread.sleep(2000);

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

