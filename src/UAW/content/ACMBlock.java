package UAW.content;

import UAW.audiovisual.*;
import UAW.content.*;
import UAW.world.blocks.production.*;
import UAW.world.drawer.DrawBoilerSmoke;
import UAW.content.UAWLiquids.*;
import UAW.content.blocks.UAWEnv.*;
import arc.graphics.Color;
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
import mindustry.content.Items.*;
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
import mindustry.world.meta.Attribute.*;
import mindustry.world.blocks.production.AttributeCrafter.*;
import mindustry.world.blocks.environment.OreBlock.*;
import UAW.content.UAWItems.*;

import static UAW.Vars.tick;
import static mindustry.Vars.tilesize;
import static mindustry.type.ItemStack.with;

/** Contains Production structures, such as factories, drills, pumps, etc */
public class ACMBlock {
	public static Block placeholder,
	// production
	steamdrill, statdrill, magneticdrill, oreH2d2, h2d2drill, plastCompressor;
    
	public static void load(){

        steamdrill = new Drill("steamdrill"){{
            requirements(Category.production, with(Items.copper, 40, Items.lead, 40));

            drillTime = 320f;
            tier = 2;
            size = 2;
            researchCost = with(Items.copper, 20, Items.lead, 20);
            alwaysUnlocked = true;

        }};    

        statdrill = new Drill("statdrill"){{
            requirements(Category.production, with(Items.copper, 40, Items.silicon, 20, Items.graphite, 20));
            consumePower(0.15f);
            // i am here to consume you dreeaaam
            drillTime = 120f;
            tier = 3;
            size = 2;
            researchCost = with(Items.copper, 80, Items.graphite, 40, Items.silicon, 160);
            alwaysUnlocked = true;

        }};
        
        magneticdrill = new Drill("magneticdrill"){{
            requirements(Category.production, with(Items.titanium, 40, Items.silicon, 80, Items.graphite, 80));
            consumePower(0.15f);
            // i am here to consume you dreeaaam
            drillTime = 60f;
            tier = 4;
            size = 3;
            researchCost = with(Items.titanium, 80, Items.graphite, 40, Items.silicon, 160);
            alwaysUnlocked = true;

        }};

        oreH2d2 = new OreBlock(UAWItems.h2){{
            oreScale = 24.77f;
            oreThreshold = 0.913f;
            oreDefault = true;
        }};

		h2d2drill = new ThumperDrill("h2d2drill") {{
			requirements(Category.production, with(
				Items.copper, 55,
				Items.lead, 45,
				Items.graphite, 40,
				Items.silicon, 30
			));
                        alwaysUnlocked = true;
			size = 5;
			squareSprite = true;
			tileRequirement = Blocks.oreThorium;
			drilledItem = UAWItems.h2;
			tier = 7;
			itemCapacity = 25;
			drillTime = 550;
			warmupSpeed = 0.001f;
			hasLiquids = true;
			drawRim = true;
			liquidCapacity = 90f;
			drillEffect = new MultiEffect(
				Fx.mineBig,
				Fx.oily
			);
			updateEffect = UAWFx.steamCloud(4);
			consumeLiquid(UAWLiquids.steam, 0.5f);
		}};

        plastCompressor = new GenericCrafter("plastcompressor"){{
            requirements(Category.production, with(Items.silicon, 80, Items.lead, 115, Items.graphite, 60, Items.titanium, 80));
            alwaysUnlocked = true;
            hasItems = true;
            liquidCapacity = 60f;
            craftTime = 60f;
            outputItem = new ItemStack(Items.plastanium, 24);
            size = 2;
            health = 320;
            itemCapacity = 48;
            hasPower = hasLiquids = true;
            craftEffect = Fx.formsmoke;
            updateEffect = Fx.plasticburn;
            drawer = new DrawMulti(new DrawDefault(), new DrawFade());

            consumeLiquid(Liquids.oil, 0.05f);
            consumePower(2f);
            consumeItem(Items.titanium, 8);
        }};

        }
        }
