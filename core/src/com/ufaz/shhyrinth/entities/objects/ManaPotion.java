package com.ufaz.shhyrinth.entities.objects;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.github.tommyettinger.textra.TypingLabel;
import com.ufaz.shhyrinth.data.Assets;

public class ManaPotion extends Item {
    public ManaPotion() {
        itemImage = new Image(Assets.instance.objectsAtlas.findRegion("manaPotion"));
        label = new TypingLabel("{FASTER}{SHRINK=1.0;1.0;true}[%50]Mana Potion \nRestores 70 MP\n" +
                "x1 obta ined[%][@regular]{ENDSHRINK}", Assets.instance.mainSkin, "regular");
        emptyLabel = new TypingLabel("{FASTER}{SHRINK=1.0;1.0;true}[%50]Max. quantity\n" +
                "of potions\nreached.[%][@regular]{ENDSHRINK}", Assets.instance.mainSkin, "regular");
    }
}
