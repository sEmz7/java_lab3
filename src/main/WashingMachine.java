package main;

public abstract class WashingMachine {
    protected int loadedWeight = 0;
    protected int max_linenWeight;
    protected Linen linen = new Linen();


    public void setLinen(Linen linen) {
        this.linen = linen;
    }

    public Linen getLinen() {
        return linen;
    }

    public WashingMachine(int weight) {
        this.max_linenWeight = weight;
    }


    public String load(Linen linen) {
        if (linen.getLinenWeight() + loadedWeight > max_linenWeight) {
            return "Превышена максимальная вместимость стиралки";
        }
        this.loadedWeight += linen.getLinenWeight();
        setLinen(linen);
        return "Добавлено белье массой  "+ linen.getLinenWeight() + "кг. Текущая масса " + loadedWeight + "кг";
    }

    @Override
    public String toString() {
        return "Стиральная машина загружена на " + loadedWeight + "кг. Тип белья " + linen.getLinentype() + ". Температура стирки " + linen.getTemperature() + " градусов";
    }
}