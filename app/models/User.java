package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Basav Nagur
 */

@Entity
public class User extends Model {

    public String login;

    @Id
    public String id;
    public String name;
    public String public_repos;
}
