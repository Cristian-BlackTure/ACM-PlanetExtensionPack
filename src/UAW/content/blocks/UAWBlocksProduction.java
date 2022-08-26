package UAW.content.blocks;

import UAW.audiovisual.*;
import UAW.content.*;
import UAW.world.blocks.production.*;
import UAW.world.drawer.DrawBoilerSmoke;
import arc.graphics.Color;
import mindustry.content.*;
import mindustry.entities.effect.MultiEffect;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.Block;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.*;
import mindustry.world.meta.Attribute;

import static UAW.Vars.tick;
import static mindustry.Vars.tilesize;
import static mindustry.type.ItemStack.with;

/** Contains Production structures, such as factories, drills, pumps, etc */
public class UAWBlocksProduction {
	public static Block placeholder,
	// production
	uporedrill;

	public static void load() {

        uporedrill = new BeamDrill("uporedrill"){{
            requirements(Category.production, with(Items.beryllium, 40));
            consumePower(0.15f);

            drillTime = 160f;
            tier = 5;
            size = 2;
            range = 5;
            fogRadius = 3;
            researchCost = with(Items.beryllium, 10);

        }};

	}
}
