/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author iOSDev
 */
@Entity
@Table(name = "LB_USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LbUser.findAll", query = "SELECT l FROM LbUser l")
    , @NamedQuery(name = "LbUser.findByUserId", query = "SELECT l FROM LbUser l WHERE l.userId = :userId")
    , @NamedQuery(name = "LbUser.findByName", query = "SELECT l FROM LbUser l WHERE l.name = :name")
    , @NamedQuery(name = "LbUser.findByPassword", query = "SELECT l FROM LbUser l WHERE l.password = :password")
    , @NamedQuery(name = "LbUser.findByEmail", query = "SELECT l FROM LbUser l WHERE l.email = :email")
    , @NamedQuery(name = "LbUser.findByPhone", query = "SELECT l FROM LbUser l WHERE l.phone = :phone")
    , @NamedQuery(name = "LbUser.findByAddress", query = "SELECT l FROM LbUser l WHERE l.address = :address")
    , @NamedQuery(name = "LbUser.findByAppgroup", query = "SELECT l FROM LbUser l WHERE l.appgroup = :appgroup")
    , @NamedQuery(name = "LbUser.findByActive", query = "SELECT l FROM LbUser l WHERE l.active = :active")
    , @NamedQuery(name = "LbUser.findByMemo", query = "SELECT l FROM LbUser l WHERE l.memo = :memo")})
public class LbUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "USER_ID")
    private String userId;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 64)
    @Column(name = "PASSWORD")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 10)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 50)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 15)
    @Column(name = "APPGROUP")
    private String appgroup;
    @Column(name = "ACTIVE")
    private Boolean active;
    @Size(max = 255)
    @Column(name = "MEMO")
    private String memo;
    @OneToMany(mappedBy = "userId")
    private Collection<LbBorrowedBook> lbBorrowedBookCollection;

    public LbUser() {
    }

    public LbUser(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAppgroup() {
        return appgroup;
    }

    public void setAppgroup(String appgroup) {
        this.appgroup = appgroup;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @XmlTransient
    public Collection<LbBorrowedBook> getLbBorrowedBookCollection() {
        return lbBorrowedBookCollection;
    }

    public void setLbBorrowedBookCollection(Collection<LbBorrowedBook> lbBorrowedBookCollection) {
        this.lbBorrowedBookCollection = lbBorrowedBookCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LbUser)) {
            return false;
        }
        LbUser other = (LbUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LbUser[ userId=" + userId + " ]";
    }
    
}
