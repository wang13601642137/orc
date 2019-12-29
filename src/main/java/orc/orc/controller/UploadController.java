package orc.orc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by wenjin.wang on 2019/12/28.
 */

@Slf4j
@Controller
@RequestMapping(value = "upload")
public class UploadController {

    private String storePath = "/Users/wenjin.wang/Lab/source/orc/src/main/webapp/upload";

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file,
                         HttpServletRequest request) {
        log.info("上传文件开始：" + file.getName());
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            File filePath = new File(storePath, fileName);
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();// 如果目录不存在，则创建目录
            }
            try {
                file.transferTo(new File(storePath + File.separator + fileName));// 把文件写入目标文件地址
            } catch (Exception e) {
                e.printStackTrace();
               return "error";
            }
            return fileName;
        } else {
            return "error";
        }
    }
}
