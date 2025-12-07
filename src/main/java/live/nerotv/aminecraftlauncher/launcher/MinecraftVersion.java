package live.nerotv.aminecraftlauncher.launcher;

import com.zyneonstudios.nexus.utilities.NexusUtilities;

public class MinecraftVersion {

    public Type getType(String version) {
        if(version.contains(".")) {
            try {
                int i = Integer.parseInt(version.split("\\.")[1]);
                if (i < 17) {
                    return Type.LEGACY;
                } else if (i < 21) {
                    return Type.SEMI_NEW;
                } else {
                    return Type.NEW;
                }
            } catch (Exception e) {
                NexusUtilities.getLogger().err("[SYSTEM] Couldn't resolve Minecraft version "+version+": "+e.getMessage());
            }
        }
        return Type.NEW;
    }

    public ForgeType getForgeType(String mcVersion) {
        if(mcVersion.contains(".")) {
            try {
                int i = Integer.parseInt(mcVersion.split("\\.")[1]);
                if (i < 12) {
                    return ForgeType.OLD;
                } else {
                    return ForgeType.NEW;
                }
            } catch (Exception e) {
                NexusUtilities.getLogger().err("[SYSTEM] Couldn't resolve Minecraft version "+mcVersion+": "+e.getMessage());
            }
        }
        return null;
    }

    public enum Type {
        LEGACY,
        SEMI_NEW,
        NEW
    }

    public enum ForgeType {
        OLD,
        NEW
    }
}
