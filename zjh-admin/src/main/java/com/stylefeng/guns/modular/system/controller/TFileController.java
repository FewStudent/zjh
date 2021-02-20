package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.config.properties.GunsProperties;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.core.util.ToolUtil;
import com.stylefeng.guns.modular.system.dao.TFileMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.modular.system.model.TFile;
import com.stylefeng.guns.modular.system.service.ITFileService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2019-09-19 19:02:32
 */
@Controller
@RequestMapping("/file")
public class TFileController extends BaseController {

    @Autowired
    private GunsProperties gunsProperties;
    @Autowired
    private ITFileService fileService;

    @GetMapping("/download")
    @ResponseBody
    public void download(String file_name, HttpServletResponse response) {
        String path = this.gunsProperties.getFileUploadPath();
        String fileName = path + file_name;
        if (fileName != null) {
            //设置文件路径
            File file = new File(fileName);
            //File file = new File(realPath , fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /**
     * 上传文件
     */
    @RequestMapping(method = RequestMethod.POST, path = "/upload")
    @ResponseBody
    public Object upload(@RequestPart("file") MultipartFile file) {
        String path = this.gunsProperties.getFileUploadPath();
        String fileName = UUID.randomUUID().toString() + "." + ToolUtil.getFileSuffix(file.getOriginalFilename());
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 转存文件
                file.transferTo(new File(path + fileName));
                TFile tFile = new TFile();
                tFile.setCreateTime(DateUtil.getTime());
                tFile.setOldFileName(file.getOriginalFilename());
                tFile.setNewFileName(fileName);
                this.fileService.insert(tFile);
                Map<String, Object> params = new HashMap<>();
                params.put("new_file_name", fileName);
                List<TFile> files = this.fileService.selectByMap(params);
                TFile file2 = files.get(0);
                return file2;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "error";
    }
}
