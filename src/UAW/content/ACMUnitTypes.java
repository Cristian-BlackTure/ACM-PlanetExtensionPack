package UAW.content;

import UAW.ai.types.DynamicFlyingAI;
import UAW.audiovisual.*;
import UAW.entities.abilities.RazorRotorAbility;
import UAW.entities.bullet.*;
import UAW.entities.bullet.ModdedVanillaBullet.*;
import UAW.entities.units.UAWUnitType;
import UAW.entities.units.entity.*;
import UAW.type.Rotor;
import UAW.type.weapon.*;
import arc.func.Prov;
import arc.graphics.Color;
import arc.math.Mathf;
import arc.struct.ObjectIntMap;
import arc.struct.ObjectMap.Entry;
import com.sun.istack.NotNull;
import mindustry.ai.types.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.type.weapons.PointDefenseWeapon;
import mindustry.world.blocks.payloads.PayloadSource;
import mindustry.world.meta.BlockFlag;

import static UAW.Vars.*;
import static UAW.content.UAWBullets.fragGlassFrag;
import static mindustry.Vars.tilesize;

@SuppressWarnings("unchecked")
public class UAWUnitTypes {
	public static UnitType placeholder,

	// Everyone
    kivi;
    


	// Steal from Progressed Material which stole from Endless Rusting which stole from Progressed Materials in the past which stole from BetaMindy
	private static final Entry<Class<? extends Entityc>, Prov<? extends Entityc>>[] types = new Entry[]{
		prov(CopterUnitEntity.class, CopterUnitEntity::new),
		prov(TankUnitEntity.class, TankUnitEntity::new),
		prov(JetUnitEntity.class, JetUnitEntity::new)
	};

	private static final ObjectIntMap<Class<? extends Entityc>> idMap = new ObjectIntMap<>();

	/**
	 * Internal function to flatmap {@code Class -> Prov} into an {@link Entry}.
	 *
	 * @author GlennFolker
	 */
	private static <T extends Entityc> Entry<Class<T>, Prov<T>> prov(Class<T> type, Prov<T> prov) {
		Entry<Class<T>, Prov<T>> entry = new Entry<>();
		entry.key = type;
		entry.value = prov;
		return entry;
	}

	/**
	 * Setups all entity IDs and maps them into {@link EntityMapping}.
	 * <p>
	 * Put this inside load()
	 * </p>
	 *
	 * @author GlennFolker
	 */
	private static void setupID() {
		for (
			int i = 0,
			j = 0,
			len = EntityMapping.idMap.length;
			i < len;
			i++
		) {
			if (EntityMapping.idMap[i] == null) {
				idMap.put(types[j].key, i);
				EntityMapping.idMap[i] = types[j].value;
				if (++j >= types.length) break;
			}
		}
	}

	private static void setupPayloadSource() {
		registerPayloadSource(UAWUnitType.class);
	}

	/**
	 * Retrieves the class ID for a certain entity type.
	 *
	 * @author GlennFolker
	 */
	public static <T extends Entityc> int classID(Class<T> type) {
		return idMap.get(type, -1);
	}

	public static <T extends UnitType> void registerPayloadSource(@NotNull Class<T> clz) {
		var source = (PayloadSource) Blocks.payloadSource;
		source.config((Class<UnitType>) clz,
			(PayloadSource.PayloadSourceBuild build, UnitType type) -> {
				if (source.canProduce(type) && build.unit != type) {
					build.unit = type;
					build.block = null;
					build.payload = null;
					build.scl = 0f;
				}
			});
	}

	public static void load() {
		setupID();
		setupPayloadSource();
        
        	kivi = new UAWUnitType("kivi") {{
			float unitRange = 43 * tilesize;
			health = 7500;
			armor = 10f;
			hitSize = 45;
            alwaysUnlocked = true;

			speed = 5f;
			accel = 0.03f;
			drag = 0.07f;
			rotateSpeed = 2.7f;

			lowAltitude = true;
			faceTarget = flying = true;
			range = unitRange;

			engineSize = 0;

			targetFlags = new BlockFlag[]{BlockFlag.turret, BlockFlag.extinguisher, BlockFlag.battery, null};

			constructor = CopterUnitEntity::new;
			aiController = FlyingAI::new;

			float rotX = 17;
			float rotY = 5;
			float rotSpeed = 32f;
			rotors.add(
				new Rotor(modName + "short-blade") {{
					x = -rotX;
					y = rotY;
					rotorSpeed = rotSpeed;
					rotorBlurSpeedMultiplier = 0.1f;
					bladeCount = 3;
					doubleRotor = true;
				}},
				new Rotor(modName + "short-blade") {{
					x = rotX;
					y = rotY;
					rotorSpeed = rotSpeed;
					rotorBlurSpeedMultiplier = 0.1f;
					bladeCount = 3;
					doubleRotor = true;
				}}
			);

			weapons.add(new Weapon(machineGun_small_red) {{
				layerOffset = -0.01f;
				rotate = false;
				mirror = true;
				shootCone = 90;
				inaccuracy = 12f;
				x = 4.75f;
				y = 20.75f;
				reload = 2.5f;
				shootSound = Sfx.gunShoot3;
				ejectEffect = Fx.casing1;
				bullet = new BasicBulletType(7f, 20) {{
					height = 12f;
					width = 6f;
					pierce = true;
					pierceCap = 2;
					buildingDamageMultiplier = 0.4f;
					maxRange = range;
					homingRange = 60f;
					lifetime = (unitRange / speed);
					ammoMultiplier = 8f;
				}};
			}});
			weapons.add(new Weapon(machineGun_medium_red) {{
				layerOffset = -0.01f;
				rotate = false;
				inaccuracy = 4f;
				mirror = true;
				shootCone = 30f;
				x = 10.5f;
				y = 12.5f;
				reload = 8;
				shootSound = Sounds.shootBig;
				ejectEffect = Fx.casing2;
				bullet = new TrailBulletType(5f, 45) {{
					trailLengthScale = 0.8f;
					height = 16f;
					width = 8f;
					splashDamage = damage;
					splashDamageRadius = 16;
					frontColor = Pal.missileYellow;
					backColor = Pal.missileYellowBack;
					buildingDamageMultiplier = 0.3f;
					lifetime = (unitRange * 0.75f) / speed;
					status = StatusEffects.burning;
					ammoMultiplier = 8f;
					hitEffect = new MultiEffect(Fx.blastExplosion, Fx.fireHit, Fx.blastsmoke);
					shootEffect = Fx.shootBigColor;
					smokeEffect = Fx.shootBigSmoke;
					fragBullets = 3;
					fragBullet = fragGlassFrag;


				}};
			}});
			weapons.add(new MissileLauncherWeapon(cruiseMissileMount_1) {{
				rotate = true;
				rotationLimit = 20;
				rotateSpeed = 0.8f;
				missileName = cruiseMissile_Cryo;
				mirror = true;
				layerOffset = 0.1f;
				x = 10.25f;
				y = -3.5f;
				reload = 5 * tick;
				shootSound = Sfx.missileShootBig1;
				bullet = new CruiseMissileBulletType(3f, 700) {{
					sprite = cruiseMissile_Cryo;
					homingRange = unitRange / 3;
					homingPower = 0.05f;
					keepVelocity = false;
					splashDamageRadius = 12 * tilesize;
					lifetime = (unitRange / speed) * 0.8f;
					shootEffect = UAWFx.shootHugeColor;
					trailColor = UAWPal.cryoFront;
					hitEffect = UAWFx.dynamicExplosion(splashDamageRadius, UAWPal.cryoMiddle, UAWPal.cryoBack);
					trailColor = UAWPal.cryoMiddle;
					trailLifetime = 28f;
					status = StatusEffects.freezing;
					statusDuration = 4 * 60;
				}};
			}});
		}};
        }