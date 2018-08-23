package mrs.domain.repository.room;

import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservaleRoomRepository extends JpaRepository<ReservableRoom, ReservableRoomId> {
    List<ReservableRoom> findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(LocalDateTime reservedDate);
}
