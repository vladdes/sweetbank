/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sweetBank;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author arash
 */
@Entity
@Table(name = "account_owner", catalog = "sweetbankdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "AccountOwner.findAll", query = "SELECT a FROM AccountOwner a"),
    @NamedQuery(name = "AccountOwner.findByName", query = "SELECT a FROM AccountOwner a WHERE a.name = :name"),
    @NamedQuery(name = "AccountOwner.findByPersonNumber", query = "SELECT a FROM AccountOwner a WHERE a.personNumber = :personNumber"),
    @NamedQuery(name = "AccountOwner.findByAddress", query = "SELECT a FROM AccountOwner a WHERE a.address = :address"),
    @NamedQuery(name = "AccountOwner.findByPhoneNumber", query = "SELECT a FROM AccountOwner a WHERE a.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "AccountOwner.findByTitle", query = "SELECT a FROM AccountOwner a WHERE a.title = :title"),
    @NamedQuery(name = "AccountOwner.findByCredentialsId", query = "SELECT a FROM AccountOwner a WHERE a.credentialsId = :credentialsId")})
public class AccountOwner implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Id
    @Basic(optional = false)
    @Column(name = "person_number")
    private String personNumber;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "credentials_id")
    private int credentialsId;

    public AccountOwner() {
    }

    public AccountOwner(String personNumber) {
        this.personNumber = personNumber;
    }

    public AccountOwner(String personNumber, String name, String address, String phoneNumber, String title, int credentialsId) {
        this.personNumber = personNumber;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.credentialsId = credentialsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        String oldPersonNumber = this.personNumber;
        this.personNumber = personNumber;
        changeSupport.firePropertyChange("personNumber", oldPersonNumber, personNumber);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        String oldPhoneNumber = this.phoneNumber;
        this.phoneNumber = phoneNumber;
        changeSupport.firePropertyChange("phoneNumber", oldPhoneNumber, phoneNumber);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        changeSupport.firePropertyChange("title", oldTitle, title);
    }

    public int getCredentialsId() {
        return credentialsId;
    }

    public void setCredentialsId(int credentialsId) {
        int oldCredentialsId = this.credentialsId;
        this.credentialsId = credentialsId;
        changeSupport.firePropertyChange("credentialsId", oldCredentialsId, credentialsId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personNumber != null ? personNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountOwner)) {
            return false;
        }
        AccountOwner other = (AccountOwner) object;
        if ((this.personNumber == null && other.personNumber != null) || (this.personNumber != null && !this.personNumber.equals(other.personNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "theswedenbank.AccountOwner[ personNumber=" + personNumber + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
