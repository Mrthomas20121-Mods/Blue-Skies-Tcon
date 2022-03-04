package mrthomas20121.blue_skies_tcon.init;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.modifier.ModifierChemicalBonds;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import slimeknights.tconstruct.library.modifiers.Modifier;

public class Modifiers {

    public static DeferredRegister<Modifier> MODIFIERS = DeferredRegister.create(Modifier.class, BlueSkiesTcon.MOD_ID);

    public static RegistryObject<Modifier> chemical_bonds = MODIFIERS.register("chemical_bonds", ModifierChemicalBonds::new);
}
