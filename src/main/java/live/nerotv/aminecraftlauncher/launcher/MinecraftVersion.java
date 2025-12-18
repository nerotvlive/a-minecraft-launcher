package live.nerotv.aminecraftlauncher.launcher;

import com.zyneonstudios.nexus.utilities.NexusUtilities;

public class MinecraftVersion {

    public static Type getType(String version) {
        if(version.contains(".")) {
            try {
                if(version.startsWith("1.")) {
                    version = version.substring(2);
                }
                int i = Integer.parseInt(version.split("\\.")[0]);
                if (i < 17) {
                    return Type.VERY_OLD;
                } else if (i < 21) {
                    return Type.OLD;
                } else if (i < 26) {
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

    public static ForgeType getForgeType(String mcVersion) {
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
        VERY_OLD,
        OLD,
        SEMI_NEW,
        NEW,
    }

    public enum ForgeType {
        OLD,
        NEW
    }
}
