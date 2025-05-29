package mrthomas20121.blue_skies_tcon.init;

import mrthomas20121.blue_skies_tcon.PlayerTracker;
import net.minecraft.server.level.ServerPlayer;
import slimeknights.tconstruct.library.json.variable.entity.EntityVariable;

public class BlueVariables {

    public static final EntityVariable ENTITY_SPEED = EntityVariable.simple(le -> {
        // TODO: just doesn't work serverside
        // https://discord.com/channels/313125603924639766/1301510569269919784/1329865639296237670
        if (le instanceof ServerPlayer sp) {
            return (float) PlayerTracker.getSpeed(sp);
        }
        return 0;
    });

}
