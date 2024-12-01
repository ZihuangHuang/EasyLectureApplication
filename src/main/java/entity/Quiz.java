package entity;

import java.util.List;

public class Quiz {
    private String content;
    private List<String> choices;
    private String answer;

    public Quiz(String content, List<String> choices, String answer) {
        this.content = content;
        this.choices = choices;
        this.answer = answer;
    }

    public String getcontent() {
        return content;
    }

    public List<String> getchoices() {
        return choices;
    }

    public String getanswer() {
        return answer;
    }

    public void setcontent(String content) {
        this.content = content;
    }

    public void setchoices(List<String> choices) {
        this.choices = choices;
    }

    public void setanswer(String answer) {
        this.answer = answer;
    }


}
