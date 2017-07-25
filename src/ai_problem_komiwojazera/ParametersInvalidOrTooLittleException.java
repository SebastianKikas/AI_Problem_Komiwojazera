package ai_problem_komiwojazera;

/**
 * This class create own exception. There is only constuctor
 *
 * @author Sebastian Kikas
 * @version 2.0
 */
public class ParametersInvalidOrTooLittleException extends Exception {

    public ParametersInvalidOrTooLittleException() {
    }

    public ParametersInvalidOrTooLittleException(String message) {
        super(message);
    }

}
