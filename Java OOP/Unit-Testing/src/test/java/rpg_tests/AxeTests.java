package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 1;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_EXPERIENCE = 10;
    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeTestObjects() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void weaponAttackLoosesDurability()  {
        axe.attack(dummy);
        Assert.assertEquals(AXE_DURABILITY - 1, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack()    {

        axe.attack(dummy);
        axe.attack(dummy);
    }

}
