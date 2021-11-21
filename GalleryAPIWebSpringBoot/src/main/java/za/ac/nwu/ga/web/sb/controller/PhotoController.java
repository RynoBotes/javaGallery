package za.ac.nwu.ga.web.sb.controller;

import com.azure.storage.blob.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.nwu.ga.domain.dto.PhotoDto;
import za.ac.nwu.ga.domain.service.GeneralResponse;
import za.ac.nwu.ga.logic.flow.CreatePhotoFlow;
import za.ac.nwu.ga.logic.flow.FetchPhotoFlow;
import za.ac.nwu.ga.repo.persistence.PhotoRepository;
//import za.ac.nwu.ga.web.sb.exception.AzureBlobAdapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("photo-map")
public class PhotoController
{
    private final CreatePhotoFlow createPhotoFlow;
    private final FetchPhotoFlow fetchPhotoFlow;
//    private final AzureBlobAdapter azureAdapter;


    @Autowired
    public PhotoController(CreatePhotoFlow createPhotoFlow, FetchPhotoFlow fetchPhotoFlow/*AzureBlobAdapter azureAdapter*/) {
        this.createPhotoFlow = createPhotoFlow;
        this.fetchPhotoFlow = fetchPhotoFlow;
//        this.azureAdapter = azureAdapter;
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
        PhotoDto photo  = createPhotoFlow.create(photoDto);
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

    @GetMapping("{photoId}")
    @ApiOperation(value = "Retrieve specified photo ",notes = "Retrieved specified photo corresponding to photoId")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "photo retrieved"),
            @ApiResponse(code = 400,message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404,message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500,message = "Internal Server error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<PhotoDto>> getPhotoId(
            @ApiParam(value = "The id that uniquely identifies the photo.",
                    example = "3",
                    name = "photoId",
                    required = true)
            @PathVariable("photoId") final Long photoId) {
        PhotoDto photo = fetchPhotoFlow.getPhotoById(photoId);
        GeneralResponse<PhotoDto> response = new GeneralResponse<>(true, photo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping("delete/{photoId}")
    @ApiOperation(value = "Delete specified photo ",notes = "Delete specified photo corresponding to photoId")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "photo Deleted"),
            @ApiResponse(code = 400,message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404,message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500,message = "Internal Server error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<PhotoDto>> deletePhoto(
            @ApiParam(value = "The id that uniquely identifies the photo.",
                    example = "3",
                    name = "photoId",
                    required = true)
            @PathVariable("photoId") final Long photoId) {
        PhotoDto photo = fetchPhotoFlow.deletePhoto(photoId);
        GeneralResponse<PhotoDto> response = new GeneralResponse<>(true, photo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/uploadImage",method = RequestMethod.POST)
    public String uploadImage(@RequestParam("file") MultipartFile imageFile) throws IOException {
        createPhotoFlow.saveImage(imageFile);
        return "Success";
    }

//    @PostMapping("/upload")
//    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException
//    {
//        String constr = "DefaultEndpointsProtocol=https;AccountName=photogalleryrynobotes;AccountKey=rnfX8iDa9ZmHnRNR/1V+Aoq7o3ReWjXCmeQS/FqCynKWdDSReJbSJTL9je/gu+AlO46ZKStC+WQPzGugra2Biw==;EndpointSuffix=core.windows.net";
//
//        BlobContainerClient container = new BlobContainerClientBuilder()
//                .connectionString(constr)
//                .containerName("cat")
//                .buildClient();
//
//        BlobClient blob = container.getBlobClient(file.getOriginalFilename());
//
//        blob.upload(file.getInputStream(), file.getSize(), true);
//
//        return "Success";
//    }
}

