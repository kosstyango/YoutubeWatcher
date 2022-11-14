import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Liker {
    public static void main(String[] args) throws InterruptedException, AWTException, IOException {
        ArrayList<String> names = new ArrayList<>();
        names.add("Yulia");
        names.add("Nadezda");
        names.add("Александра");
        names.add("Анастасия");
        names.add("Анжелика");
        names.add("Ярослава");
        names.add("Яна");
        names.add("Юлия");
        names.add("Феодора");
        names.add("Фёкла");
        names.add("Фаина");
        names.add("Урсула");
        names.add("Ульяна");
        names.add("Татьяна");
        names.add("Тамара");
        names.add("Таисия");
        names.add("София");
        names.add("Снежана");
        names.add("Серафима");
        names.add("Светлана");
        names.add("Руслана");
        names.add("Регина");
        names.add("Раиса");
        names.add("Рада");
        names.add("Полина");
        names.add("Пелагея");
        names.add("Ольга");
        names.add("Оксана");
        names.add("Нонна");
        names.add("Нина");
        names.add("Наталья");
        names.add("Надежда");
        names.add("Мирослава");
        names.add("Милица");
        names.add("Мария");
        names.add("Марина");
        names.add("Маргарита");
        names.add("Людмила");
        names.add("Любовь");
        names.add("Лилия");

        ArrayList<String> surnames = new ArrayList<>();
        surnames.add("Смирнова");
        surnames.add("Андреева");
        surnames.add("Макарова");
        surnames.add("Киселёва");
        surnames.add("Орлова");
        surnames.add("Комарова");
        surnames.add("Белова");
        surnames.add("Тарасова");
        surnames.add("Беляева");
        surnames.add("Михайлова");
        surnames.add("Фёдорова");
        surnames.add("Воробьёва");
        surnames.add("Богданова");
        surnames.add("Виноградова");
        surnames.add("Голубева");
        surnames.add("Семёнова");
        surnames.add("Павлова");
        surnames.add("Зайцева");
        surnames.add("Васильева");
        surnames.add("Соловьёва");
        surnames.add("Волкова");
        surnames.add("Петрова");
        surnames.add("Морозова");
        surnames.add("Новикова");
        surnames.add("Козлова");
        surnames.add("Лебедева");
        surnames.add("Попова");
        surnames.add("Соколова");
        surnames.add("Кузнецова");
        surnames.add("Иванова");

        System.setProperty("webDriver.chrome.driver", "Selenium\\chromedriver.exe"); //системная настройка
        for (int i = 1; i < 10; i++) { //запускаем цикл на 10 новых аккаунтов
            registration(names, surnames, i);
            Thread.sleep(30000);
        }
    }

    public static void registration(ArrayList<String> names, ArrayList<String> surnames, int i) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp"); //открываем первую страницу
        driver.manage().window().maximize();
        WebElement element1 = driver.findElement(By.name("firstName"));
        String name = names.get((int) (Math.random() * names.size()));
        System.out.println("Выбрано имя: " + name);
        element1.sendKeys(name);
        Thread.sleep(1000);

        WebElement element2 = driver.findElement(By.name("lastName"));
        String lastName = surnames.get((int) (Math.random() * surnames.size()));
        System.out.println("Выбрана фамилия: " + lastName);
        element2.sendKeys(lastName);
        Thread.sleep(1000);

        WebElement element3 = driver.findElement(By.name("Username"));
        String userName = "names.for.sales"+ (i+1);
        element3.sendKeys(userName);
        Thread.sleep(1000);
        WebElement element4 = driver.findElement(By.name("Passwd"));
        element4.sendKeys("JavaForever2022!");
        Thread.sleep(1000);
        WebElement element5 = driver.findElement(By.name("ConfirmPasswd"));
        element5.sendKeys("JavaForever2022!");
        element5.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        WebElement element6 = driver.findElement(By.id("phoneNumberId"));
        element6.sendKeys("+381638111541");
        element6.sendKeys(Keys.ENTER);

        Thread.sleep(20000);
        WebElement element7 = driver.findElement(By.name("day"));
        String day = Integer.toString(i%30+1);
        System.out.println("Выбран день: " + day);
        element7.sendKeys(day);
        Thread.sleep(1000);
        WebElement element8 = driver.findElement(By.id("month"));
        element8.sendKeys(Integer.toString(3));
        Thread.sleep(1000);
        WebElement element9 = driver.findElement(By.name("year"));
        String year = Integer.toString(1980+i%30+1);
        System.out.println("Выбран год: " + year);
        element9.sendKeys(year);
        Thread.sleep(1000);
        WebElement element10 = driver.findElement(By.id("gender"));
        element10.sendKeys("Женский");

        FileWriter wr = new FileWriter("C:\\Names_for_sales.txt", true);
        System.out.println(name + " " + lastName + " " + day + " марта " + year);
        wr.write(userName+"@google.com " + name + " " + lastName + " " + day + " марта " + year + "\n");
        wr.flush();
    }
}
//    public static class Registrator {
//        ArrayList<String> namesMap;
//        ArrayList<String> surnamesMap;
//        public Registrator(ArrayList<String> names, ArrayList<String> surnames)
//        {
//            this.namesMap = names;
//            this.surnamesMap = surnames;
//        }
//

//            try {
//                Liker.pressingButtons(); // Нажимаем нужные кнопки для старта
//            } catch (AWTException e) {
//                throw new RuntimeException(e);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            int index;
//            while (true) { //запускаем бесконечный цикл
//                index = (int) (Math.random()* addressMap.size());
//                driver.get(addressMap.get(index)); //запускаем видео
//                driver.manage().window().minimize(); //прячем окно
//                System.out.println(Thread.currentThread().getName() + " смотрит ролик "+ index);
//                try {
//                    Thread.sleep(90000); //смотрим ролик 90 секунд
//                } catch (InterruptedException e) {
//                    continue;
//                }
//            }
//
//    public static synchronized void pressingButtons() throws AWTException, InterruptedException {
//
////        Robot robot1 = new Robot(); //создаём робота
//
//        robot1.mouseMove(300, 200);
//        Thread.sleep(500);
//        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //сползаем вниз
//        //System.out.println("скролим вниз");
//        Thread.sleep(500);
//        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//
//        robot1.mouseMove(1040, 740); //принять все
//        Thread.sleep(1000);
//        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        Thread.sleep(400);
//        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        Thread.sleep(2000);
//
//        robot1.mouseMove(235, 670);
//        Thread.sleep(1000);
//        robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK); //выключаем звук
//        //System.out.println("Выключаем звук");
//        Thread.sleep(500);
//        robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//
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
//
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
//    }

