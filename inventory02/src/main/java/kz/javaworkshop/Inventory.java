package kz.javaworkshop;

import java.util.Arrays;

public class Inventory {
    private final Item[] items;
    private int size;
    private final int maxWeightGrams;

    public Inventory(int capacity, int maxWeightGrams) {
        if (capacity < 1 || capacity > 20) {
            throw new IllegalArgumentException("Вместимость инвентаря должна быть от 1 до 20 ячеек");
        }
        if (maxWeightGrams < 1 || maxWeightGrams > 100001) {
            throw new IllegalArgumentException("Лимит массы должен быть от 1 до 100001 г");
        }
        this.items = new Item[capacity];
        this.maxWeightGrams = maxWeightGrams;
        this.size = 0;
    }

    public boolean add(Item item) {
        if (item == null) {
            return false;
        }
        if (size >= items.length) {
            return false;
        }
        if (totalWeightGrams() + item.getWeightGrams() > maxWeightGrams) {
            return false;
        }
        items[size] = item;
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    public int totalWeightGrams() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += items[i].getWeightGrams();
        }
        return sum;
    }

    public long totalValue() {
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += items[i].getValue();
        }
        return sum;
    }

    public Item[] snapshot() {
        return Arrays.copyOf(items, size);
    }
}