package com.github.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USER_CLICKS")
public class UserClick implements Serializable {

    private static final long serialVersionUID = 8814240151200152934L;

    public UserClick() {
	// Default contructor
    }

    public UserClick(String path) {
	this.path = path;
	this.numberOfClicks = 1L;
    }

    /**
     * User Click identifier.
     */
    @Id
    @Column
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid")
    private String id;

    /**
     * Path for the URL.
     */
    @Column(nullable = false)
    @NotNull
    private String path;

    /**
     * Number of clicks counter.
     */
    @Column(nullable = false)
    @NotNull
    private Long numberOfClicks;
    
    /**
     * Increment number of clicks
     */
    public void incrementNumberOfClicks() {
	this.numberOfClicks ++;
    }

    @Override
    public String toString() {
	return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(final Object object) {
	return EqualsBuilder.reflectionEquals(this, object);
    }

    @Override
    public int hashCode() {
	return HashCodeBuilder.reflectionHashCode(this);
    }
}
