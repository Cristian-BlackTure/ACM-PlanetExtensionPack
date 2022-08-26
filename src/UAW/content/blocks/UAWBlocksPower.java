package UAW.content.blocks;

import UAW.content.UAWLiquids;
import UAW.content.UAWItems;
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
import static mindustry.type.ItemStack.with;
import static mindustry.Vars.*;

/** Contains Power Blocks or Blocks that produces Power */
public class UAWBlocksPower {
	public static Block placeholder,

	// Power
	MGenerator, plasmareactor;

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

        plasmareactor = new HeaterGenerator("plasmareactor"){{
            requirements(Category.power, with(Items.silicon, 500));

            size = 3;
            liquidCapacity = 80f;
            outputLiquid = new LiquidStack(UAWLiquids.plasma, 20f / 60f);
            explodeOnFull = true;

            heatOutput = 60f;

            consumeLiquid(Liquids.slag, 10f / 60f);
            consumeLiquid(Liquids.water, 10f / 60f);
            consumeItem(UAWItems.mm); 

            itemDuration = 60f * 3f;
            itemCapacity = 10;

            explosionRadius = 10;
            explosionDamage = 5000;
            explodeEffect = new MultiEffect(Fx.bigShockwave, new WrapEffect(Fx.titanSmoke, Liquids.neoplasm.color), Fx.neoplasmSplat);

            powerProduction = 260f;
            rebuildable = false;

            explosionPuddles = 80;
            explosionPuddleRange = tilesize * 7f;
            explosionPuddleLiquid = UAWLiquids.plasma;
            explosionPuddleAmount = 200f;
            explosionMinWarmup = 0.5f;

            consumeEffect = new RadialEffect(Fx.neoplasiaSmoke, 4, 90f, 54f / 4f);

            drawer = new DrawMulti(
            new DrawRegion("-bottom"),
            new DrawLiquidTile(Liquids.slag, 3f),
            new DrawCircles(){{
                color = Color.valueOf("feb380").a(0.8f);
                strokeMax = 3.25f;
                radius = 65f / 4f;
                amount = 5;
                timeScl = 200f;
            }},

            new DrawRegion("-center"),

            new DrawCells(){{
                color = Color.valueOf("c33e2b");
                particleColorFrom = Color.valueOf("e8803f");
                particleColorTo = Color.valueOf("8c1225");
                particles = 50;
                range = 4f;
            }},
            new DrawDefault(),
            new DrawHeatOutput(),
            new DrawGlowRegion("-glow"){{
                color = Color.valueOf("70170b");
                alpha = 0.7f;
            }}
            );
        }};


	}
}
