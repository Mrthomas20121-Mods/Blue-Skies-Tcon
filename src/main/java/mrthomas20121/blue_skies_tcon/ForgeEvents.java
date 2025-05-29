package mrthomas20121.blue_skies_tcon;

import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BlueSkiesTcon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {
    // https://discord.com/channels/313125603924639766/1301510569269919784/1329865914463817880
    @SubscribeEvent
    public static void player(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.START || event.side != LogicalSide.SERVER) return;
        if (event.player instanceof ServerPlayer sp) PlayerTracker.updatePosition(sp);
    }
}
