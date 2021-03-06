package persistence;

import lombok.Data;
import lombok.EqualsAndHashCode;
import services.UserService;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Table(name = "user")
@Entity
@NamedQueries({
    @NamedQuery(name = UserService.FIND_ALL, query = "SELECT u FROM User u"),
    @NamedQuery(name = UserService.FIND_BY_USERNAME_OR_EMAIL, query = "SELECT u FROM User u " +
        "WHERE u.username = ?1 OR u.email = ?1")
})
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends CommonEntity {

  private String username;

  private String email;

  private String password;

  private String firstName;

  private String lastName;

  private LocalDate birthday;

  @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private UserConfig config;

}
