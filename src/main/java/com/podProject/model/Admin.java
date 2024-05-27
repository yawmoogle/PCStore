package com.podProject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "`Admin`")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_generator")
    @SequenceGenerator(name = "admin_generator", sequenceName = "admin_seq", allocationSize = 1, initialValue = 1)
    @Column(name = "adminId")
    private long adminId;

    @Column(name = "adminusername", unique = true)
    private String adminusername;

    @Column(name = "adminpassword")
    private String adminpassword;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public String getAdminusername() {
        return adminusername;
    }

    public void setAdminusername(String adminusername) {
        this.adminusername = adminusername;
    }

    public String getAdminpassword() {
        return adminpassword;
    }

    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
