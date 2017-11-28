package by.bsuir.ilyacoding.Server.domain;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "Affair")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "name", "birthDate", "course"})
public class Affair implements Serializable {

    private static final long serialVersionUID = -93257239572923L;

    @XmlAttribute(name = "ID")
    private int id;
    private String name;
    private String birthDate;
    private Integer course;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }
}
