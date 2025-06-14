package com.ufaz.shhyrinth.entities.spells;

import com.badlogic.gdx.utils.Pool;
import com.ufaz.shhyrinth.engines.PoolEngine;
import com.ufaz.shhyrinth.entities.Player;
import com.ufaz.shhyrinth.util.AttackType;
import com.ufaz.shhyrinth.util.GameHelper;

import static com.ufaz.shhyrinth.util.Constants.*;
import static com.ufaz.shhyrinth.util.Direction.*;

public class IceSpell extends Spell {

    public static final String TAG = IceSpell.class.getName();

    private static final Pool<IceSpell> iceSpellPool = new Pool<IceSpell>() {
        @Override
        protected IceSpell newObject() {
            return new IceSpell();
        }
    };

    public static void create(PoolEngine pool, Player player, AttackType type) {
        IceSpell spell = iceSpellPool.obtain();
        spell.init(player, type);
        pool.add(spell);
    }

    @Override
    protected void init(Player player, AttackType attackType) {
        super.init(player, attackType);
        setIceAnimations(attackType);
    }

    private void setIceAnimations(AttackType attackType) {
        if (attackType == AttackType.BASIC) {
            basicAttackAnimations();
        } else if (attackType == AttackType.STRONG) {
            strongAttackAnimations();
        }
    }

    private void basicAttackAnimations() {
        if ((vel.x < 0 && vel.y == 0) || (vel.x == 0 && vel.y == 0 && lastDir == LEFT)) {
            animation = GameHelper.setAnimation(FRAME_DURATION, ICE_SPELL_LEFT);
        } else if ((vel.x > 0 && vel.y == 0) || (vel.x == 0 && vel.y == 0 && lastDir == RIGHT)) {
            animation = GameHelper.setAnimation(FRAME_DURATION, ICE_SPELL_RIGHT);
        } else if ((vel.x == 0 && vel.y > 0) || (vel.x == 0 && vel.y == 0 && lastDir == UP)) {
            animation = GameHelper.setAnimation(FRAME_DURATION, ICE_SPELL_UP);
        } else if ((vel.x == 0 && vel.y < 0) || (vel.x == 0 && vel.y == 0 && lastDir == DOWN)) {
            animation = GameHelper.setAnimation(FRAME_DURATION, ICE_SPELL_DOWN);
        } else if (vel.x < 0 && vel.y > 0) {
            animation = GameHelper.setAnimation(FRAME_DURATION, ICE_SPELL_LEFT_UP);
        } else if (vel.x < 0 && vel.y < 0) {
            animation = GameHelper.setAnimation(FRAME_DURATION, ICE_SPELL_LEFT_DOWN);
        } else if (vel.x > 0 && vel.y > 0) {
            animation = GameHelper.setAnimation(FRAME_DURATION, ICE_SPELL_RIGHT_UP);
        } else if (vel.x > 0 && vel.y < 0) {
            animation = GameHelper.setAnimation(FRAME_DURATION, ICE_SPELL_RIGHT_DOWN);

        }
    }

    private void strongAttackAnimations() {
        if ((vel.x < 0 && vel.y == 0) || (vel.x == 0 && vel.y == 0 && lastDir == LEFT)) {
            animation = GameHelper.setAnimation(FRAME_DURATION_STRONG, ICE2_SPELL_LEFT);
        } else if ((vel.x > 0 && vel.y == 0) || (vel.x == 0 && vel.y == 0 && lastDir == RIGHT)) {
            animation = GameHelper.setAnimation(FRAME_DURATION_STRONG, ICE2_SPELL_RIGHT);
        } else if ((vel.x == 0 && vel.y > 0) || (vel.x == 0 && vel.y == 0 && lastDir == UP)) {
            animation = GameHelper.setAnimation(FRAME_DURATION_STRONG, ICE2_SPELL_UP);
        } else if ((vel.x == 0 && vel.y < 0) || (vel.x == 0 && vel.y == 0 && lastDir == DOWN)) {
            animation = GameHelper.setAnimation(FRAME_DURATION_STRONG, ICE2_SPELL_DOWN);
        } else if (vel.x < 0 && vel.y > 0) {
            animation = GameHelper.setAnimation(FRAME_DURATION_STRONG, ICE2_SPELL_LEFT_UP);
        } else if (vel.x < 0 && vel.y < 0) {
            animation = GameHelper.setAnimation(FRAME_DURATION_STRONG, ICE2_SPELL_LEFT_DOWN);
        } else if (vel.x > 0 && vel.y > 0) {
            animation = GameHelper.setAnimation(FRAME_DURATION_STRONG, ICE2_SPELL_RIGHT_UP);
        } else if (vel.x > 0 && vel.y < 0) {
            animation = GameHelper.setAnimation(FRAME_DURATION_STRONG, ICE2_SPELL_RIGHT_DOWN);
        }

    }

    @Override
    public void release() {
        iceSpellPool.free(this);
    }

}
