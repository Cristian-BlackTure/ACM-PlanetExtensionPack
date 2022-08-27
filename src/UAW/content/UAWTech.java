package UAW.content;

import arc.struct.Seq;
import mindustry.content.TechTree;
import mindustry.content.TechTree.TechNode;
import mindustry.ctype.ContentList;
import mindustry.ctype.UnlockableContent;
import mindustry.type.ItemStack;
import mindustry.content.*;
import mindustry.game.Objectives.*;

import static mindustry.content.Blocks.*;
import static mindustry.type.ItemStack.with;

import static UAW.content.blocks.UAWBlocksDefense.*;

public static class UAWTechTree{
    private static TechNode context = null;

    public static void load(){
        
               attachNode(lancer, () -> {
        	node(plasmic);
    });
    }
