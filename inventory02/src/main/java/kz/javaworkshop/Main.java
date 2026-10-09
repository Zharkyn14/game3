package kz.javaworkshop;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Сценарий Варианта А ===");
        Hero alia = new Hero("Алия", 4, 6000);
        Hero daniyar = new Hero("Данияр", 2, 6000);

        printHero(alia);
        printHero(daniyar);

        Item sword = new Item("Меч", "weapon", 2500, 100);
        Item shield = new Item("Щит", "armor", 3000, 80);
        Item potion = new Item("Зелье", "potion", 500, 20);

        System.out.println("Алия подбирает Меч: " + alia.pickUp(sword));
        System.out.println("Алия подбирает Щит: " + alia.pickUp(shield));
        System.out.println("Алия подбирает Зелье: " + alia.pickUp(potion));

        printHero(alia);

        Item feather = new Item("Перо", "potion", 1, 0);
        System.out.println("Алия подбирает Перо: " + alia.pickUp(feather));

        printHero(daniyar);

        Item map = new Item("Карта", "armor", 100, 5);
        Item torch = new Item("Факел", "weapon", 200, 10);

        System.out.println("Данияр подбирает Карту: " + daniyar.pickUp(map));
        System.out.println("Данияр подбирает Факел: " + daniyar.pickUp(torch));
        System.out.println("Данияр подбирает Перо: " + daniyar.pickUp(feather));

        printHero(alia);
        printHero(daniyar);

        System.out.println("\n=== Дополнительные проверки (Шаг 5) ===");
        
        // 1. pickUp(null)
        Hero testHero = new Hero("Тест", 2, 1000);
        boolean nullResult = testHero.pickUp(null);
        System.out.println("pickUp(null) возвращает: " + nullResult);

        // 2. Замена элементов в снимке
        Item[] snap = alia.items();
        if (snap.length > 0) {
            snap[0] = null;
        }
        System.out.println("После попытки изменения снимка, предметов у Алии: " + alia.itemCount());

        // 3. Алиас
        Hero first = new Hero("Герой1", 2, 1000);
        Hero alias = first;
        alias.pickUp(torch);
        System.out.println("Алиас изменил героя, предметов у first: " + first.itemCount());

        // 4. Некорректное имя (проверка исключения)
        try {
            new Hero("   ", 3, 1000);
        } catch (IllegalArgumentException e) {
            System.out.println("Перехвачено исключение для некорректного имени: " + e.getMessage());
        }
    }

    public static void printHero(Hero hero) {
        Item[] items = hero.items();
        StringBuilder sb = new StringBuilder();
        sb.append(hero.getName()).append(": ")
          .append(hero.itemCount()).append(" предметов, ")
          .append(hero.totalWeightGrams()).append(" г, ")
          .append(hero.totalValue()).append(" монет. Содержимое: [");
        for (int i = 0; i < items.length; i++) {
            sb.append(items[i].getName());
            if (i < items.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}