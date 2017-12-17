package uncle.turnstile;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TurnstileTest extends TurnstileFSM {
    private String registry;
    private TurnstileFSM fsm;

    @Before
    public void before() {
        registry = "";
        fsm = this;
        fsm.setState(OneCoinTurnstileState.LOCKED);
    }

    @Test
    public void testPay_thenPass() throws Exception {
        //when
        fsm.coinEvent();
        fsm.passEvent();
        //then
        assertEquals("UL", registry);
    }

    @Test
    public void testPayTwice_thenPass() throws Exception {
        //when
        fsm.coinEvent();
        fsm.coinEvent();
        fsm.passEvent();
        //then
        assertEquals("UTL", registry);
    }

    @Test
    public void testNoPay_noPass() throws Exception {
        //when
        fsm.passEvent();
        //then
        assertEquals("A", registry);
    }

    @Override public void unlockAction() {
        this.registry += "U";
    }
    @Override public void alarmAction() {
        this.registry += "A";
    }
    @Override public void thanksAction() {
        this.registry += "T";
    }
    @Override public void lockAction() {
        this.registry += "L";
    }
}