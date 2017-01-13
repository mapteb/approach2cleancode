/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderpizza.pizza;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nalla Senthilnathan (https://github.com/mapteb/approach2cleancode)
 * 
 */
@Entity
@Table(name = "PIZZAITEM")
@XmlRootElement
public class PizzaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMERID")
    private int customerid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "SIZE")
    private String size;
    @Column(name = "TOPPING_PEPPERONI")
    private Character toppingPepperoni;
    @Column(name = "TOPPING_SPINACH")
    private Character toppingSpinach;
    @Column(name = "TOPPING_MUSHROOM")
    private Character toppingMushroom;

    public PizzaEntity() {
        
    }

    public PizzaEntity(Integer id) {
        this.id = id;
    }

    public PizzaEntity(Integer id, int customerid, String type, String size, Character mushroom, Character pepperoni, Character spinach) {
        this.id = id;
        this.customerid = customerid;
        this.type = type;
        this.size = size;
        this.toppingMushroom=mushroom;
        this.toppingPepperoni=pepperoni;
        this.toppingSpinach=spinach;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Character getToppingPepperoni() {
        return toppingPepperoni;
    }

    public void setToppingPepperoni(Character toppingPepperoni) {
        this.toppingPepperoni = toppingPepperoni;
    }

    public Character getToppingSpinach() {
        return toppingSpinach;
    }

    public void setToppingSpinach(Character toppingSpinach) {
        this.toppingSpinach = toppingSpinach;
    }

    public Character getToppingMushroom() {
        return toppingMushroom;
    }

    public void setToppingMushroom(Character toppingMushroom) {
        this.toppingMushroom = toppingMushroom;
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
        if (!(object instanceof PizzaEntity)) {
            return false;
        }
        PizzaEntity other = (PizzaEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enterprise.web_jpa_war.entity.PizzaEnity[ id=" + id + " ]";
    }
    
}
