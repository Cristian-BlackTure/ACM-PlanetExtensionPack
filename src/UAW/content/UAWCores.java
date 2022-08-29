package UAW.content; 

import arc.*; 
import arc.graphics.*; 
import arc.graphics.g2d.*; 
import arc.struct.*; 
import mindustry.content.*; 
import mindustry.ctype.*; 
import mindustry.entities.bullet.*; 
import mindustry.gen.*; 
import mindustry.graphics.*; 
import mindustry.type.*; 
import mindustry.world.*; 
import mindustry.world.blocks.*; 
import mindustry.world.blocks.campaign.*; 
import mindustry.world.blocks.defense.*; 
import mindustry.world.blocks.defense.turrets.*; 
import mindustry.world.blocks.distribution.*; 
import mindustry.world.blocks.environment.*; 
import mindustry.world.blocks.experimental.*; 
import mindustry.world.blocks.legacy.*; 
import mindustry.world.blocks.liquid.*; 
import mindustry.world.blocks.logic.*; 
import mindustry.world.blocks.power.*; 
import mindustry.world.blocks.production.*; 
import mindustry.world.blocks.sandbox.*; 
import mindustry.world.blocks.storage.*; 
import mindustry.world.blocks.units.*; 
import mindustry.world.consumers.*; 
import mindustry.world.draw.*; 
import mindustry.world.meta.*; 
 // End 
import static mindustry.type.ItemStack.*; 
  
 public class ACMBlocks implements ContentList{ 
     public static Block 
  
     //cores
      coreintel
       
    @Override 
     public void load(){ 
         // region cores
 
            coreintel = new coreBlock("core-intel"){{ 
             requirements(Category.effect, with(Items.silicon, 4500)); 
             health = 35000; 
             itemCapacity = 35000;
             unitCapModifier = 14;
             size = 4; 
             alwaysUnlocked = true;
             research = {
                 root = true
                 name = tyra
                 }
         }};
 }
       
