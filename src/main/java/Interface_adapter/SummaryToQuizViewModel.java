package Interface_adapter;

/**
 * The View Model for the Login View.
 */
public class SummaryToQuizViewModel extends ViewModel<LoginState> {

    public LoginViewModel() {
        super("log in");
        setState(new LoginState());
    }
}

