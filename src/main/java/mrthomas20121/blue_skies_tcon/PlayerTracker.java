package mrthomas20121.blue_skies_tcon;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;

import java.util.*;

public class PlayerTracker {
    private static final int QUEUE_LIMIT = 6;
    private static final double SPEED_LIMIT = 100f;
    private static final HashMap<UUID, Deque<Vec3>> POSITION_MAP = new HashMap<>();

    public static double getSpeed(ServerPlayer serverPlayer) {
        UUID id = serverPlayer.getUUID();
        Deque<Vec3> queue = POSITION_MAP.get(id);

        if (queue == null || queue.size() != QUEUE_LIMIT) return 0;

        return Math.min(queue.peekLast().distanceTo(queue.peekFirst()) * (20D / (QUEUE_LIMIT - 1)), SPEED_LIMIT);
    }

    public static void updatePosition(ServerPlayer serverPlayer) {
        UUID id = serverPlayer.getUUID();
        Deque<Vec3> queue = POSITION_MAP.get(id);
        if (queue == null) {
            POSITION_MAP.put(id, new LinkedList<>(List.of(serverPlayer.position())));
        } else {
            queue.add(serverPlayer.position());
            if (queue.size() > QUEUE_LIMIT) queue.poll();
        }
    }
}