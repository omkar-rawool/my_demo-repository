package com.crossasyst.imageupload.controller;

import com.crossasyst.imageupload.entity.ImageEntity;
import com.crossasyst.imageupload.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ImageController {
    private final ImageService imageService;

    @PostMapping(path = "/images")
    public ResponseEntity<String> saveImage(@RequestParam("image") MultipartFile multipartFile) {
        try {
            imageService.save(multipartFile);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("File uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Not found!!!");
        }
    }

    @GetMapping(path = "/images/{id}",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<InputStreamResource> getFile(@PathVariable Long id) {
        Optional<ImageEntity> imageEntityOptional = imageService.getImage(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=image.pdf");
        headers.add("Content-Type", "application/pdf");

        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(imageService.getImage(id).get().getData()));
        return ResponseEntity.ok().headers(headers).body(resource);

    }


    @GetMapping(path = "/getImages/{id}",produces = {MediaType.APPLICATION_PDF_VALUE,MediaType.IMAGE_PNG_VALUE})
    public ResponseEntity<Void> trial(@PathVariable Long id) throws IOException {
        imageService.getImageIntoPdf(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
