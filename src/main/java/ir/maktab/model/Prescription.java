package ir.maktab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(schema = Schema.SCHEMA)
public class Prescription extends BaseEntity {

    @CreationTimestamp
    private LocalDate localDate;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    private Reserve reserve;

    @Override
    public String toString() {
        return "Prescription{" +
                "localDate=" + localDate +
                ", description='" + description + '\'' +
                ", reserve=" + reserve +
                '}';
    }

    public Prescription(String description, Reserve reserve) {
        this.description = description;
        this.reserve = reserve;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String description;
        private Reserve reserve;

        private Builder() {
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder reserve(Reserve reserve) {
            this.reserve = reserve;
            return this;
        }

        public Prescription build() {
            return new Prescription(description, reserve);
        }
    }
}
