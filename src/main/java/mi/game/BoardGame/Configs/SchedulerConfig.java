package mi.game.BoardGame.Configs;

import mi.game.BoardGame.Models.Board;
import mi.game.BoardGame.Response.BoardResponse;
import mi.game.BoardGame.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class SchedulerConfig {

    @Autowired
    SimpMessagingTemplate template;

    @Autowired
    BoardService boardService;

    @Scheduled(fixedDelay = 500)
    public void sendAdhocMessages(){
        System.out.println("Messagee pushed");
        template.convertAndSend("/topic/board",new BoardResponse(boardService.getGameBoard(),boardService.getGameStatus(),boardService.getPlayerSymbol()));
    }

}
