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
@Table(name = "action_type", catalog = "sweetbankdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "ActionType.findAll", query = "SELECT a FROM ActionType a"),
    @NamedQuery(name = "ActionType.findByActionId", query = "SELECT a FROM ActionType a WHERE a.actionId = :actionId"),
    @NamedQuery(name = "ActionType.findByActiontype", query = "SELECT a FROM ActionType a WHERE a.actiontype = :actiontype")})
public class ActionType implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "action_id")
    private Integer actionId;
    @Basic(optional = false)
    @Column(name = "actiontype")
    private String actiontype;

    public ActionType() {
    }

    public ActionType(Integer actionId) {
        this.actionId = actionId;
    }

    public ActionType(Integer actionId, String actiontype) {
        this.actionId = actionId;
        this.actiontype = actiontype;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        Integer oldActionId = this.actionId;
        this.actionId = actionId;
        changeSupport.firePropertyChange("actionId", oldActionId, actionId);
    }

    public String getActiontype() {
        return actiontype;
    }

    public void setActiontype(String actiontype) {
        String oldActiontype = this.actiontype;
        this.actiontype = actiontype;
        changeSupport.firePropertyChange("actiontype", oldActiontype, actiontype);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actionId != null ? actionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActionType)) {
            return false;
        }
        ActionType other = (ActionType) object;
        if ((this.actionId == null && other.actionId != null) || (this.actionId != null && !this.actionId.equals(other.actionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "theswedenbank.ActionType[ actionId=" + actionId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
