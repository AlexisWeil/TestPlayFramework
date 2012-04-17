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
public class ValidationUtil {

    public static List<Error> wrappedErrors(List<play.data.validation.Error> errors) {
        List<Error> wrappedErrors = new ArrayList<Error>();

        for (play.data.validation.Error error : errors) {
            wrappedErrors.add(new Error(error.getKey(), error.message()));
        }

        return wrappedErrors;
    }

    public static class Error implements Serializable {
        public Error(String id, String message) {
            this.id = id;
            this.message = message;
        }

        private String id;
        private String message;
    }
}
