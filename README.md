Борщ Павло, група ТВ-21
Практичне заняття №4

## Завдання

Організувати асинхронне виконання задач, використовуючи матеріали 6 і 7 лекцій.
Напишіть програму, в якій продемонструйте роботу з методами класу CompletableFuture, а саме: runAsync(), supplyAsync(), thenApplyAsync(), thenAcceptAsync(), thenRunAsync().
Що саме буде виконувати ваша задача можете придумати самостійно. головне продемонструвати коректну роботу усіх методів.
Наприклад:
  - runAsync() – виводить повідомлення про те, що у фоні стартували асинхронні задачі;
  - supplyAsync() – завантажує дані, thenApplyAsync() модифікує їх, а
  - thenAcceptAsync() - виводить попередній результат через println();
  - thenRunAsync() – виводить повідомлення про завершення фонових асинхронних задач.

Мета завдання – продемонструвати коректну роботу кожного з цих методів.


## Реалізація

Програма імітує роботу системи автоматизації складу. У програмі:
  runAsync() повідомляє про початок прийому нової партії товарів.
  supplyAsync() завантажує список товарів (наприклад, "Товар 1", "Товар 2", "Товар 3").
  thenApplyAsync() обробляє завантажені дані, додаючи до кожного товару статус "готовий до зберігання".
  thenAcceptAsync() виводить на екран список оброблених товарів.
  thenRunAsync() завершує процес повідомленням про успішне завершення всіх задач.
