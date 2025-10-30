package net.minecraft.launcher.game;

import com.google.common.collect.Maps;
import com.mojang.launcher.versions.ReleaseType;
import java.util.Map;

public enum MinecraftReleaseType implements ReleaseType {
    SNAPSHOT("snapshot", "Enable experimental development versions (\"snapshots\")"),
    RELEASE("release", (String)null),
    CUSTOM("custom", "Enable versions with custom release types"), /* olauncher - add default release type */
    OLD_BETA("old_beta", "Allow use of old \"Beta\" Minecraft versions (From 2010-2011)"),
    OLD_ALPHA("old_alpha", "Allow use of old \"Alpha\" Minecraft versions (From 2010)");

    private static final String POPUP_DEV_VERSIONS = "Are you sure you want to enable development builds?\nThey are not guaranteed to be stable and may corrupt your world.\nYou are advised to run this in a separate directory or run regular backups.";
    private static final String POPUP_OLD_VERSIONS = "These versions are very out of date and may be unstable. Any bugs, crashes, missing features or\nother nasties you may find will never be fixed in these versions.\nIt is strongly recommended you play these in separate directories to avoid corruption.\nWe are not responsible for the damage to your nostalgia or your save files!";
    private static final Map<String, MinecraftReleaseType> LOOKUP = Maps.newHashMap();
    private final String name;
    private final String description;

    private MinecraftReleaseType(String var3, String var4) {
        this.name = var3;
        this.description = var4;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getPopupWarning() {
        if (this.description == null) {
            return null;
        } else if (this == SNAPSHOT) {
            return "Are you sure you want to enable development builds?\nThey are not guaranteed to be stable and may corrupt your world.\nYou are advised to run this in a separate directory or run regular backups.";
        } else if (this == OLD_BETA) {
            return "These versions are very out of date and may be unstable. Any bugs, crashes, missing features or\nother nasties you may find will never be fixed in these versions.\nIt is strongly recommended you play these in separate directories to avoid corruption.\nWe are not responsible for the damage to your nostalgia or your save files!";
        } else {
            return this == OLD_ALPHA ? "These versions are very out of date and may be unstable. Any bugs, crashes, missing features or\nother nasties you may find will never be fixed in these versions.\nIt is strongly recommended you play these in separate directories to avoid corruption.\nWe are not responsible for the damage to your nostalgia or your save files!" : null;
        }
    }

    public static MinecraftReleaseType getByName(String var0) {
        return (MinecraftReleaseType)LOOKUP.getOrDefault(var0, CUSTOM); /* olauncher - add default release type */
    }

    static {
        MinecraftReleaseType[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            MinecraftReleaseType var3 = var0[var2];
            LOOKUP.put(var3.getName(), var3);
        }

    }
}
