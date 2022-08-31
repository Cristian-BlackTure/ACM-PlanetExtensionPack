package UAW.content;

import UAW.audiovisual.*;
import UAW.content.*;
import UAW.world.blocks.production.*;
import UAW.world.drawer.DrawBoilerSmoke;
import UAW.content.UAWLiquids.*;
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

import static UAW.Vars.tick;
import static mindustry.Vars.tilesize;
import static mindustry.type.ItemStack.with;

/** Contains Production structures, such as factories, drills, pumps, etc */
public class ACMBlock{
	public static Block placeholder,
	// production
	steamdrill, statdrill, magneticdrill;
    
    // crafting
    steamgenerator;
    
	public static void load(){

        steamdrill = new Drill("steamdrill"){{
            requirements(Category.production, with(Items.copper, 40, Items.lead, 40));

            drillTime = 160f;
            tier = 2;
            size = 2;
            researchCost = with(Items.copper, 20, Items.lead, 20);

        }};    

        statdrill = new Drill("statdrill"){{
            requirements(Category.production, with(Items.copper, 40, Items.silicon, 20, Items.graphite, 20));
            consumePower(0.15f);
            // i am here to consume you dreeaaam
            drillTime = 160f;
            tier = 3;
            size = 2;
            researchCost = with(Items.copper, 80, Items.graphite, 40, Items.silicon, 160);

        }};
        
        magneticdrill = new Drill("magneticdrill"){{
            requirements(Category.production, with(Items.titanium, 40, Items.silicon, 80, Items.graphite, 80));
            consumePower(0.15f);
            // i am here to consume you dreeaaam
            drillTime = 60f;
            tier = 4;
            size = 3;
            researchCost = with(Items.titanium, 80, Items.graphite, 40, Items.silicon, 160);

        }};
        
        steamgenerator = new GenericCrafter("steam-generator"){{
            requirements(Category.crafting, with(Items.copper, 65, Items.silicon, 40, Items.lead, 30));
            outputLiquid = new LiquidStack(UAWLiquids.steam, 12f / 60f);
            size = 2;
            hasPower = true;
            hasItems = false;
            hasLiquids = true;
            rotate = false;
            solid = true;
            outputsLiquid = true;
            envEnabled = Env.any;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.water), new DrawLiquidTile(UAWLiquids.steam){{drawLiquidLight = true;}}, new DrawDefault());
            liquidCapacity = 24f;
            craftTime = 120;

            consumePower(2.05f);
            consumeLiquid(Liquids.water, 12f / 60f);
        }};
        
        }
        }
        
        
        