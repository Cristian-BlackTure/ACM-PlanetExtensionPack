package UAW.entities.bullet;

import UAW.content.UAWSfx;
import arc.Core;
import arc.audio.Sound;
import arc.graphics.Color;
import arc.graphics.g2d.*;
import arc.util.*;
import mindustry.content.Fx;
import mindustry.entities.*;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.*;
import mindustry.graphics.*;

public class MineBulletType extends BulletType {
	public Color mineColor = Color.valueOf("ffd37f"), detonationColor = Color.red;
	public TextureRegion mineBase, mineCell, mineLight, mineOutline;
	public String sprite;
	public Sound detonationSound = UAWSfx.mineDetonate1;
	public Effect triggerEffect = Fx.smeltsmoke;
	/**
	 * The distance of unit that will make the mine detonates, -1 to make it scales with splashDamageRadius
	 */
	public float explodeRange = -1;
	/**
	 * Time delay of mine detonating when unit steps in its radius
	 */
	public float explodeDelay = 30f;
	/**
	 * How big is the mine
	 */
	public float size = 20;

	public MineBulletType(float damage, float radius, float lifetime, String sprite) {
		this.splashDamage = damage;
		this.splashDamageRadius = radius;
		this.lifetime = lifetime;
		this.sprite = sprite;
		layer = Layer.debris - 1;
		collidesAir = false;
		collidesGround = collidesTiles = true;
		speed = 3f;
		drag = 0.055f;
		hitShake = 8f;
		hitSound = Sounds.plasmaboom;
		fragAngle = 360;
	}

	public MineBulletType(float damage, float radius, float lifetime) {
		this(damage, radius, lifetime, "uaw-mine");
	}

	public MineBulletType(float damage, float radius) {
		this(damage, radius, 25 * 60, "uaw-mine");
	}

	public MineBulletType() {
		this(550, 64, 25 * 60, "uaw-mine");
	}

	@Override
	public void load() {
		mineBase = Core.atlas.find(sprite);
		mineCell = Core.atlas.find(sprite + "-cell");
		mineLight = Core.atlas.find(sprite + "-light");
		mineOutline = Core.atlas.find(sprite + "-outline");
	}

	@Override
	public void update(Bullet b) {
		super.update(b);
		if (explodeRange < 0) {
			explodeRange = splashDamageRadius / 4;
		}
		// Copied from flakBullet
		if (b.fdata < 0f) return;
		if (b.timer(2, 6)) {
			Units.nearbyEnemies(b.team, Tmp.r1.setSize(explodeRange * 2f).setCenter(b.x, b.y), unit -> {
					if (b.fdata < 0f || !unit.checkTarget(collidesAir, collidesGround)) return;
					if (unit.within(b, explodeRange)) {
						triggerEffect.at(b.x, b.y);
						detonationSound.at(b.x, b.y);
						b.fdata = -1f;
						Time.run(explodeDelay, () -> {
								if (b.fdata < 0) {
									b.time = b.lifetime;
								}
							}
						);
					}
				}
			);
		}
	}

	@Override
	public void draw(Bullet b) {
		Drawf.shadow(b.x, b.y, size * 1.7f);
		Draw.rect(mineOutline, b.x, b.y, size, size, b.rotation());
		Draw.rect(mineBase, b.x, b.y, size, size, b.rotation());

		Draw.color(mineColor);
		Draw.rect(mineCell, b.x, b.y, size, size, b.rotation());

		if (b.fdata() < 0) {
			Draw.color(detonationColor);
			Draw.rect(mineLight, b.x, b.y, size, size, b.rotation());
		}
		Draw.reset();
	}

}