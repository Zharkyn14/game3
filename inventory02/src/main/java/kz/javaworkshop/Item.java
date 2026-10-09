package kz.javaworkshop;

public class Item {
    private final String name;
    private final String type;
    private final int weightGrams;
    private final int value;

    public Item(String name, String type, int weightGrams, int value) {
        if (name == null) {
            throw new IllegalArgumentException("Название предмета не может быть null");
        }
        String trimmedName = name.strip();
        if (trimmedName.length() < 1 || trimmedName.length() > 40) {
            throw new IllegalArgumentException("Длина названия должна быть от 1 до 40 символов");
        }

        if (type == null || (!type.equals("weapon") && !type.equals("armor" ) && !type.equals("potion"))) {
            throw new IllegalArgumentException("Недопустимый тип предмета. Допустимы: weapon, armor, potion");
        }

        if (weightGrams < 1 || weightGrams > 100000) {
            throw new IllegalArgumentException("Масса должна быть в диапазоне от 1 до 100000 грамм");
        }

        if (value < 0 || value > 1000000) {
            throw new IllegalArgumentException("Стоимость должна быть в диапазоне от 0 до 1000000 монет");
        }

        this.name = trimmedName;
        this.type = type;
        this.weightGrams = weightGrams;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getWeightGrams() {
        return weightGrams;
    }

    public int getValue() {
        return value;
    }
}