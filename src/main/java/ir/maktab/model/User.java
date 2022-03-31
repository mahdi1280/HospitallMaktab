package ir.maktab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Schema.USER_TABLE_NAME,schema = Schema.SCHEMA)
public class User extends BaseEntity{

    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

}
