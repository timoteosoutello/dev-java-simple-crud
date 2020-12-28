package com.github.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "User")
public class User implements Serializable {

    private static final long serialVersionUID = 2024647852460239851L;
    /**
     * User identifier.
     */
    @Id
    @Column
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid")
    private String id;

    /**
     * Profile object.
     */
    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    /**
     * User name.
     */
    @Column(nullable = false)
    @NotNull
    private String name;

    /**
     * User email.
     */
    @Column(nullable = false)
    @NotNull
    private String email;

    /**
     * User password.
     */
    @Column(nullable = false)
    @NotNull
    private String password;

    /**
     * User phone.
     */
    @Column
    private String phone;

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
