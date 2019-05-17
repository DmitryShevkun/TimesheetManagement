package app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Invitations")
public class Invitation {
    @Id
    private int id;
    private int partnerId;
    private String code;
    private Date dateEnd;
    private String status;

    public Invitation() {
    }

    public Invitation(int id, int partnerId, String code,
                      Date dateEnd, String status) {
        this.id = id;
        this.partnerId = partnerId;
        this.code = code;
        this.dateEnd = dateEnd;
        this.status = status;
    }

    public Invitation(Invitation invitation) {
        this(
                invitation.getId(),
                invitation.getPartnerId(),
                invitation.getCode(),
                invitation.getDateEnd(),
                invitation.getStatus()
        );
    }

    public int getId() {
        return id;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public String getCode() {
        return code;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Invitation{"
                + "id=" + id
                + ", partnerId=" + partnerId
                + ", code='" + code + '\''
                + ", dateEnd=" + dateEnd
                + ", status='" + status + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Invitation that = (Invitation) o;

        if (id != that.id) {
            return false;
        }
        if (partnerId != that.partnerId) {
            return false;
        }
        if (!Objects.equals(code, that.code)) {
            return false;
        }
        if (!Objects.equals(dateEnd, that.dateEnd)) {
            return false;
        }
        return Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + partnerId;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
