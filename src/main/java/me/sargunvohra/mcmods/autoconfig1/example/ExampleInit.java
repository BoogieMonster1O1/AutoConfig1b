package me.sargunvohra.mcmods.autoconfig1.example;

import me.sargunvohra.mcmods.autoconfig1.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1.ConfigHolder;
import me.sargunvohra.mcmods.autoconfig1.serializer.DummyConfigSerializer;
import me.sargunvohra.mcmods.autoconfig1.serializer.GsonConfigSerializer;
import me.sargunvohra.mcmods.autoconfig1.serializer.PartitioningSerializer;
import net.fabricmc.api.ModInitializer;

@SuppressWarnings("unused") // entrypoint
public class ExampleInit implements ModInitializer {
    @Override
    public void onInitialize() {
        // how to register a config:
        ConfigHolder<ExampleConfig> holder = AutoConfig.register(
            ExampleConfig.class,
            PartitioningSerializer.wrap(GsonConfigSerializer::new)
        );

        // how to read a config:
        holder.getConfig();
        // or
        AutoConfig.getConfigHolder(ExampleConfig.class).getConfig();

        // how to get the gui registry
        AutoConfig.getGuiRegistry(ExampleConfig.class);
    }
}
