package mrthomas20121.blue_skies_tcon.init;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import slimeknights.tconstruct.library.json.variable.entity.EntityVariable;

public class BlueVariables {

    public static final EntityVariable ENTITY_SPEED = EntityVariable.simple(le -> {
        // TODO: just doesn't work serverside
        // https://discord.com/channels/313125603924639766/1301510569269919784/1329865639296237670
        Entity e = le.getRootVehicle();
        return (float) (new Vec3(e.getX() - e.xOld, e.position().y - e.yOld, e.position().z - e.zOld)).length();
    });

}
