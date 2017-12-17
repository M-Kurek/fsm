package uncle.turnstile;

public enum OneCoinTurnstileState implements TurnstileState {
    LOCKED {
        @Override
        public void coinEvent(TurnstileFSM fsm) {
            fsm.setState(UNLOCKED);
            fsm.unlockAction();
        }
        @Override
        public void passEvent(TurnstileFSM fsm) {
            fsm.alarmAction();
        }
    },
    UNLOCKED {
        @Override
        public void coinEvent(TurnstileFSM fsm) {
            fsm.thanksAction();
        }

        @Override
        public void passEvent(TurnstileFSM fsm) {
            fsm.setState(LOCKED);
            fsm.lockAction();
        }
    };
}
