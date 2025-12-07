package live.nerotv.aminecraftlauncher.launcher;

import fr.flowarg.openlauncherlib.NoFramework;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class MinecraftLauncher {

    private LauncherHook preLaunchHook;
    private LauncherHook postLaunchHook;
    private LauncherHook gameCloseHook;
    private ArrayList<String> additionalJVMArgs = new ArrayList<>();
    private ArrayList<String> additionalEnvironmentalArgs = new ArrayList<>();

    public void setGameCloseHook(LauncherHook gameCloseHook) {
        this.gameCloseHook = gameCloseHook;
    }

    public void setPostLaunchHook(LauncherHook postLaunchHook) {
        this.postLaunchHook = postLaunchHook;
    }

    public void setPreLaunchHook(LauncherHook preLaunchHook) {
        this.preLaunchHook = preLaunchHook;
    }

    public LauncherHook getGameCloseHook() {
        return gameCloseHook;
    }

    public LauncherHook getPostLaunchHook() {
        return postLaunchHook;
    }

    public LauncherHook getPreLaunchHook() {
        return preLaunchHook;
    }

    public ArrayList<String> getAdditionalJVMArgs() {
        return additionalJVMArgs;
    }

    public ArrayList<String> getAdditionalEnvironmentalArgs() {
        return additionalEnvironmentalArgs;
    }

    public void addAdditionalJVMArgs(String... arguments) {
        additionalJVMArgs.addAll(Arrays.asList(arguments));
    }

    public void addAdditionalEnvironmentalArgs(String... arguments) {
        additionalEnvironmentalArgs.addAll(Arrays.asList(arguments));
    }

    public void removeAdditionalJVMArgs(String... arguments) {
        for(String argument : arguments) {
            additionalJVMArgs.remove(argument);
        }
    }

    public void removeAdditionalEnvironmentalArgs(String... arguments) {
        for(String argument : arguments) {
            additionalEnvironmentalArgs.remove(argument);
        }
    }

    public void setAdditionalJVMArgs(ArrayList<String> additionalJVMArgs) {
        this.additionalJVMArgs = additionalJVMArgs;
    }

    public void setAdditionalEnvironmentalArgs(ArrayList<String> additionalEnvironmentalArgs) {
        this.additionalEnvironmentalArgs = additionalEnvironmentalArgs;
    }

    public abstract Process getGameProcess();
    public abstract NoFramework getFramework();
    public abstract boolean isLaunched();
}
