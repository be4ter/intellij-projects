package mrs.domain.service.room;

import mrs.domain.model.ReservableRoom;
import mrs.domain.repository.room.ReservaleRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class RoomService {
    @Autowired
    ReservaleRoomRepository reservaleRoomRepository;

    public List<ReservableRoom> findReservableRomms(LocalDateTime localDateTime) {
        return reservaleRoomRepository.findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(localDateTime);
    }
}
