package mrs.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1016314399260689548L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "reserved_date"),
            @JoinColumn(name = "room_id")})
    private ReservableRoom reservableRoom;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public ReservableRoom getReservableRoom() {
        return reservableRoom;
    }

    public void setReservableRoom(ReservableRoom reservableRoom) {
        this.reservableRoom = reservableRoom;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
