package UAW.content;

import arc.struct.*;
import mindustry.game.Objectives.*;
import arc.struct.Seq;
import mindustry.content.*;
import mindustry.content.TechTree.TechNode;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Objectives.*;
import mindustry.type.ItemStack;

import static mindustry.content.Blocks.*;
import static mindustry.content.SectorPresets.*;
import static mindustry.content.SectorPresets.craters;
import static mindustry.content.TechTree.*;
import static mindustry.content.UnitTypes.*;
import static UAW.content.UAWCores.*;
import static UAW.content.ACMBlock.*;
import static UAW.content.UAWPlanets.*;
import static mindustry.content.Items.*;
import static mindustry.content.TechTree.nodeRoot;

public class TyraTechTree{

    public static void load(){
        UAWPlanets.tyra.techTree = nodeRoot("tyra", UAWCores.coreIntel, () -> {

            node(UAWCores.coreIntel, () -> {

                node(ACMBlock.steamdrill, () -> {
                    node(router, () -> {
                        node(launchPad, Seq.with(new SectorComplete(extractionOutpost)), () -> {
                          
                          });
                          });
                          });
                          });
                          });
                          }
                          }
                        
