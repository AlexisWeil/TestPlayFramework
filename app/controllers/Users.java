package controllers;

import models.User;
import play.data.validation.*;
import play.db.jpa.JPA;
import play.mvc.Controller;
import utils.RequestUtil;
import utils.ValidationUtil;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alexis
 * Date: 17/04/12
 * Time: 21:52
 * To change this template use File | Settings | File Templates.
 */
public class Users extends Controller {

    public static void list() {
        List<User> users = User.findAll();

        System.out.println(request.headers.get("accept"));

        if(RequestUtil.acceptsXml(request))
            renderXml(users);
        else if(RequestUtil.acceptsJson(request))
            renderJSON(users);
        else
            render(users);
    }

    public static void testUser(String firstname, String lastname) {
        System.out.println("firstname : " + firstname + " - lastname : " + lastname);

        User user = new User();
        user.firstname = firstname;
        user.lastname = lastname;

        validation.valid(user);

        if(Validation.hasErrors()) {
            System.out.println("User not valid !");

            for(play.data.validation.Error error : Validation.errors()) {
                System.out.println(error.getKey());
            }
            renderJSON(ValidationUtil.wrappedErrors(Validation.errors()));
        }
        else {
            user.save();

            list();
        }
    }
    
    public static void addUser(@Valid User user) {
        validation.valid(user);

        User.findAll();

        if(validation.hasErrors()) {
            params.flash();
            validation.keep();
            list();
        }
        else {
            JPA.em().persist(user);
            list();
        }
    }
}
