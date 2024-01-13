public class Liker {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webDriver.chrome.driver", "Selenium\\chromedriver.exe"); //системная настройка Selenium
        System.out.println("Системная настройка проведена успешно");
        Thread[] threads = new Thread[Constants.THREADS_NUMBER]; //создаём массив на 20 элементов
        System.out.println("Массив создан успешно");
        for (int i = 0; i < threads.length; i++) { //создаём потоки
            Thread thread = new Watcher(Constants.addr);
            System.out.println("Поток " + i + " успешно создан");
            threads[i] = thread; //и складываем потоки в массив threads
            thread.start(); // запускаем созданный поток
            Thread.sleep(Constants.THREADS_INTERVAL); //с интервалом 15(?) секунд
        }
        System.out.println("Все потоки созданы и запущены");

        while (true) { //запускаем бесконечный цикл
            Thread.sleep(Constants.THREADS_CHECKING_INTERVAL); //с интервалом 300 секунд
            System.out.println("Самосканирование запущено:");
            for (int j = 0; j < threads.length; j++) {
                if (!threads[j].isAlive()) //проверяем поток на живость
                {
                    System.out.println("Поток " + threads[j].getName() + " мёртв");
                    threads[j].interrupt(); //прерываем поток
                    Thread thread = new Watcher(Constants.addr); //создаём новый поток
                    threads[j] = thread; // кладём новый поток в массив
                    System.out.println("Запускаем новый поток: " + threads[j].getName() +
                            "\nВсего потоков: " + threads.length);
                    threads[j].start();//запускаем новый поток
                }
            }
            System.out.println("все потоки живы: \n" + threads.toString());
        }
    }
}

