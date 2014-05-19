/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sweetBank;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author arash
 */
@Entity
@Table(name = "account_history", catalog = "sweetbankdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "AccountHistory.findAll", query = "SELECT a FROM AccountHistory a"),
    @NamedQuery(name = "AccountHistory.findByAccountNumber", query = "SELECT a FROM AccountHistory a WHERE a.accountNumber = :accountNumber"),
    @NamedQuery(name = "AccountHistory.findByAccountOwner", query = "SELECT a FROM AccountHistory a WHERE a.accountOwner = :accountOwner"),
    @NamedQuery(name = "AccountHistory.findByAccountHistoryDate", query = "SELECT a FROM AccountHistory a WHERE a.accountHistoryDate = :accountHistoryDate"),
    @NamedQuery(name = "AccountHistory.findByAccountBalance", query = "SELECT a FROM AccountHistory a WHERE a.accountBalance = :accountBalance"),
    @NamedQuery(name = "AccountHistory.findByActionTypeActionId", query = "SELECT a FROM AccountHistory a WHERE a.actionTypeActionId = :actionTypeActionId")})
public class AccountHistory implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "account_number")
    private Integer accountNumber;
    @Basic(optional = false)
    @Column(name = "account_owner")
    private String accountOwner;
    @Basic(optional = false)
    @Column(name = "account_history_date")
    @Temporal(TemporalType.DATE)
    private Date accountHistoryDate;
    @Basic(optional = false)
    @Column(name = "account_balance")
    private String accountBalance;
    @Basic(optional = false)
    @Column(name = "action_type_action_id")
    private int actionTypeActionId;

    public AccountHistory() {
    }

    public AccountHistory(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountHistory(Integer accountNumber, String accountOwner, Date accountHistoryDate, String accountBalance, int actionTypeActionId) {
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
        this.accountHistoryDate = accountHistoryDate;
        this.accountBalance = accountBalance;
        this.actionTypeActionId = actionTypeActionId;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        Integer oldAccountNumber = this.accountNumber;
        this.accountNumber = accountNumber;
        changeSupport.firePropertyChange("accountNumber", oldAccountNumber, accountNumber);
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        String oldAccountOwner = this.accountOwner;
        this.accountOwner = accountOwner;
        changeSupport.firePropertyChange("accountOwner", oldAccountOwner, accountOwner);
    }

    public Date getAccountHistoryDate() {
        return accountHistoryDate;
    }

    public void setAccountHistoryDate(Date accountHistoryDate) {
        Date oldAccountHistoryDate = this.accountHistoryDate;
        this.accountHistoryDate = accountHistoryDate;
        changeSupport.firePropertyChange("accountHistoryDate", oldAccountHistoryDate, accountHistoryDate);
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        String oldAccountBalance = this.accountBalance;
        this.accountBalance = accountBalance;
        changeSupport.firePropertyChange("accountBalance", oldAccountBalance, accountBalance);
    }

    public int getActionTypeActionId() {
        return actionTypeActionId;
    }

    public void setActionTypeActionId(int actionTypeActionId) {
        int oldActionTypeActionId = this.actionTypeActionId;
        this.actionTypeActionId = actionTypeActionId;
        changeSupport.firePropertyChange("actionTypeActionId", oldActionTypeActionId, actionTypeActionId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountNumber != null ? accountNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountHistory)) {
            return false;
        }
        AccountHistory other = (AccountHistory) object;
        if ((this.accountNumber == null && other.accountNumber != null) || (this.accountNumber != null && !this.accountNumber.equals(other.accountNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "theswedenbank.AccountHistory[ accountNumber=" + accountNumber + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
