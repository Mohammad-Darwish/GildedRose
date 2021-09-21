package com.gildedrose;

class GildedRose {
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String anObject = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item rose = items[i];
            updateRoseQualityAndSellIn(rose);
        }
    }

    private void updateRoseQualityAndSellIn(Item rose) {
        firstQualityCheck(rose);
        updateSellIn(rose);
        secondQualityCheck(rose);
    }

    private void secondQualityCheck(Item rose) {
        if (rose.getSellIn() < 0) {
            possiblityOneUpOrDownOrGoToZero(rose);
        }
    }

    private void possiblityOneUpOrDownOrGoToZero(Item rose) {
        if (!rose.getName().equals(AGED_BRIE)) {
            if (moreThanZeroWithNotBackstageNotAnObject(rose)) {
                rose.setQuality(rose.getQuality() - 1);
            } else {
                rose.setQuality(0);
            }
        } else if (rose.getQuality() < 50){
            rose.setQuality(rose.getQuality() + 1);
        }
    }

    private boolean moreThanZeroWithNotBackstageNotAnObject(Item rose) {
        return !rose.getName().equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT) &&
            rose.getQuality() > 0 && !rose.getName().equals(anObject);
    }

    private void updateSellIn(Item rose) {
        if (!rose.getName().equals(anObject)) {
            rose.setSellIn(rose.getSellIn() - 1);
        }
    }

    private void firstQualityCheck(Item rose) {
        if (nonOfTheNames(rose)) {
                    rose.setQuality(rose.getQuality() - 1);
        } else {
            threePossibleIncreasment(rose);
        }
    }

    private void threePossibleIncreasment(Item rose) {
        if (rose.getQuality() < 50) {
            rose.setQuality(rose.getQuality() + 1);
            if (lessElevenAndfifty(rose)) {
                rose.setQuality(rose.getQuality() + 1);
                if (rose.getSellIn() < 6 && rose.getQuality() < 50 ) {
                        rose.setQuality(rose.getQuality() + 1);

                }
            }
        }
    }

    private boolean lessElevenAndfifty(Item rose) {
        return rose.getName().equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT) &&
            rose.getSellIn() < 11 && rose.getQuality() < 50;
    }

    private boolean nonOfTheNames(Item rose) {
        return !rose.getName().equals(AGED_BRIE) &&
            !rose.getName().equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT) &&
            rose.getQuality() > 0 && !rose.getName().equals(anObject);
    }
}
