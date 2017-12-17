package uncle.turnstile;

public interface TurnstileState {
    void coinEvent(TurnstileFSM fsm);
    void passEvent(TurnstileFSM fsm);
}
