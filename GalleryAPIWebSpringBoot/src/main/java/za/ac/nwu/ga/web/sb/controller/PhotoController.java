package za.ac.nwu.ga.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ga.domain.dto.MemberInfoDto;
import za.ac.nwu.ga.domain.dto.PhotoDto;
import za.ac.nwu.ga.domain.service.GeneralResponse;
import za.ac.nwu.ga.logic.flow.CreatePhotoFlow;
import za.ac.nwu.ga.logic.flow.FetchPhotoFlow;

import java.util.List;

@RestController
@RequestMapping("photo-map")
public class PhotoController
{
    private final CreatePhotoFlow createPhotoFlow;
    private final FetchPhotoFlow fetchPhotoFlow;

    @Autowired
    public PhotoController(CreatePhotoFlow createPhotoFlow, FetchPhotoFlow fetchPhotoFlow) {
        this.createPhotoFlow = createPhotoFlow;
        this.fetchPhotoFlow = fetchPhotoFlow;
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new photo.", notes = "Creates a new photo in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = "The photo was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400,message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<PhotoDto>> create(
            @ApiParam(value = "Request body to create a new member",required = true)
            @RequestBody PhotoDto photoDto) {
        PhotoDto photo = createPhotoFlow.create(photoDto);
        GeneralResponse<PhotoDto> response = new GeneralResponse<>(true, photo);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all configured photos",notes = "Returns a list of photos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "photos retrieved",response = GeneralResponse.class),
            @ApiResponse(code = 400,message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404,message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<PhotoDto>>> all()
    {
        List<PhotoDto> photos = fetchPhotoFlow.getAllPhotos();
        GeneralResponse<List<PhotoDto>> response = new GeneralResponse<>(true ,photos);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
