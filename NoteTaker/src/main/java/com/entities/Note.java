package com.entities;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(length = 1500)
    private String content;
    private LocalDateTime addedDate;

    public Note() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }

    public Note(int id, String title, String content, LocalDateTime addedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.addedDate = addedDate;
    }

    public Note(String title, String content, LocalDateTime addedDate) {
        this.title = title;
        this.content = content;
        this.addedDate = addedDate;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", addedDate=" + addedDate +
                '}';
    }
}
