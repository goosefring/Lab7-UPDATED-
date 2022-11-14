/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sait.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rehan
 */
@Entity
@Table(name = "userdb_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserdbRole.findAll", query = "SELECT u FROM UserdbRole u"),
    @NamedQuery(name = "UserdbRole.findByRoleId", query = "SELECT u FROM UserdbRole u WHERE u.id = :id"),
    @NamedQuery(name = "UserdbRole.findByRoleName", query = "SELECT u FROM UserdbRole u WHERE u.name = :name")})
public class UserdbRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "role_id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "role_name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<UserdbUser> userdbUserList;

    public UserdbRole() {
    }

    public UserdbRole(Integer id) {
        this.id = id;
    }

    public UserdbRole(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<UserdbUser> getUserdbUserList() {
        return userdbUserList;
    }

    public void setUserdbUserList(List<UserdbUser> userdbUserList) {
        this.userdbUserList = userdbUserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserdbRole)) {
            return false;
        }
        UserdbRole other = (UserdbRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ca.sait.models.UserdbRole[ id=" + id + " ]";
    }
    
}
