package tw.edu.ncu.cc.activity.server.web.api.v3

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import tw.edu.ncu.cc.activity.data.v1.Club
import tw.edu.ncu.cc.activity.server.entity.ClubEntity
import tw.edu.ncu.cc.activity.server.service.ClubService
import tw.edu.ncu.cc.activity.server.web.api.ApplicationController

@RestController
@RequestMapping( value = "v3/clubs", method = RequestMethod.GET )
public class ClubController extends ApplicationController {

    @Autowired
    def ClubService clubService

    @RequestMapping
    public Club[] index() {
        convert(
                clubService.findAll(), ClubEntity.class, Club.class
        )
    }

}
