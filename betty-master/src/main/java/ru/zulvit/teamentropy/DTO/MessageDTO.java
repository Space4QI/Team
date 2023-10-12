package ru.zulvit.teamentropy.DTO;

public class MessageDTO {

    private Long id;

    private String text;

    private String recipient;

    private String content;

    private short reputation;

    private String forumId;

    private String userId;

    public MessageDTO(){

    }

    public MessageDTO(Long id, String text, String recipient, String content, short reputation, String forumId, String userId) {
        this.id = id;
        this.text = text;
        this.recipient = recipient;
        this.content = content;
        this.reputation = reputation;
        this.forumId = forumId;
        this.userId = userId;
    }

    public String getForumId() {
        return forumId;
    }

    public void setForumId(String forumId) {
        this.forumId = forumId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
