package exam.controller;

import exam.domain.Proplem;
import exam.service.FileUploadService;
import exam.service.ProplemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/fileUpload")
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;
    @Autowired
    private ProplemService proplemService;

    private String parentPath = "E:";
    @ResponseBody
    @RequestMapping("/image")
    public String upload(MultipartFile file){
        if (file!=null){

            String originalFilename = file.getOriginalFilename();//获取文件原名

            String fileNameSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));//获取源文件后缀

            String newFileName = originalFilename+originalFilename.substring(originalFilename.lastIndexOf("."));//得到上传后新文件的文件名

            File fileNew = new File(parentPath+ File.separator+originalFilename);//创建一个新的File对象用于存放上传的文件

            try {
                file.transferTo(fileNew);//将图片写入磁盘
                return "success!";
            } catch (IOException e) {
                e.printStackTrace();
                return "fail!";
            }
        }
        return "fail";
    }

    @ResponseBody
    @PostMapping("/excel")
    public String excel(@RequestParam("file") MultipartFile file){
        try {
            List<Proplem> proplems = this.fileUploadService.proplemList(file.getInputStream());
            for (Proplem proplem : proplems) {
                this.proplemService.insert(proplem);
            }
            return "导入成功！";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "导入失败！";
    }
}
