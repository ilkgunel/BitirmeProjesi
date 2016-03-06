/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.ExistenceChecking;
import org.eclipse.persistence.annotations.ExistenceType;

/**
 *
 * @author Batuhan
 */
@Entity
@Table(name = "teacherroles", catalog = "e_odev", schema = "")
@XmlRootElement
@Cache(
        type = CacheType.SOFT, // Cache everything until the JVM decides memory is low.
        size = 64000, // Use 64,000 as the initial cache size.
        expiry = 36000000, // 10 minutes
        coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS // if cache coordination is used, only send invalidation messages.
)
@Cacheable(true)
@ExistenceChecking(ExistenceType.CHECK_CACHE)
@NamedQueries({
    @NamedQuery(name = "Teacherroles.findAll", query = "SELECT t FROM Teacherroles t"),
    @NamedQuery(name = "Teacherroles.findById", query = "SELECT t FROM Teacherroles t WHERE t.id = :id"),
    @NamedQuery(name = "Teacherroles.findByLoginnumber", query = "SELECT t FROM Teacherroles t WHERE t.loginnumber = :loginnumber"),
    @NamedQuery(name = "Teacherroles.findByRole", query = "SELECT t FROM Teacherroles t WHERE t.role = :role")})
public class Teacherroles extends BasePersistenceObject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 255)
    @Column(name = "loginnumber")
    private String loginnumber;
    @Size(max = 255)
    @Column(name = "role")
    private String role;

    public Teacherroles() {
    }

    public Teacherroles(Integer id) {
        super(id);
    }

    @Override
    public void setId(Integer id) {
        this.id = id; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public String getLoginnumber() {
        return loginnumber;
    }

    public void setLoginnumber(String loginnumber) {
        this.loginnumber = loginnumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.getId() != null ? super.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacherroles)) {
            return false;
        }
        Teacherroles other = (Teacherroles) object;
        if ((super.getId() == null && other.getId() != null) || (super.getId() != null && !super.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bitirmeprojesi.entity.Teacherroles[ id=" + super.getId() + " ]";
    }

}
