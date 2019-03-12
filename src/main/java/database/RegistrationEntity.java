package database;

import javax.persistence.*;

@Entity
@Table(name = "REGISTRATION", schema = "PUBLIC", catalog = "TEST")
public class RegistrationEntity {
    private int id;
    private String first;
    private String last;
    private String father;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FIRST", nullable = true, length = 255)
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    @Basic
    @Column(name = "LAST", nullable = true, length = 255)
    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Basic
    @Column(name = "FATHER", nullable = true, length = 255)
    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistrationEntity that = (RegistrationEntity) o;

        if (id != that.id) return false;
        if (first != null ? !first.equals(that.first) : that.first != null) return false;
        if (last != null ? !last.equals(that.last) : that.last != null) return false;
        if (father != null ? !father.equals(that.father) : that.father != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (first != null ? first.hashCode() : 0);
        result = 31 * result + (last != null ? last.hashCode() : 0);
        result = 31 * result + (father != null ? father.hashCode() : 0);
        return result;
    }
}
