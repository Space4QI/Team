package ru.zulvit.teamentropy.DTO;

import ru.zulvit.teamentropy.entity.Message;

import java.util.List;

public class ForumDTO {

    private String topic;

    private String theme;

    private String tags;

    private List<MessageDTO> message;

    public ForumDTO(){

    }

    public ForumDTO(String topic, String theme, String tags, List<MessageDTO> message) {
        this.topic = topic;
        this.theme = theme;
        this.tags = tags;
        this.message = message;
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

    public List<MessageDTO> getMessage() {
        return message;
    }

    public void setMessage(List<MessageDTO> message) {
        this.message = message;
    }
}
