package ir.maktab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = Schema.SCHEMA)
public class Clinic extends BaseEntity {

    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(schema = Schema.SCHEMA, name = "CLINIC_DOCTOR"
            , joinColumns = @JoinColumn(name = "clinic_id")
            , inverseJoinColumns = @JoinColumn(name = "doctor_id"))
    private Collection<Doctor> doctors;

    public Clinic(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "name='" + name + '\'' +
                '}';
    }
}
