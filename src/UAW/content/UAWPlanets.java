package UAW.content; 
  
import arc.graphics.*; 
import mindustry.ctype.*; 
import mindustry.content.*; 
import mindustry.graphics.g3d.*; 
import mindustry.maps.planet.*; 
import mindustry.type.*; 
import UAW.planets.*; 
  
public class UAWPlanets implements ContentList { 
         public static Planet planetbl; 
  
         @Override 
         public void load() { 
                 planetbl = new Planet("planetbl", Planets.sun, 3, 1) {{ 
                         generator = new ErekirPlanetGenerator(); 
                         meshLoader = () -> new HexMesh(this, 6); 
                         atmosphereColor = Color.valueOf("3c1b8f"); 
                         atmosphereRadIn = 0.02f; 
                         atmosphereRadOut = 0.3f; 
                         startSector = 15; 
                         alwaysUnlocked = true; 
                 }}; 
         } 
 }
