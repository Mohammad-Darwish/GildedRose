package com.gildedrose;

public class Item {
    private String name;
    public int SellIn;
    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.SellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.SellIn + ", " + this.quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return SellIn;
    }

    public void setSellIn(int sellIn) {
        this.SellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
