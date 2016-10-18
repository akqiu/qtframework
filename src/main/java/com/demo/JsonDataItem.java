package com.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by qiutian on 16-9-25.
 */
public class JsonDataItem {

    public boolean is_answered() {
        return is_answered;
    }

    public void setIs_answered(boolean is_answered) {
        this.is_answered = is_answered;
    }

    public long getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(long creation_date) {
        this.creation_date = creation_date;
    }

    public long getAnswer_count() {
        return answer_count;
    }

    public void setAnswer_count(long answer_count) {
        this.answer_count = answer_count;
    }

    public long getLast_activity_date() {
        return last_activity_date;
    }

    public void setLast_activity_date(long last_activity_date) {
        this.last_activity_date = last_activity_date;
    }

    public long getLast_edit_date() {
        return last_edit_date;
    }

    public void setLast_edit_date(long last_edit_date) {
        this.last_edit_date = last_edit_date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(long question_id) {
        this.question_id = question_id;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getView_count() {
        return view_count;
    }

    public void setView_count(long view_count) {
        this.view_count = view_count;
    }

    public HashMap<Integer, String> getTags() {
        return tags;
    }

    public void setTags(HashMap<Integer, String> tags) {
        this.tags = tags;
    }

    public List<Employee> getOwner() {
        return owner;
    }

    public void setOwner(List<Employee> owner) {
        this.owner = owner;
    }

    private boolean is_answered;
    private long creation_date;
    private long answer_count;
    private long last_activity_date;
    private long last_edit_date;
    private String link;
    private long question_id;
    private long score;
    private String title;
    private long view_count;

    private HashMap<Integer,String> tags = new HashMap<Integer,String>();

    private List<Employee> owner = new ArrayList<Employee>();

}
