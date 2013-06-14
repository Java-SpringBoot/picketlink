/*
 * JBoss, Home of Professional Open Source
 *
 * Copyright 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.picketlink.idm.jpa.schema;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.picketlink.idm.jpa.annotations.OwnerReference;
import org.picketlink.idm.jpa.annotations.RelationshipDescriptor;
import org.picketlink.idm.jpa.annotations.RelationshipMember;

/**
 * <p>
 * JPA {@link Entity} to store the IdentityType instances associated with a specific {@link Relationship}. This
 * class should be used when the JPA store is NOT being used to store IdentityType instances, where only the id is
 * stored.
 * </p>
 * <p>
 * You should map this class when the JPA store is using in conjunction with another store (eg.: LDAP).
 * </p>
 *
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 *
 */
@Entity
public class RelationshipIdentityWeakObject implements Serializable {

    private static final long serialVersionUID = 8957185191684867238L;

    @Id
    @GeneratedValue
    private Long id;

    @RelationshipDescriptor
    private String descriptor;

    @RelationshipMember
    private String identityId;

    @OwnerReference
    @ManyToOne
    private Relationship relationshipObject;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public Relationship getRelationshipObject() {
        return relationshipObject;
    }

    public void setRelationshipObject(Relationship relationshipObject) {
        this.relationshipObject = relationshipObject;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!getClass().isInstance(obj)) {
            return false;
        }

        RelationshipIdentityWeakObject other = (RelationshipIdentityWeakObject) obj;

        return getId() != null && other.getId() != null && getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        return result;
    }
}
