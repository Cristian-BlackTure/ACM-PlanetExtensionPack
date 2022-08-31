package UAW.content;

import arc.struct.*;
import mindustry.game.Objectives.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.SectorPresets.*;
import static mindustry.content.SectorPresets.craters;
import static mindustry.content.TechTree.*;
import static mindustry.content.UnitTypes.*;
import static UAW.content.UAWCores.*;
import static UAW.content.ACMBlock.*;
import static UAW.content.UAWPlanets.*;

public class TyraTechTree{

	private static void ACMNode(UnlockableContent parent, Runnable children) {
		context = TechTree.all.find(t -> t.content == parent);
		children.run();
	}

    public static void load(){
        UAWPlanets.tyra.techTree = nodeRoot("tyra", UAWCores.coreIntel, () -> {

            ACMnode(coreIntel, () -> {
                node(steamdrill, () -> {
                    node(statdrill, () -> {
                        node(magneticdrill, () -> {
                          
                          });
                          });
                          });
                          });
                          });
                          }
                          }
                        
