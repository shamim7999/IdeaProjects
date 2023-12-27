package com.entity;

import javax.persistence.*;

@Entity(name = "answer")
public class Answer {

    @Id
    @Column(name = "answer_id")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int answerId;
    private String answer;

    //@OneToOne(mappedBy = "answer")
   // private Question question;

//    public Question getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(Question question) {
//        this.question = question;
//    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", answer='" + answer + '\'' +
                '}';
    }
    public Answer(){}
}
