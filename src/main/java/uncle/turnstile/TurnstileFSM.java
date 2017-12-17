package uncle.turnstile;

public abstract class TurnstileFSM {
    private TurnstileState state;

    public abstract void unlockAction();
    public abstract void alarmAction();
    public abstract void thanksAction();
    public abstract void lockAction();

    public void passEvent() { state.passEvent(this); }

    public void coinEvent() { state.coinEvent(this); }

    public void setState(TurnstileState state) {
        this.state = state;
    }
}
