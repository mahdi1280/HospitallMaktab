package ir.maktab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
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
    @ManyToMany(mappedBy = "doctors")
    private Collection<Clinic> clinics;
}
