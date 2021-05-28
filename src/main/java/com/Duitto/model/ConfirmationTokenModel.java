package com.Duitto.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;


@Entity
@SequenceGenerator(name="seqToken", initialValue=1212121)
@Table(name="sh_confirmation_tokens")
public class ConfirmationTokenModel {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqToken")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    private String confirmationToken;

    private long createdDate;

    private String cusEmail;

    public ConfirmationTokenModel(String cusEmail, long createdDate) {
        this.cusEmail = cusEmail;
        this.createdDate = createdDate;
        this.confirmationToken = UUID.randomUUID().toString();
    }

    public ConfirmationTokenModel() {

    }
    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }
    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
