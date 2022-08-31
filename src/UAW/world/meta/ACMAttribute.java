package UAW.world.meta;

import arc.struct.*;
import mindustry.*;
import UAW.content.blocks.UAWEnv.*;

public class ACMAttribute{
    public static ACMAttribute[] all = {};
    public static ObjectMap<String, ACMAttribute> map = new ObjectMap<>();

    /** Heat content. Used for thermal generator yield. */
    public static final Attribute
    heat = add("heat"),
    /** Virus Type Blocc */
    h2d2 = add("h2d2"),
    /** Water content. Used for water extractor yield. */
    water = add("water"),
    /** Oil content. Used for oil extractor yield. */
    oil = add("oil"),
    /** Light coverage. Negative values decrease solar panel efficiency. */
    light = add("light"),
    /** Used for sand extraction. */
    sand = add("sand"),
    /** Used for erekir vents only. */
    steam = add("steam");

    public final int id;
    public final String name;

    /** @return the environmental value for this attribute. */
    public float env(){
        if(Vars.state == null) return 0;
        return Vars.state.envAttrs.get(this);
    }

    Attribute(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

    /** Never returns null, may throw an exception if not found. */
    public static ACMAttribute get(String name){
        return map.getThrow(name, () -> new IllegalArgumentException("Unknown ACMAttribute type: " + name));
    }

    /** Automatically registers this attribute for use. Do not call after mod init. */
    public static Attribute add(String name){
        ACMAttribute a = new ACMAttribute(all.length, name);
        ACMAttribute[] prev = all;
        all = new ACMAttribute[all.length + 1];
        System.arraycopy(prev, 0, all, 0, a.id);
        all[a.id] = a;
        map.put(name, a);
        return a;
    }
}
