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
	plasmic;

	public static void load() {

		//region Serpulo
        
         plasmic = new LaserTurret("plasmic"){{
           requirements(Category.turret, with(silicon, 200));
            recoilAmount = 3.7f;
            shootType = LaserBulletType;
            update = true;
            range = 425;
            chargeTime = 190;
            chargeMaxDelay = 0;
            reloadTime = 500;
            size = 3;
            health = 3500;
            coolantMultiplier = 1.4f;
            shootCone = 5;
            shootDuration = 650;
            powerUse = 15;
            shootShake = 3;
            firingMoveFract = 0.16f;
            targetAir = true;
            shootEffect = Fx.hitLancer;
            hasPower = true;
            hasLiquids = true;
            shootSound = Sounds.laserbig;
            liquidCapacity = 60;
            heatColor = Color.red;
            rotateSpeed = 0.3f;
            expanded = true;
        }};
	}
}

