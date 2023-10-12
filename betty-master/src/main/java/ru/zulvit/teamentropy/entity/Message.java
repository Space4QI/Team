package ru.zulvit.teamentropy.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "sender", referencedColumnName = "email")
    private User sender;

    @Column(name = "recipient")
    private String recipient;

    @Column(name = "content")
    private String content;

    @Column(name = "reputation", columnDefinition = "smallint default 0")
    private short reputation;

    @ManyToOne
    @JoinColumn(name = "forum", referencedColumnName = "topic")
    private Forum forum;

    public Message(Long id, String text, User sender, String recipient, String content, short reputation, Forum forum) {
        this.id = id;
        this.text = text;
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.reputation = reputation;
        this.forum = forum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public short getReputation() {
        return reputation;
    }

    public void setReputation(short reputation) {
        this.reputation = reputation;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public void setUser(User user) {
    }
}
