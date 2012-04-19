package utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alexis
 * Date: 18/04/12
 * Time: 00:27
 * To change this template use File | Settings | File Templates.
 */
public class ValidationErrorsWrapper {

    public String id = "ValidationErrors";
    public List<Error> errors;

    public static ValidationErrorsWrapper getFromErrors(List<play.data.validation.Error> errors) {
        List<Error> wrappedErrors = new ArrayList<Error>();

        for (play.data.validation.Error error : errors) {
            wrappedErrors.add(new Error(error.getKey(), error.message()));
        }

        ValidationErrorsWrapper wrapper = new ValidationErrorsWrapper();
        wrapper.errors = wrappedErrors;

        return wrapper;
    }

    public static class Error implements Serializable {
        public Error(String id, String message) {
            this.id = id;
            this.message = message;
        }

        public String id;
        public String message;
    }
}
