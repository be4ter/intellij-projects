package mrs.domain.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class ReservableRoomId implements Serializable {
    private static final long serialVersionUID = 2133924934789863151L;

    private Integer roomId;
    private LocalDateTime reservedDate;

    public ReservableRoomId(Integer roomId, LocalDateTime reservedDate) {
        this.roomId = roomId;
        this.reservedDate = reservedDate;
    }

    public ReservableRoomId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservableRoomId that = (ReservableRoomId) o;
        return Objects.equals(roomId, that.roomId) &&
                Objects.equals(reservedDate, that.reservedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, reservedDate);
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public LocalDateTime getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(LocalDateTime reservedDate) {
        this.reservedDate = reservedDate;
    }
}
