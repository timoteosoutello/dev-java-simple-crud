package com.github.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserClickDTO implements Serializable {

    private static final long serialVersionUID = -6565956492712538819L;
    /**
     * Path for the URL.
     */
    @NotNull
    private String path;

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
