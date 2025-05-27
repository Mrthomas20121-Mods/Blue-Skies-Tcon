package mrthomas20121.blue_skies_tcon;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

import java.util.HashMap;
import java.util.UUID;

public class MotionHelper {
    private static final HashMap<UUID, Long> LAST_UPDATE = new HashMap<>();
    private static final HashMap<UUID, Vec3> OLD_POS = new HashMap<>();
    private static final HashMap<UUID, Vec3> VELOCITIES = new HashMap<>();

    public static Vec3 getVelocity(Entity entity) {
        if (entity instanceof ServerPlayer serverPlayer) {
            update(serverPlayer);
            return VELOCITIES.get(serverPlayer.getUUID());
        } else {
            return entity.getDeltaMovement();
        }
    }

    public static void update(ServerPlayer serverPlayer) {
        UUID id = serverPlayer.getUUID();
        Vec3 oldPos = OLD_POS.get(id);
        Long oldTime = LAST_UPDATE.get(id);
        Vec3 newPos = serverPlayer.position();
        Long newTime = serverPlayer.serverLevel().getGameTime();
        Vec3 oldVel = VELOCITIES.get(id);
        Vec3 newVel;

        if (oldVel == null) {
            oldVel = new Vec3(0, 0, 0);
        }
        if (oldTime == null) {
            oldTime = newTime;
        }
        if (oldPos != null && (oldTime.longValue() != newTime.longValue())) {
            newVel = newPos.subtract(oldPos).scale(1 / (newTime - oldTime));
        } else {
            newVel = oldVel;
        }
        OLD_POS.put(id, newPos);
        LAST_UPDATE.put(id, newTime);
        VELOCITIES.put(id, newVel);
    }
}