package com.ufaz.shhyrinth.util;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class ImageAnimation extends Image {
    private Animation<TextureRegion> animation;

    private float time;
    protected float speed = 1f;

    protected TextureRegionDrawable drawable = new TextureRegionDrawable();

    public ImageAnimation() {
        super();
        setDrawable(drawable);
    }

    public void setAnimation(Animation<TextureRegion> animation) {
        this.animation = animation;
    }

    public void setPose(TextureRegion textureRegion) {
        drawable.setRegion(textureRegion);
        setDrawable(drawable);
        invalidateHierarchy();
        setSize(getPrefWidth(), getPrefHeight());
        invalidate();
    }

    @Override
    public void act(float delta) {
        time += delta * speed;
        if (animation != null && animation.getAnimationDuration() > 0) {
            TextureRegion frame = animation.getKeyFrame(time, true);
            drawable.setRegion(frame);
            setDrawable(drawable);
        }
//        else {
//             setDrawable(null);
//        }
        super.act(delta);
    }

    public Animation<TextureRegion> getAnimation() {
        return animation;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

}