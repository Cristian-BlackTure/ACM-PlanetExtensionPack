package UAW.content.blocks; 
  
import UAW.audiovisual.*; 
import UAW.content.*; 
import UAW.world.blocks.production.*; 
import UAW.world.drawer.DrawBoilerSmoke; 
import arc.graphics.Color; 
import mindustry.content.*; 
import mindustry.entities.effect.MultiEffect; 
import mindustry.graphics.*; 
import mindustry.type.*; 
import mindustry.world.Block; 
import mindustry.world.blocks.production.*; 
import mindustry.world.draw.*; 
import mindustry.world.meta.Attribute; 
  
import static UAW.Vars.tick; 
import static mindustry.Vars.tilesize; 
import static mindustry.type.ItemStack.with;

/** Contains Production structures, such as factories, drills, pumps, etc */
public class UAWBlocksProduction {
	public static Block placeholder,
	// production - erekir
	uporedrill, maxdrill, recon6;

	public static void load() {

        uporedrill = new Drill("uporedrill"){{
            requirements(Category.production, with(Items.copper, 40));

            drillTime = 60f;
            tier = 2;
            size = 2;
            alwaysUnlocked = true;

        }};

        maxdrill = new BurstDrill("maxdrill"){{
            requirements(Category.production, with(Items.silicon, 200, UAWItems.mm, 20, Items.tungsten, 200, Items.thorium, 120));
            drillTime = 60f * 6f;
            size = 5;
            hasPower = true;
            tier = 7;
            //TODO better effect
            drillEffect = new MultiEffect(
                Fx.mineImpact,
                Fx.drillSteam,
                Fx.dynamicSpikes.wrap(Liquids.hydrogen.color, 30f),
                Fx.mineImpactWave.wrap(Liquids.hydrogen.color, 45f)
            );
            shake = 4f;
            itemCapacity = 50;
            arrowOffset = 2f;
            arrowSpacing = 5f;
            arrows = 2;
            glowColor.a = 0.6f;
            fogRadius = 5;


            //TODO different 
            consumePower(5f);
        }};
	}
}
