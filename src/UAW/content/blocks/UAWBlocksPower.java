package UAW.content.blocks;

import UAW.content.UAWLiquids;
import UAW.world.blocks.power.steam.LiquidBoiler;
import UAW.world.drawer.DrawBoilerSmoke;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.Block;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.Attribute;

import static UAW.Vars.*;
import static mindustry.type.ItemStack.with;

/** Contains Power Blocks or Blocks that produces Power */
public class UAWBlocksPower {
	public static Block placeholder,

	// Turbines
	MGenerator;

	public static void load() {

        MGenerator = new ConsumeGenerator("m-generator"){{
            requirements(Category.power, with(Items.copper, 35, Items.graphite, 25, Items.lead, 40, Items.silicon, 30));
            powerProduction = 10.5f;
            itemDuration = 90f;
            consumeLiquid(Liquids.water, 0.4f);
            hasLiquids = true;
            size = 2;
            generateEffect = Fx.generatespark;

            consume(new ConsumeItemFlammable());
            consume(new ConsumeItemExplode());

            drawer = new DrawMulti(
            new DrawDefault(),
            new DrawWarmupRegion(),
            new DrawRegion("-turbine"){{
                rotateSpeed = 2f;
            }},
            new DrawRegion("-turbine"){{
                rotateSpeed = -2f;
                rotation = 45f;
            }},
            new DrawRegion("-cap"),
            new DrawLiquidRegion()
            );
        }};


	}
}
