package com.crossasyst.imageupload.controller;

import com.crossasyst.imageupload.entity.ImageEntity;
import com.crossasyst.imageupload.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
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

    @GetMapping(path = "/images/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        Optional<ImageEntity> imageEntityOptional = imageService.getImage(id);

        if (imageEntityOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        ImageEntity imageEntity = imageEntityOptional.get();
        return ResponseEntity.ok()
                .body(imageEntity.getData());
    }
}
