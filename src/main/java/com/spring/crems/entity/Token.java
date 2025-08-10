package com.spring.crems.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tokens")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    @Column(name = "is_log_out")
    private Boolean isLogdOut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Token() {
    }

    public Token(Long id, String token, Boolean isLogdOut, User user) {
        this.id = id;
        this.token = token;
        this.isLogdOut = isLogdOut;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getLogdOut() {
        return isLogdOut;
    }

    public void setLogdOut(Boolean logdOut) {
        isLogdOut = logdOut;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
