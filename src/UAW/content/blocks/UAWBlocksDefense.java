package UAW.content.blocks;

import UAW.audiovisual.*;
import UAW.content.*;
import UAW.entities.UAWUnitSorts;
import UAW.entities.bullet.BuckshotBulletType;
import UAW.entities.bullet.ModdedVanillaBullet.TrailBulletType;
import UAW.world.blocks.defense.turrets.UAWItemTurret;
import UAW.world.blocks.defense.walls.ShieldWall;
import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.*;
import mindustry.entities.UnitSorts;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.*;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.draw.DrawTurret;

import static UAW.Vars.*;
import static UAW.content.UAWBullets.*;
import static mindustry.Vars.tilesize;
import static mindustry.type.ItemStack.with;


public class UAWBlocksDefense {
	public static Block placeholder,
	// Testing
	javatest;

	public static void load() {

		//region Serpulo
		javatest = new ItemTurret("javatest") {{
			requirements(Category.turret, with(
				Items.copper, 115,
				Items.lead, 120,
				Items.graphite, 80
			));
			size = 2;
			scaledHealth = 160;

			reload = 6f;
			recoil = 1f;
			recoilTime = reload * 4;
			maxAmmo = 30;

			range = 20 * tilesize;
			shootCone = 15f;
			inaccuracy = 7.5f;
			rotateSpeed = 10f;

			ammoUseEffect = Fx.casing2Double;

			shoot = new ShootAlternate() {{
				barrels = 2;
				shots = 2;
				barrelOffset = 5;
				spread = 4f;
			}};

			ammo(
				Items.copper, new BasicBulletType(5f, 9) {{
					height = 9f;
					width = 7f;
					lifetime = 60f;
					shootEffect = Fx.shootSmall;
					smokeEffect = Fx.shootSmallSmoke;
					ammoMultiplier = 2;
				}},
				Items.graphite, new BasicBulletType(6f, 18) {{
					height = 12f;
					width = 9f;
					hitColor = frontColor = UAWPal.graphiteFront;
					backColor = UAWPal.graphiteBack;
					hitEffect = Fx.hitBulletColor;
					reloadMultiplier = 0.6f;
					ammoMultiplier = 4;
					lifetime = 60f;
				}},
				Items.titanium, new TrailBulletType(10f, 10f) {{
					height = 12f;
					width = 5f;
					frontColor = UAWPal.titaniumFront;
					backColor = UAWPal.titaniumBack;
					pierceArmor = true;
					shootEffect = Fx.shootSmallColor;
					smokeEffect = Fx.shootBigSmoke;
					ammoMultiplier = 3;
					trailLengthScale = 0.6f;
				}},
				Items.pyratite, new BasicBulletType(5f, 15) {{
					height = 12f;
					width = 8f;
					frontColor = Pal.lightishOrange;
					backColor = Pal.lightOrange;
					status = StatusEffects.burning;
					hitEffect = new MultiEffect(Fx.hitBulletSmall, Fx.fireHit);
					ammoMultiplier = 5;
					splashDamage = 10f;
					splashDamageRadius = 22f;
					makeFire = true;
					lifetime = 60f;
				}},
				UAWItems.cryogel, new BasicBulletType(5f, 15) {{
					height = 12f;
					width = 8f;
					frontColor = UAWPal.cryoFront;
					hitColor = backColor = UAWPal.cryoBack;
					status = StatusEffects.freezing;
					hitEffect = new MultiEffect(Fx.hitBulletColor, UAWFx.cryoHit);
					ammoMultiplier = 5;
					splashDamage = 10f;
					splashDamageRadius = 22f;
					lifetime = 60f;
				}}
			);
			limitRange();

			squareSprite = false;
			drawer = new DrawTurret(modTurretBase) {{
				parts.addAll(
					new RegionPart("-barrel") {{
						progress = PartProgress.recoil;
						moveY = -5f * px;
						heatProgress = PartProgress.reload;

					}},
					new RegionPart("-body"),
					new RegionPart("-back") {{
						progress = PartProgress.reload;
						moveY = -6f * px;
					}}
				);
			}};
		}};
	}
}

