import java.util.ArrayList;
import java.util.List;

public class Event {
    private String title;
    private String date;
    private String description;
    private List<Person> audience;

    Event(String title) {
        this.title = title;
        this.date = "";
        this.description = "";
        audience = new ArrayList<>();
    }

    Event(String title,String date) {
        this.title = title;
        this.date = date;
        this.description = "";
        audience = new ArrayList<>();

    }

    Event(String title,String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
        audience = new ArrayList<>();

    }

    public Event(Event e) {
        this.title = e.getTitle();
        this.date = e.getDate();
        this.description = e.getDescription();
        this.audience = e.getAudience();
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.title + " is a " + this.description + " and will be held at " + this.date + ".";
    }
    @Override
    public boolean equals(Object o) {
        return o instanceof Event && this.title.equals(((Event)o).getTitle()) && this.date.equals(((Event)o).getDate()) && this.description.equals(((Event)o).getDescription());
    }

    public List<Person> getAudience() {
        return audience;
    }

    public void addPerson(Person p) {
        for(Person participant: audience) {
            if(participant.equals(p))
                return;
        }
        audience.add(p);
    }

    public int getAudienceCount() {
        return audience.size();
    }
}
