package com.ufaz.shhyrinth.entities.objects;

import com.badlogic.gdx.math.Rectangle;
import com.github.tommyettinger.textra.TypingLabel;
import com.ufaz.shhyrinth.data.Assets;

public class Dialog extends Object{

    public Dialog(String text, Rectangle rectangle) {
        label = new TypingLabel(text, Assets.instance.mainSkin);
        this.rectangle = rectangle;
    }


}
