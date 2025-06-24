package org.example.tools;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class ImgToBlob {

    public static byte[] toByteArray(MultipartFile file) throws IOException {
        return file.getBytes();
    }
}
