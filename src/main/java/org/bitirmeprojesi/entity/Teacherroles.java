/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bitirmeprojesi.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.ExistenceChecking;
import org.eclipse.persistence.annotations.ExistenceType;
import org.eclipse.persistence.config.CacheIsolationType;

/**
 *
 * @author Batuhan
 */
@Entity
@Table(name = "teacherroles")
@XmlRootElement
@Cache(
        type = CacheType.WEAK,
        size = 100,
        isolation = CacheIsolationType.SHARED,
        disableHits = true,
        alwaysRefresh = false,
        expiry = 7200000 //2 minutes
)
@ExistenceChecking(ExistenceType.CHECK_CACHE)
@NamedQueries({
    @NamedQuery(name = "Teacherroles.findAll", query = "SELECT t FROM Teacherroles t"),
    @NamedQuery(name = "Teacherroles.findByLoginnumber", query = "SELECT t FROM Teacherroles t WHERE t.loginnumber = :loginnumber"),
    @NamedQuery(name = "Teacherroles.findByRole", query = "SELECT t FROM Teacherroles t WHERE t.role = :role")})
public class Teacherroles extends BasePersistenceObject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "loginnumber")
    private String loginnumber;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "role")
    private String role;

    public Teacherroles() {
    }

    public Teacherroles(Integer id) {
        super(id);
    }

    public Teacherroles(String loginnumber, String role) {
        this.loginnumber = loginnumber;
        this.role = role;
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
}
