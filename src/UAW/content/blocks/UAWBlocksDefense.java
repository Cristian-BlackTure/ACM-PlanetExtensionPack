package UAW.content.blocks;

import UAW.audiovisual.*;
import UAW.content.*;
import UAW.entities.UAWUnitSorts;
import UAW.entities.bullet.BuckshotBulletType;
import UAW.entities.bullet.ModdedVanillaBullet.TrailBulletType;
import UAW.world.blocks.defense.turrets.UAWItemTurret;
import UAW.world.blocks.defense.walls.ShieldWall;
import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

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

