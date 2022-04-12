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

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", clinics=" + clinics +
                '}';
    }

    public static class Builder{

        private String name;
        private Collection<Clinic> clinics;

        private Builder(){}

        public Builder name(String name){
            this.name=name;
            return this;
        }

        public Builder clinics(Collection<Clinic> clinics){
            this.clinics=clinics;
            return this;
        }

        public Doctor build(){
            return new Doctor(name,clinics);
        }
    }
}
