/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sait.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rehan
 */
@Entity
@Table(name = "userdb_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserdbUser.findAll", query = "SELECT u FROM UserdbUser u"),
    @NamedQuery(name = "UserdbUser.findByEmail", query = "SELECT u FROM UserdbUser u WHERE u.email = :email"),
    @NamedQuery(name = "UserdbUser.findByActive", query = "SELECT u FROM UserdbUser u WHERE u.active = :active"),
    @NamedQuery(name = "UserdbUser.findByFirstName", query = "SELECT u FROM UserdbUser u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "UserdbUser.findByLastName", query = "SELECT u FROM UserdbUser u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "UserdbUser.findByPassword", query = "SELECT u FROM UserdbUser u WHERE u.password = :password")})
public class UserdbUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "role", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private UserdbRole role;

    public UserdbUser() {
    }

    public UserdbUser(String email) {
        this.email = email;
    }

    public UserdbUser(String email, boolean active, String firstName, String lastName, String password, UserdbRole role) {
        this.email = email;
        this.active = active;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserdbRole getRole() {
        return role;
    }

    public void setRole(UserdbRole role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserdbUser)) {
            return false;
        }
        UserdbUser other = (UserdbUser) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ca.sait.models.UserdbUser[ email=" + email + " ]";
    }
    
}
