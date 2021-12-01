package day6.pojo;

import java.util.List;

public class Search {
    @Override
    public String toString() {
        return "Search{" +
                "content=" + content +
                ", totalElement=" + totalElement +
                '}';
    }

    private List<Spartan> content;
    private int totalElement;

    public List<Spartan> getContent() {
        return content;
    }

    public void setContent(List<Spartan> content) {
        this.content = content;
    }

    public int getTotalElement() {
        return totalElement;
    }



    }

