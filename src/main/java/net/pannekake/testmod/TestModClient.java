package net.pannekake.testmod;

import net.fabricmc.api.ClientModInitializer;
import net.pannekake.testmod.util.ModModelPredicates;

public class TestModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ModModelPredicates.registerModelPredicates();

    }
}
