package ru.zulvit.teamentropy.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Forum {

    @Id
    @Column(name = "topic")
    private String topic;

    @Column(name = "theme")
    private String theme;

    @Column(name = "tags", nullable = false)
    private String tags;

    // Relationship
    @OneToMany(mappedBy = "forum")
    private List<Message> messages;

    public Forum(String topic, String theme, String tags, List<Message> messages) {
        this.topic = topic;
        this.theme = theme;
        this.tags = tags;
        this.messages = messages;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}