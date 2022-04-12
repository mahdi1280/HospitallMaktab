package ir.maktab.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = Schema.SCHEMA)
public class Doctor extends BaseEntity{

    private String name;
    @ManyToMany(mappedBy = "doctors",fetch = FetchType.LAZY)
    private Collection<Clinic> clinics;

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", clinics=" + clinics +
                '}';
    }
}
