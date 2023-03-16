package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Dummy;

public class DummyTests {

    private static final int DUMMY_HEALTH = 1;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int ATTACK_POINTS = 1;
    private Dummy dummy;

    @Before
    public void initializeTestObjects() {
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void dummyLosesHealth()  {

        dummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals(DUMMY_HEALTH - 1, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsException()  {

        dummy.takeAttack(ATTACK_POINTS);
        dummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void deadDummyCanGiveXP()    {

        dummy.takeAttack(ATTACK_POINTS);
        int givenXP = dummy.giveExperience();
        Assert.assertEquals(DUMMY_EXPERIENCE, givenXP);
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP() {

        int givenXP = dummy.giveExperience();
    }

}
