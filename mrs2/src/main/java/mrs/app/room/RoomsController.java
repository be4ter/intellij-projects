package mrs.app.room;

import mrs.domain.model.ReservableRoom;
import mrs.domain.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("rooms")
public class RoomsController {
    @Autowired
    RoomService roomService;

    @GetMapping("/list")
    String listRooms(Model model) {
        LocalDateTime today = LocalDateTime.now();
        List<ReservableRoom> rooms = roomService.findReservableRomms(today);
        model.addAttribute("date", today);
        model.addAttribute("rooms", rooms);
        return "/room/listRooms";
    }
}
