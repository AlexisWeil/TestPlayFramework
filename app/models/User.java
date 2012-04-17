package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: Alexis
 * Date: 17/04/12
 * Time: 21:48
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class User extends Model {
    @Required(message = "Firstname is required")
    public String firstname;

    @Required(message = "Lastname is required")
    public String lastname;
}
