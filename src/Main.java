import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.out.println("Система автоматизації складу запущена...");

        // 1. runAsync() — повідомлення про старт процесу.
        CompletableFuture<Void> startProcess = CompletableFuture.runAsync(() -> {
            System.out.println("runAsync: Розпочато прийом нової партії товарів...");
            try {
                TimeUnit.SECONDS.sleep(1); // Імітація процесу старту
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 2. supplyAsync() — завантаження списку товарів.
        CompletableFuture<List<String>> loadGoods = startProcess.thenCompose(ignored ->
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("supplyAsync: Завантаження списку товарів...");
                    try {
                        TimeUnit.SECONDS.sleep(2); // Імітація затримки завантаження
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return List.of("Товар 1", "Товар 2", "Товар 3"); // Список товарів
                })
        );

        // 3. thenApplyAsync() — обробка списку товарів (зміна статусу).
        CompletableFuture<List<String>> processGoods = loadGoods.thenApplyAsync(goods -> {
            System.out.println("thenApplyAsync: Обробка товарів...");
            try {
                TimeUnit.SECONDS.sleep(1); // Імітація обробки
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return goods.stream().map(good -> good + " - готовий до зберігання").toList();
        });

        // 4. thenAcceptAsync() — виведення результату обробки.
        CompletableFuture<Void> displayProcessedGoods = processGoods.thenAcceptAsync(processedGoods -> {
            System.out.println("thenAcceptAsync: Список оброблених товарів:");
            processedGoods.forEach(System.out::println);
        });

        // 5. thenRunAsync() — повідомлення про завершення роботи.
        displayProcessedGoods.thenRunAsync(() -> {
            System.out.println("thenRunAsync: Роботу завершено. Усі товари готові до зберігання.");
        });

        // Очікування завершення всіх задач
        try {
            displayProcessedGoods.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Система автоматизації складу завершила роботу.");
    }
}
