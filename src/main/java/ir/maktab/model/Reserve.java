package ir.maktab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = Schema.SCHEMA)
public class Reserve extends BaseEntity {

    @CreationTimestamp
    private LocalDate createdAt;
    @Enumerated(EnumType.STRING)
    private Time time;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;

    public Reserve(Time time, User user, Doctor doctor) {
        this.time = time;
        this.user = user;
        this.doctor = doctor;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Reserve{id= " + super.getId() +
                " , createdAt=" + createdAt +
                ", time=" + time +
                ", user=" + user +
                ", doctor=" + doctor +
                '}';
    }

    public static class Builder {

        private Time time;
        private User user;
        private Doctor doctor;

        private Builder() {
        }

        public Builder time(Time time) {
            this.time = time;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder doctor(Doctor doctor) {
            this.doctor = doctor;
            return this;
        }

        public Reserve build() {
            return new Reserve(time, user, doctor);
        }
    }
}
