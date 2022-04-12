package ir.maktab.model;

import lombok.*;

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

    public static Builder builder(){
        return new Builder();
    }

    @Override
    public String toString() {
        return "User{id: " +super.getId()+
                " , username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public static class Builder{

        private String username;
        private String password;
        private Role role;

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Builder role(Role role){
            this.role = role;
            return this;
        }

        public User build(){
            return new User(username,password,role);
        }
    }

}
