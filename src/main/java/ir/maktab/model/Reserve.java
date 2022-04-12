package ir.maktab.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = Schema.SCHEMA)
public class Reserve extends BaseEntity{

    @CreationTimestamp
    private LocalDate createdAt;
    @Enumerated(EnumType.STRING)
    private Time time;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;


    @Override
    public String toString() {
        return "Reserve{id= " +super.getId()+
                " , createdAt=" + createdAt +
                ", time=" + time +
                ", user=" + user +
                ", doctor=" + doctor +
                '}';
    }
}
