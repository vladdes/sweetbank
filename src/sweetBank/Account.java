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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "account", catalog = "sweetbankdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findById", query = "SELECT a FROM Account a WHERE a.id = :id"),
    @NamedQuery(name = "Account.findByBalance", query = "SELECT a FROM Account a WHERE a.balance = :balance"),
    @NamedQuery(name = "Account.findByAccountNumber", query = "SELECT a FROM Account a WHERE a.accountNumber = :accountNumber"),
    @NamedQuery(name = "Account.findByAccountOwnerCredentialsId", query = "SELECT a FROM Account a WHERE a.accountOwnerCredentialsId = :accountOwnerCredentialsId")})
public class Account implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "balance")
    private Float balance;
    @Basic(optional = false)
    @Column(name = "account_number")
    private String accountNumber;
    @Basic(optional = false)
    @Column(name = "account_owner_credentials_id")
    private int accountOwnerCredentialsId;

    public Account() {
    }

    public Account(Integer id) {
        this.id = id;
    }

    public Account(Integer id, String accountNumber, int accountOwnerCredentialsId) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountOwnerCredentialsId = accountOwnerCredentialsId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        Float oldBalance = this.balance;
        this.balance = balance;
        changeSupport.firePropertyChange("balance", oldBalance, balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        String oldAccountNumber = this.accountNumber;
        this.accountNumber = accountNumber;
        changeSupport.firePropertyChange("accountNumber", oldAccountNumber, accountNumber);
    }

    public int getAccountOwnerCredentialsId() {
        return accountOwnerCredentialsId;
    }

    public void setAccountOwnerCredentialsId(int accountOwnerCredentialsId) {
        int oldAccountOwnerCredentialsId = this.accountOwnerCredentialsId;
        this.accountOwnerCredentialsId = accountOwnerCredentialsId;
        changeSupport.firePropertyChange("accountOwnerCredentialsId", oldAccountOwnerCredentialsId, accountOwnerCredentialsId);
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
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "theswedenbank.Account[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
