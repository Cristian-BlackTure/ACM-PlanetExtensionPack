package UAW.content;

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
public class ACMProductionBlocks {
	public static Block placeholder,
	// production
	steamdrill, statdrill, magneticdrill;
    
	public static void load();

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
        }
        
        
