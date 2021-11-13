package za.ac.nwu.ga.web.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ga.logic.flow.CreatePhotoFlow;

@RestController
@RequestMapping("photo-map")
public class PhotoController
{
    private final CreatePhotoFlow createPhotoFlow;

    @Autowired
    public PhotoController(CreatePhotoFlow createPhotoFlow) {
        this.createPhotoFlow = createPhotoFlow;
    }
}
