package kz.javaworkshop;

public class Hero {
    private final String name;
    private final Inventory inventory;

    public Hero(String name, int capacity, int maxWeightGrams) {
        if (name == null) {
            throw new IllegalArgumentException("Имя героя не может быть null");
        }
        String trimmedName = name.strip();
        if (trimmedName.length() < 1 || trimmedName.length() > 40) {
            throw new IllegalArgumentException("Длина имени должна быть от 1 до 40 символов");
        }
        this.name = trimmedName;
        this.inventory = new Inventory(capacity, maxWeightGrams);
    }

    public boolean pickUp(Item item) {
        return inventory.add(item);
    }

    public int itemCount() {
        return inventory.size();
    }

    public int totalWeightGrams() {
        return inventory.totalWeightGrams();
    }

    public long totalValue() {
        return inventory.totalValue();
    }

    public Item[] items() {
        return inventory.snapshot();
    }

    public String getName() {
        return name;
    }
}