package View.form;

import View.login.*;
import java.awt.Color;

public class ModelNoticeBoard1 {

    public Color getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(Color titleColor) {
        this.titleColor = titleColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ModelNoticeBoard1(Color titleColor, String title, String time, String description) {
        this.titleColor = titleColor;
        this.title = title;
        this.time = time;
        this.description = description;
    }

    public ModelNoticeBoard1() {
    }

    private Color titleColor;
    private String title;
    private String time;
    private String description;
}
